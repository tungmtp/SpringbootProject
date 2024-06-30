package org.erp.commonmodule.eventList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface EventListRepository extends JpaRepository<EventList, UUID> {

    @Query(value = "SELECT COUNT(productId) AS mCount FROM dbo.inventoryLow()", nativeQuery = true)
    Long getInventoryLowCount();

    @Query(value = "SELECT * FROM dbo.inventoryLow() FOR JSON PATH", nativeQuery = true)
    List<String> inventoryLow();

    List<EventList> findByEventName(String name);

    List<EventList> findByEventIdAndEventName(String eventId, String eventName);

    void deleteByEventIdAndEventName(String eventId, String eventName);
}
