package org.erp.employeeservice.department;

import jakarta.persistence.*;
import lombok.*;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID Id;

    @Column(name = "deptName", columnDefinition = "nvarchar(50)")
    private String deptName;

    @Column(name = "isChildOf")
    private UUID isChildOf;

    @Column(name = "isActive")
    private Boolean isActive = true;
}

