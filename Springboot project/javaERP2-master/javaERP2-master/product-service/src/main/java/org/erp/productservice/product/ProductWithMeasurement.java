package org.erp.productservice.product;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductWithMeasurement {
    //aa.measID, bb.RateInRoot, bb.MeasCatId
    private UUID Id;
    private String nameStr;
    private UUID measID;
    private float RateInRoot;
    private int MeasCatId;
    private String MeasName;
}
