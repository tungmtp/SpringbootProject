package org.erp.productservice.productAttribute;

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
public class ProductAttribute {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID Id;

    @Column(name = "attName", columnDefinition = "nvarchar(250)")
    private String attName;

    @Column(name = "isChildOf")
    private UUID isChildOf;


}

