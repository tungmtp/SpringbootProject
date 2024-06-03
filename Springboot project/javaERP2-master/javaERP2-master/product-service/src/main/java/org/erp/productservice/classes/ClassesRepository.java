package org.erp.productservice.classes;

//import org.erp.employeeservice.department.Department;

//import org.erp.productservice.measurement.MeasurementForSelect;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ClassesRepository extends JpaRepository<Classes, UUID> {
    //    @Query(value = "SELECT new org.erp.productservice.classes.ClassForSelect(Id, nameStr) FROM dbo.classes WHERE nameStr like %:query%")
    @Query(value = "SELECT new org.erp.productservice.classes.ClassForSelect(Id, nameStr) FROM Classes WHERE nameStr like %:query%")
    List<ClassForSelect> getClassContainingQuery(@Param("query") String name);

    @Query(value = "SELECT new org.erp.productservice.classes.ClassForSelect(Id, nameStr) FROM Classes")
    List<ClassForSelect> getClassFamiliar();
}
