package org.erp.produceservice.bom;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface BomRepository extends JpaRepository<Bom, UUID> {
    List<Bom> findByProductId(UUID uuid);

    @Query(value = """
            select aa.Id, aa.BOMID, aa.ProductID, aa.MeasID, aa.Quantity, bb.NameStr as ProductName, cc.MeasName\s
            FroM BOMInput aa inner join Product bb on aa.ProductID = bb.Id\s
            INNER JOIN Measurement cc on aa.MeasID  = cc.Id\s
            WHERE aa.BOMID = :bomID
            """, nativeQuery = true)
    List<Object[]> getInputOfBomId(@Param("bomID") UUID bomID);

    @Query(value = """
            Select NEWID() AS id, aa.*, bb.nameStr AS productName, cc.MeasName, dd.segmentName \s
            from dbo.ExtractBom(:productId, :measId, :reqDate, :reqQuantity) aa
            INNER JOIN Product bb ON aa.productID = bb.Id\s
            INNER JOIN Measurement cc ON aa.measID = cc.Id
            INNER JOIN Segment dd ON aa.segmentID = dd.Id\s
            ORDER BY aa.orderString\s
            FOR JSON PATH
            """, nativeQuery = true)
    List<String> extractBom(@Param("productId") String productId, @Param("measId") String measId, @Param("reqDate") String reqDate, @Param("reqQuantity") Double reqQuantity);
}
