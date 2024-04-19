package org.erp.businessservice.orderDelivery;

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
@Getter
@Setter
public class OrderDelivery {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "ordersID", nullable = false)
    private UUID ordersID;

    @Column(name = "deliveryDate", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date deliveryDate;

    @Column(name = "deliveryAddress", columnDefinition = "ntext")
    private String deliveryAddress;

    @Column(name = "warehouseID", nullable = false)
    private UUID warehouseID;

    @Column(name = "createdBy", nullable = false, columnDefinition = "nvarchar(16)")
    private String createdBy;

    @Column(name = "createdOn", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;

    @Column(name = "cancel", nullable = false)
    private boolean cancel;

    @Column(name = "completed", nullable = false)
    private boolean completed;

    @Column(name = "purpose", nullable = false)
    private int purpose;

    @Column(name = "paymentDate")
    @Temporal(TemporalType.DATE)
    private Date paymentDate;
}