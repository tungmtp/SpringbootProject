package org.erp.productservice.product;

import jakarta.persistence.*;
import lombok.*;
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

    @Column(name = "catName", columnDefinition = "nvarchar(250)")
    private String catName;

    @Column(name = "isChildOf")
    private UUID isChildOf;


}

