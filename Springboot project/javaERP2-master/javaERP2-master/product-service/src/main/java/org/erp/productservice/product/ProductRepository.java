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

    @Query(value = "SELECT new org.erp.productservice.product.ProductForSelect(Id, nameStr) FROM Product WHERE nameStr like %:query%")
    List<ProductForSelect> getProductContainingName(@Param("query") String name); //Kien

    @Procedure("GetFamiliarProduct")
//    @Transactional
    List<Object[]> getProductFirstCall(@Param("currID") UUID productID); //Kien

//    @Query(value="DELETE FROM Product WHERE Id = :id")
//    int sqlDelete(@Param("id") UUID uuid);

    @Query(value = "SELECT new org.erp.productservice.product.ProductForSelect(Id, nameStr) FROM Product WHERE (mayBeSell = true) AND (nameStr like %:query%)")
    List<ProductForSelect> getProductMayBeSellContainingName(@Param("query") String name); //Kien

    @Query(value = "select new org.erp.productservice.product.ProductForSelect(Id, nameStr) from Product where (mayBeSell = true) AND (extraCategoryID = (Select extraCategoryID from Product where Id = :query))")
    List<ProductForSelect> getProductMaBeSellFirstCall(@Param("query") UUID uuid);

    @Query(value = "select new org.erp.productservice.product.ProductWithMeasurement(aa.Id, aa.nameStr, aa.MeasID, bb.RateInRoot, bb.MeasCatId, bb.MeasName) FROM Product aa INNER JOIN Measurement bb ON aa.MeasID = bb.Id WHERE aa.Id = :query")
    List<ProductWithMeasurement> getProductWithMeasurement(@Param("query") UUID uuid);

    @Query(value = "SELECT Id, nameCount FROM ProductBOM WHERE (nameStr like %:query%)", nativeQuery = true)
    List<Object[]> getProductMayBeProduceContainingName(@Param("query") String name); //Kien

    @Query(value = "select Id, nameCount from ProductBOM where (extraCategoryID = (Select extraCategoryID from Product where Id = :query))", nativeQuery = true)
    List<Object[]> getProductMayBeProduceFirstCall(@Param("query") UUID query);

    @Query(value = "select Id, nameStr, ISNULL(mCount, 0) from ProductBOM", nativeQuery = true)
    List<Object[]> getProductMayBeProduce();

    @Query(value = "select dbo.PhysicalStock(:productId, :measId, :dateCheck) AS tonkho FOR JSON PATH", nativeQuery = true)
    List<String> physicalStock(@Param("productId") String productId, @Param("measId") String measId, @Param("dateCheck") String dateCheck);


    @Query(value = "select * FROM dbo.AllProductInOneWarehouse(:warehouseId, :fromDate, :toDate, :quality) order by ExtraCategoryID, NameStr FOR JSON PATH", nativeQuery = true)
    List<String> allProductInOneWarehouse(@Param("warehouseId") int warehouseId, @Param("fromDate") String fromDate, @Param("toDate") String toDate, @Param("quality") int quality);

    //SELECT * FROM dbo.GetInOutOneProductAtOneWarehouse(2, '2024-06-01', '2024-08-15', 'FC464B7B-8264-4E98-A191-5096B419B5ED') ORDER BY ngayXN, mOrder FOR JSON PATH
    @Query(value = "select * FROM dbo.GetInOutOneProductAtOneWarehouse(:warehouseId, :fromDate, :toDate, :productId) ORDER BY ngayXN, mOrder FOR JSON PATH", nativeQuery = true)
    List<String> getInOutOneProductAtOneWarehouse(@Param("warehouseId") int warehouseId,
                                                  @Param("fromDate") String fromDate,
                                                  @Param("toDate") String toDate,
                                                  @Param("productId") String productId);

    @Query(value = "select * FROM dbo.OneProductAtAllWarehouse(:productID, :lastDate) FOR JSON PATH", nativeQuery = true)
    List<String> oneProductAtAllWarehouse(@Param("productID") UUID productId, @Param("lastDate") String fromDate);

    @Query(value = "SELECT * FROM dbo.AllProducByAttrAtAllWarehouse(:productAttrID, :lastDate) FOR JSON PATH", nativeQuery = true)
    List<String> allProductByAttrAtAllWarehouse(@Param("productAttrID") String productAttrId, @Param("lastDate") String lastDate);
}
