package org.erp.productservice.measurement;

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
public class Measurement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID Id;

    @Column(name = "MeasCatId", columnDefinition = "int")
    private int MeasCatId;
    @Column(name = "MeasName", columnDefinition = "nvarchar(50)")
    private String MeasName;
    @Column(name = "IsRoot")
    private boolean IsRoot = false;
    @Column(name = "RateInRoot", columnDefinition = "float")
    private float RateInRoot;
    @Column(name = "Length", columnDefinition = "float")
    private float Length;
    @Column(name = "Width", columnDefinition = "float")
    private float Width;
    @Column(name = "Height", columnDefinition = "float")
    private float Height;
    @Column(name = "UPC", columnDefinition = "int")
    private int UPC;


}

