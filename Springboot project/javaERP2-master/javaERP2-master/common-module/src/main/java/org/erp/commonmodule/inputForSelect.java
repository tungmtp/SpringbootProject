package org.erp.commonmodule;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class inputForSelect {
    private String currentItem;
    private String query;
    private boolean fetAll;
}
