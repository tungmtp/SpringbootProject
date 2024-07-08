package org.erp.productservice.stockIn;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface StockInRepository extends JpaRepository<StockIn, UUID> {
    @Query(value = "select * from StockIn where CAST(slipDate AS DATE) between :startDate and :endDate", nativeQuery = true)
    List<StockIn> getStockInByDate(@Param("startDate") String startDate, @Param("endDate") String endDate);

    @Query(value = """ 
            SELECT *, StockInDetail = (SELECT StockInDetail.*, Product.nameStr, Measurement.MeasName\s
                                        FROM StockInDetail\s
                                        INNER JOIN Product on Product.id = StockInDetail.productID\s
                                        INNER JOIN Measurement on Measurement.Id = StockInDetail.measID\s
                                        WHERE StockInDetail.stockInID = :stockInID	FOR JSON PATH )\s
             FROM StockIn WHERE StockIn.id = :stockInID FOR JSON PATH
            """, nativeQuery = true)
    List<String> getStockInDetailByStockInID(@Param("stockInID") String stockInID);

    StockIn findByRelatedTableAndRelatedID(String relatedTable, UUID relatedID);
}

