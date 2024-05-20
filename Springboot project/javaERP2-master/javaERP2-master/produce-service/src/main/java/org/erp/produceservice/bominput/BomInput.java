package org.erp.produceservice.bominput;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "BOMInput")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BomInput {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID Id;
    @Column(name = "BOMID", nullable = false)
    private UUID bomId;
    @Column(name = "ProductID", nullable = false)
    private UUID productId;
    @Column(name = "MeasID", nullable = false)
    private UUID measId;
    @Column(name = "Quantity")
    private Double quantity;
}
