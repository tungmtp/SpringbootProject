package org.erp.produceservice.segment;

//import org.erp.employeeservice.department.Department;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface SegmentRepository extends JpaRepository<Segment, UUID> {
    @Query(value = "SELECT new org.erp.produceservice.segment.SegmentForSelect(Id, segmentName) FROM Segment WHERE segmentName like %:query%")
    List<SegmentForSelect> getItemContainingQuery(@Param("query") String query);

    @Query(value = "SELECT new org.erp.produceservice.segment.SegmentForSelect(Id, segmentName) FROM Segment")
    List<SegmentForSelect> getItemFamiliar();

}
