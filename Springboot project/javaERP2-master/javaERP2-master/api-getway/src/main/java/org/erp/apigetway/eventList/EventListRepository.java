package org.erp.apigetway.eventList;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EventListRepository extends JpaRepository<EventList, UUID> {

}
