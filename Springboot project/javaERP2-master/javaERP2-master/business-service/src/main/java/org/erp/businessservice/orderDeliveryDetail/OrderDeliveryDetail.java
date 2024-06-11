package org.erp.businessservice.orderDeliveryDetail;

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
public class OrderDeliveryDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "orderDeliveryID", nullable = false)
    private UUID orderDeliveryID;

    @Column(name = "orderDetailID", nullable = false)
    private UUID orderDetailID;

    @Column(name = "productID", nullable = false)
    private UUID productID;

    @Column(name = "quality", nullable = false)
    private short quality;

    @Column(name = "quantity", nullable = false)
    private Float quantity;

    @Column(name = "measID", nullable = false)
    private UUID measID;

    @Column(name = "price")
    private Float price;

    @Column(name = "VAT")
    private Float vat;
    @Column(name = "orderProduceID")
    private UUID orderProduceID;
}