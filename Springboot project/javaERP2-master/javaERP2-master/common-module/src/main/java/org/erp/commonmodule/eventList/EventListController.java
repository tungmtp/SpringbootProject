package org.erp.commonmodule.eventList;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/common-module/eventList")
public class EventListController {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private EventListService eventListService;

    @PostMapping
    public ResponseEntity<EventList> createSegment(@RequestBody EventList eventList, @RequestHeader("UserName") String userName) {
        EventList createdEvent = eventListService.createEvent(eventList);

        HttpHeaders headers = new HttpHeaders();
        headers.add("RequestType", "ADD_EVENT");
        headers.add("UserName", userName);

        ResponseEntity<EventList> response = ResponseEntity.status(HttpStatus.CREATED)
                .headers(headers)
                .body(createdEvent);

        rabbitTemplate.convertAndSend("javaguides_exchange", "javaguides_routing_key", response);

        return response;
    }

    @DeleteMapping("/{id}")
    public void deleteEventList(@PathVariable UUID id, @RequestHeader("UserName") String userName) {
        EventList delEvent = eventListService.deleteEvent(id);
        HttpHeaders headers = new HttpHeaders();
        headers.add("RequestType", "DELETE_EVENT");
        headers.add("UserName", userName);

        ResponseEntity<EventList> response = ResponseEntity.status(HttpStatus.CREATED)
                .headers(headers)
                .body(delEvent);

        rabbitTemplate.convertAndSend("javaguides_exchange", "javaguides_routing_key", response);

    }

    @GetMapping("/{name}")
    public ResponseEntity<List<EventList>> findBuEventName(@PathVariable String name) {
        return new ResponseEntity<>(eventListService.findByEventName(name), HttpStatus.OK);
    }

    @GetMapping("/inventoryLow")
    public ResponseEntity<String> inventoryLow() {
        
        return new ResponseEntity<>(eventListService.inventoryLow(), HttpStatus.OK);
    }
}
