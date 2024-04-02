package org.erp.produceservice.segment;

//import org.erp.employeeservice.department.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface SegmentRepository extends JpaRepository<Segment, UUID> {
}
