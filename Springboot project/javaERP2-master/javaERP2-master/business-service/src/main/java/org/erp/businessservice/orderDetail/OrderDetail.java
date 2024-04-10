package org.erp.businessservice.orderDetail;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID Id;
    @Column(name = "orderID")
    private UUID orderID;
    @Column(name = "productID")
    private UUID productID;
    @Column(name = "measID")
    private UUID measID;
    @Column(name = "quality", columnDefinition = "int")
    private int quality;
    @Column(name = "quantity", columnDefinition = "float")
    private float quantity;
    @Column(name = "price", columnDefinition = "float")
    private float price;
    @Column(name = "confirmed")
    private boolean confirmed = false;
    @Column(name = "receiving")
    private boolean receiving = false;
    @Column(name = "completed")
    private boolean completed = false;
    @Column(name = "importTax", columnDefinition = "float")
    private float importTax;
    @Column(name = "rate", columnDefinition = "float")
    private float rate;
    @Column(name = "currency", columnDefinition = "varchar(10)")
    private String currency;






}

