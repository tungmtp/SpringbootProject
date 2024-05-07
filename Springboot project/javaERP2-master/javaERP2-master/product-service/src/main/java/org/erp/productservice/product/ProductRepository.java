package org.erp.productservice.product;

//import org.erp.employeeservice.department.Department;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {


    List<Product> findByExtraCategoryID(UUID extraCategoryID);

    @Query(value="SELECT new org.erp.productservice.product.ProductForSelect(Id, nameStr) FROM Product WHERE nameStr like %:query%")
    List<ProductForSelect> getProductContainingQuery(@Param("query") String name); //Kien

    @Procedure("GetFamiliarProduct")
//    @Transactional
    List<Object[]> getProductFirstCall(@Param("currID") UUID productID); //Kien
}
