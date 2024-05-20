package org.erp.produceservice.bom;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "BOM")
public class Bom {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID Id;
    @Column(name = "ProductID", nullable = false)
    private UUID productId;
    @Column(name = "MeasID", nullable = false)
    private UUID measId;
    @Column(name = "SegmentID", nullable = false)
    private UUID segmentId;
    @Column(name = "Quantity")
    private Double quantity;
    @Column(name = "TimeOfDelay")
    private Integer timeOfDelay;
    @Column(name = "BOMCode", columnDefinition = "nvarchar(255)")
    private String bomCode;
}
