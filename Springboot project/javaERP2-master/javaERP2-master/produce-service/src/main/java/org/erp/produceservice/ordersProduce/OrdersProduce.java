package org.erp.produceservice.ordersProduce;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "OrdersProduce")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrdersProduce {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "OrdersID", nullable = false)
    private UUID ordersID;

    @Column(name = "OrderDetailID", nullable = false)
    private UUID orderDetailID;

    @Column(name = "Quantity")
    private Double quantity = 0.0;

    @Column(name = "ReqDate")
    @Temporal(TemporalType.DATE)
    private Date reqDate;

    @Column(name = "Comment", columnDefinition = "ntext")
    private String comment;

    @Column(name = "Generated")
    private boolean generated = false;

    @Column(name = "MarkDone")
    private boolean markDone = false;
}
