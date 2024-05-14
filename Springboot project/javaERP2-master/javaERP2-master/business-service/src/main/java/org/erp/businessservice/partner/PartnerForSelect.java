package org.erp.businessservice.partner;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PartnerForSelect {
    private UUID Id;
    private String nameStr;
}
