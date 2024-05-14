package org.erp.productservice.measurement;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MeasurementForSelect {
    private UUID Id;
    private String nameStr;
}
