package org.erp.productservice.stockOut;


import org.erp.productservice.stockIn.StockIn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface StockOutRepository extends JpaRepository<StockOut, UUID> {
    @Query(value = "select * from StockOut where slipDate between :startDate and :endDate", nativeQuery = true)
    List<StockOut> getStockOutByDate(@Param("startDate") String startDate, @Param("endDate") String endDate);

    @Query(value = """ 
            SELECT *, StockOutDetail = (SELECT StockOutDetail.*, Product.nameStr, Measurement.MeasName\s
                                        FROM StockOutDetail\s
                                        INNER JOIN Product on Product.id = StockOutDetail.productID\s
                                        INNER JOIN Measurement on Measurement.Id = StockOutDetail.measID\s
                                        WHERE StockOutDetail.stockOutID = :stockOutID FOR JSON PATH )\s
             FROM StockOut WHERE StockOut.id = :stockOutID FOR JSON PATH
            """, nativeQuery = true)
    List<String> getStockOutDetailByStockOutID(@Param("stockOutID") String stockOutID);
}
