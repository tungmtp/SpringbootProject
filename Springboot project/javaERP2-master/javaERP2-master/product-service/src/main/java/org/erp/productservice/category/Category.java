package org.erp.productservice.category;

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
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID Id;

    @Column(name = "catName", columnDefinition = "nvarchar(250)")
    private String catName;

    @Column(name = "isChildOf")
    private UUID isChildOf;


}

