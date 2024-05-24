package org.erp.businessservice.orderDelivery;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderDeliveryWithPartner {
    private UUID id;
    private UUID orderID;
    private Date deliveryDate;
    private String deliveryAddress;
    private int warehouseID;
    private String createdBy;
    private Date createdOn;
    private boolean cancel;
    private boolean completed;
    private String partnerName;
    //den day
    private String productName;
    private Float quantity;
    private String measName;
    private Short quality;
}