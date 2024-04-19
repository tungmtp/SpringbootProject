package org.erp.businessservice.contactRelation;
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
public class ContactRelation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID Id;

    @Column(name = "relTable", columnDefinition = "nvarchar(255)")
    private String relTable;
    @Column(name = "contactId")
    private UUID contactId;
    @Column(name = "relId")
    private UUID relId;
    @Column(name = "relType", columnDefinition = "nvarchar(255)")
    private String relType;
    @Column(name = "RelData", columnDefinition = "nvarchar(4000)")
    private String relData;

}
