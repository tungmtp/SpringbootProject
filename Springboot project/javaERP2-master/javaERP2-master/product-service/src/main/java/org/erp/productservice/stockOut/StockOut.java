package org.erp.productservice.stockOut;

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
public class StockOut {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "slipDate", nullable = false)
    private Date slipDate;

    @Column(name = "Comment", columnDefinition = "ntext")
    private String comment;

    @Column(name = "relatedTable", columnDefinition = "nvarchar(50)")
    private String relatedTable;

    @Column(name = "relatedID")
    private UUID relatedID;

    @Column(name = "createdBy", nullable = false, columnDefinition = "nvarchar(50)")
    private String createdBy;

    @Column(name = "createdOn")
    private Date createdOn;

    @Column(name = "purpose")
    private Short purpose;

    @Column(name = "paymentDate")
    private Date paymentDate;

    @Column(name = "shipTo")
    private Integer shipTo;

    @Column(name = "lock")
    private Boolean lock;

    @Column(name = "Noidung", columnDefinition = "nvarchar(256)")
    private String noidung;

    @Column(name = "warehouseID", nullable = false)
    private int warehouseID;
}
