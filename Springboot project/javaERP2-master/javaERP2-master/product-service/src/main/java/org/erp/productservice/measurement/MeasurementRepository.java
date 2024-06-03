package org.erp.productservice.measurement;

//import org.erp.employeeservice.department.Department;

import org.erp.productservice.product.ProductForSelect;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface MeasurementRepository extends JpaRepository<Measurement, UUID> {
    @Query(value = "SELECT new org.erp.productservice.measurement.MeasurementForSelect(Id, MeasName) FROM Measurement WHERE MeasName like %:query%")
    List<MeasurementForSelect> getMeasurementContainingQuery(@Param("query") String name);

    @Query(value = "select new org.erp.productservice.measurement.MeasurementForSelect(Id, MeasName) from Measurement where MeasCatId = (Select MeasCatId from Measurement where Id = :query)")
    List<MeasurementForSelect> getMeasurementFamiliar(@Param("query") UUID measID);

    @Query(value = "SELECT new org.erp.productservice.measurement.MeasurementForSelect(Id, MeasName) FROM Measurement ")
    List<MeasurementForSelect> getAllItemForSelect();
}
