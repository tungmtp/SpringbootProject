package org.erp.apigetway.eventList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventListService {

    @Autowired
    private EventListRepository eventListRepository;

    public EventList createEvent(EventList eventList) {
        EventList newEvent = eventListRepository.save(eventList);

        return newEvent;
    }
}
