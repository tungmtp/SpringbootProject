package org.erp.employeeservice.employeeRelation;
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
public class EmployeeRelation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID Id;

    @Column(name = "relTable", columnDefinition = "nvarchar(255)")
    private String relTable;
    @Column(name = "employeeId")
    private UUID employeeId;
    @Column(name = "relId")
    private UUID relId;
    @Column(name = "relType", columnDefinition = "nvarchar(255)")
    private String relType;
    @Column(name = "relData", columnDefinition = "nvarchar(4000)")
    private String relData;

}
