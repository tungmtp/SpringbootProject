package org.erp.productservice.stockInDetail;
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
public class StockInDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false) // ID là khóa chính và không được null
    private UUID id;

    @Column(name = "stocklnlD", nullable = false)
    private UUID stockInId;

    @Column(name = "productID", nullable = false)
    private UUID productId;

    @Column(name = "messlD", nullable = false)
    private UUID messageId;

    @Column(name = "quality", nullable = false)
    private Short quality;

    @Column(name = "quantity", nullable = false)
    private Float quantity;

    @Column(name = "relatedTable", columnDefinition = "nvarchar(50)")
    private String relatedTable;

    @Column(name = "relatedID")
    private UUID relatedId;

    @Column(name = "createdBy", nullable = false, columnDefinition = "nvarchar(50)")
    private String createdBy;

    @Column(name = "createdOn")
    private Date createdOn;

    @Column(name = "price", nullable = false)
    private Float price;

    @Column(name = "VAT", nullable = false)
    private Float vat;

    @Column(name = "priceType", columnDefinition = "tinyint")
    private Byte priceType;

    @Column(name = "importTax")
    private Float importTax;

    @Column(name = "currency", length = 10)
    private String currency;

    @Column(name = "rate")
    private Float rate;
}
