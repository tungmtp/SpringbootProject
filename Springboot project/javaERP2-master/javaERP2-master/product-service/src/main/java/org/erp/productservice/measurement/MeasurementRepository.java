package org.erp.productservice.measurement;

//import org.erp.employeeservice.department.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface MeasurementRepository extends JpaRepository<Measurement, UUID> {
}
