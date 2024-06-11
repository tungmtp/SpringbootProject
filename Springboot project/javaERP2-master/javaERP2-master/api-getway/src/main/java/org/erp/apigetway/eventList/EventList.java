package org.erp.apigetway.eventList;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EventList {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "createdBy", nullable = false, columnDefinition = "varchar(100)")
    private String nameStr;

    @Column(name = "EventName", nullable = false, columnDefinition = "nvarchar(200)")
    private String eventName;

    @Column(name = "EventId", nullable = false, columnDefinition = "nvarchar(100)")
    private String eventId;

    @Column(name = "EventData", columnDefinition = "nvarchar(2000)")
    private String eventData;
}
