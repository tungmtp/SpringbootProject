package org.erp.productservice.productRelation;
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
public class ProductRelation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID Id;

    @Column(name = "RelTable", columnDefinition = "nvarchar(255)")
    private String relTable;
    @Column(name = "ProductId")
    private UUID productId;
    @Column(name = "RelId")
    private UUID relId;
    @Column(name = "RelType", columnDefinition = "nvarchar(255)")
    private String relType;
    @Column(name = "RelData", columnDefinition = "nvarchar(4000)")
    private String relData;

}
