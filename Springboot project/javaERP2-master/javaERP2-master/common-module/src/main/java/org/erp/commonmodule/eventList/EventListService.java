package org.erp.commonmodule.eventList;

import jakarta.transaction.Transactional;
import jdk.jfr.Event;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class EventListService {

    @Autowired
    private EventListRepository eventListRepository;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public EventList createEvent(EventList eventList) {
        return eventListRepository.save(eventList);
    }

    public EventList deleteEvent(UUID uuid) {
        EventList delEvent = eventListRepository.findById(uuid)
                .orElseThrow(() -> new RuntimeException("Khong tim thay ID nay: " + uuid.toString()));
        eventListRepository.deleteById(uuid);
        return delEvent;
    }

    @Transactional
    public List<EventList> deleteEventByEventIdAndEventName(String uuid, String eventName) {
        List<EventList> delEvent = eventListRepository.findByEventIdAndEventName(uuid, eventName);
        eventListRepository.deleteByEventIdAndEventName(uuid, eventName);
        return delEvent;
    }

    public List<EventList> findByEventName(String name) {
        return eventListRepository.findByEventName(name);
    }

    public Long getInventoryLowCount() {
        return eventListRepository.getInventoryLowCount();
    }

    public String inventoryLow() {
        List<String> results = eventListRepository.inventoryLow();
        return String.join("", results);
    }

    /**
     * SCHEDULED AREA, DON'T ADD ANY METHOD HERE
     **/
//    @Scheduled(fixedRate = 10 * 60 * 1000)
    @Scheduled(cron = "0 0 22 * * ?")
    public void performCheckMinimumStock() {
        Long mCount = getInventoryLowCount();
        if (mCount > 0) {
            EventList eventList = new EventList();
            eventList.setEventName("INVENTORY LOW COUNT");
            eventList.setEventId(UUID.randomUUID().toString());
            eventList.setEventData("{\"count\": " + mCount.toString() + "}");
            eventList.setUserDispatch("SERVER");
            eventList.setCreatedBy("Scheduled");
            eventList.setMessage("There are " + mCount.toString() + " products with inventory levels less than the allowed level.");
            eventList.setInstantData(mCount.toString());
            eventList.setTimeOfDelay(24 * 60);
            EventList createdEvent = eventListRepository.save(eventList);

            HttpHeaders headers = new HttpHeaders();
            headers.add("RequestType", "ADD_EVENT");
            headers.add("UserName", "SERVER");

            ResponseEntity<EventList> response = ResponseEntity.status(HttpStatus.CREATED)
                    .headers(headers)
                    .body(createdEvent);
            rabbitTemplate.convertAndSend("javaguides_exchange", "javaguides_routing_key", response);
        }
//        System.out.println("Inventory low count checking - " + mCount.toString());
    }

    @Scheduled(fixedRate = 5 * 60 * 1000)
    public void eventGarbageCollector() {
        List<EventList> results = eventListRepository.findAll();
        for (EventList item : results) {
            LocalDateTime now = LocalDateTime.now();
            Duration duration = Duration.between(item.getCreatedOn().toLocalDateTime(), now);
            if (item.getTimeOfDelay() == null || duration.getSeconds() > item.getTimeOfDelay() * 60) {
//                System.out.println(item.getEventName() + " " + item.getEventId());
                eventListRepository.deleteById(item.getId());
                HttpHeaders headers = new HttpHeaders();
                headers.add("RequestType", "DELETE_EVENT");
                headers.add("UserName", "SERVER");

                ResponseEntity<EventList> response = ResponseEntity.status(HttpStatus.CREATED)
                        .headers(headers)
                        .body(item);
                rabbitTemplate.convertAndSend("javaguides_exchange", "javaguides_routing_key", response);
            }
        }
    }

    /** END OF SCHEDULED AREA **/
}
