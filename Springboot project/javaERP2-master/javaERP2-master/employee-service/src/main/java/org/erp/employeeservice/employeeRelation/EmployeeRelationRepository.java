package org.erp.employeeservice.employeeRelation;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface EmployeeRelationRepository extends JpaRepository<EmployeeRelation, UUID> {
    List<EmployeeRelation> findByEmployeeId(UUID employeeId);
}
