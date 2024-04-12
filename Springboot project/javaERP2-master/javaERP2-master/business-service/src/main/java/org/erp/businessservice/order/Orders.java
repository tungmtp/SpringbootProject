package org.erp.businessservice.order;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "orderType", nullable = false)
    private short orderType;

    @Column(name = "orderDate", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date orderDate;

    @Column(name = "endDate", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date endDate;

    @Column(name = "comment")
    private String comment;

    @Column(name = "partnersID", nullable = false)
    private UUID partnersID;

    @Column(name = "projectID")
    private UUID projectID;

    @Column(name = "contactID")
    private UUID contactID;

    @Column(name = "staffControl", length = 16)
    private String staffControl;

    @Column(name = "complete", nullable = false)
    private boolean complete;

    @Column(name = "createdBy", nullable = false, length = 16)
    private String createdBy;

    @Column(name = "createdOn", nullable = false)
    private Date createdOn;

    @Column(name = "calcType")
    private int calcType;

    @Column(name = "lotNo", length = 50)
    private String lotNo;

    @Column(name = "projectitemID")
    private UUID projectitemID;

    @Column(name = "editBy", length = 16)
    private String editBy;
}