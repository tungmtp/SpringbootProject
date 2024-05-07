package org.erp.produceservice.segment;

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
public class Segment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID Id;
    @Column(name = "segmentName", columnDefinition = "nvarchar(50)")
    private String segmentName;
    @Column(name = "productGroup", columnDefinition = "nvarchar(50)", nullable = false)
    private String productGroup;
    @Column(name = "orderLevel", columnDefinition = "int", nullable = false)
    private int orderLevel;
    @Column(name = "subCATID")
    private UUID subCATID;
    @Column(name = "skipCalendar")
    private boolean skipCalendar = false;
    @Column(name = "Prefix", columnDefinition = "varchar(50)")
    private String Prefix;

}

