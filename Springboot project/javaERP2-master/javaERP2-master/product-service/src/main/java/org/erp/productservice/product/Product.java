package org.erp.productservice.product;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID Id;
    @Column(name = "nameStr", columnDefinition = "nvarchar(256)", nullable = false)
    private String nameStr;
    @Column(name = "measID", nullable = false)
    private UUID MeasID;
    @Column(name = "extraCategoryID", nullable = false)
    private UUID extraCategoryID;
    @Column(name = "minimumStock",columnDefinition = "float", nullable = false)
    private float minimumStock;
    @Column(name = "mayBeBuy")
    private boolean mayBeBuy = false;
    @Column(name = "mayBeProduce")
    private boolean mayBeProduce = false;
    @Column(name = "mayBeSell")
    private boolean mayBeSell = false;
    @Column(name = "canSellWithOutStock")
    private boolean canSellWithOutStock = false;
    @Column(name = "disContinue")
    private boolean disContinue = false;
    @Column(name = "classPriceID", nullable = false)
    private UUID classPriceID;
    @Column(name = "segmentID")
    private UUID segmentID;
    @Column(name = "comment", columnDefinition = "ntext")
    private String comment;
    @Column(name = "copyFrom")
    private UUID copyFrom;
    @Column(name = "createdOn", columnDefinition = "date")
    private Date createdOn;
}

