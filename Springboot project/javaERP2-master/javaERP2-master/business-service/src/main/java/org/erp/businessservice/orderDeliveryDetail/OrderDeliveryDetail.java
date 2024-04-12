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

    @Column(name = "ordersDeliveryID", nullable = false)
    private UUID ordersDeliveryID;

    @Column(name = "ordersDetailID", nullable = false)
    private UUID ordersDetailID;

    @Column(name = "productID", nullable = false)
    private UUID productID;

    @Column(name = "quality", nullable = false)
    private short quality;

    @Column(name = "quantity", nullable = false)
    private float quantity;

    @Column(name = "messID", nullable = false)
    private UUID messID;

    @Column(name = "price")
    private Float price;

    @Column(name = "VAT")
    private Float vat;
}