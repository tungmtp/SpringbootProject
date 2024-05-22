package org.erp.produceservice.bom;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BomInputByBomId {
    private UUID Id;
    private UUID bomId;
    private UUID productId;
    private UUID measId;
    private Double quantity;
    private String productName;
    private String measName;
}
