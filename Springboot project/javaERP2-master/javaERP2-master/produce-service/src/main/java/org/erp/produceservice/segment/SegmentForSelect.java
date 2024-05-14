package org.erp.produceservice.segment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SegmentForSelect {
    private UUID Id;
    private String nameStr;
}
