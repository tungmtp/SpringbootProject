package org.erp.commonmodule.eventList;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
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

    @Column(name = "EventName", nullable = false, columnDefinition = "nvarchar(200)")
    private String eventName;

    @Column(name = "EventId", columnDefinition = "nvarchar(100)")
    private String eventId;

    @Column(name = "EventData", columnDefinition = "nvarchar(2000)")
    private String eventData;

    @Column(name = "userDispatch", columnDefinition = "varchar(100)")
    private String userDispatch;
    @Column(name = "instantData", columnDefinition = "varchar(100)")
    private String instantData;
    @Column(name = "timeOfDelay")
    private Integer timeOfDelay;
    @Column(name = "message", columnDefinition = "nvarchar(500)")
    private String message;
    @Column(name = "createdBy", columnDefinition = "varchar(100)")
    private String createdBy;
    @Column(name = "createdOn")
    private Timestamp createdOn;
}
