package org.erp.businessservice.orderDelivery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Repository
public interface OrderDeliverySQLRepository extends JpaRepository<OrderDelivery, UUID> {
    //    private UUID id;
//    private UUID orderID;
//    private Date deliveryDate;
//    private String deliveryAddress;
//    private int warehouseID;
//    private String createdBy;
//    private Date createdOn;
//    private boolean cancel;
//    private boolean completed;
//    private String partnerName; // DEN DAY

    @Query(value = """ 
            select aa.*, bb.partnersID, cc.nameStr AS partnerName, bb.projectID, \s
                deliveryDetail = (SELECT OrderDeliveryDetail.*, Product.nameStr as productName, Measurement.MeasName\s
                                                                   FROM OrderDeliveryDetail\s
                                                                   INNER JOIN Product ON OrderDeliveryDetail.productID = Product.Id\s
                                                                   INNER JOIN Measurement ON OrderDeliveryDetail.measID = Measurement.Id \s
                                                                   WHERE OrderDeliveryDetail.orderDeliveryID = aa.id FOR JSON PATH) \s
                from OrderDelivery aa\s
                INNER JOIN Orders bb ON aa.orderID = bb.id\s
                INNER JOIN Partner cc ON bb.partnersID = cc.id\s
                WHERE aa.deliveryDate = :deliveryDate FOR JSON PATH\s
            """, nativeQuery = true)
    List<String> getOrderDeliveryByDeliveryDate(@Param("deliveryDate") String mDate);

    @Query(value = """ 
            select aa.*, bb.partnersID, cc.nameStr AS partnerName, bb.projectID, \s
                deliveryDetail = (SELECT OrderDeliveryDetail.*, Product.nameStr as productName, Measurement.MeasName\s
                                                                   FROM OrderDeliveryDetail\s
                                                                   INNER JOIN Product ON OrderDeliveryDetail.productID = Product.Id\s
                                                                   INNER JOIN Measurement ON OrderDeliveryDetail.measID = Measurement.Id WHERE OrderDeliveryDetail.orderDeliveryID = aa.id FOR JSON PATH) \s
                from OrderDelivery aa\s
                INNER JOIN Orders bb ON aa.orderID = bb.id\s
                INNER JOIN Partner cc ON bb.partnersID = cc.id\s
                WHERE aa.orderID = :orderID FOR JSON PATH\s
            """, nativeQuery = true)
    List<String> getOrderDeliveryByOrderID(@Param("orderID") String OrderID);

    @Query(value = """ 
            select aa.*, bb.partnersID, cc.nameStr AS partnerName, bb.projectID, \s
                deliveryDetail = (SELECT OrderDeliveryDetail.*, Product.nameStr as productName, Measurement.MeasName, Measurement.RateInRoot\s
                                                                   FROM OrderDeliveryDetail\s
                                                                   INNER JOIN Product ON OrderDeliveryDetail.productID = Product.Id\s
                                                                   INNER JOIN Measurement ON OrderDeliveryDetail.measID = Measurement.Id WHERE OrderDeliveryDetail.orderDeliveryID = aa.id FOR JSON PATH) \s
                from OrderDelivery aa\s
                INNER JOIN Orders bb ON aa.orderID = bb.id\s
                INNER JOIN Partner cc ON bb.partnersID = cc.id\s
                WHERE aa.id = :id FOR JSON PATH\s
            """, nativeQuery = true)
    List<String> getOrderDeliveryById(@Param("id") String id);

    @Query(value = """ 
            select aa.*, bb.partnersID, cc.nameStr AS partnerName, bb.projectID, \s
                deliveryDetail = (SELECT OrderDeliveryDetail.*, Product.nameStr as productName, Measurement.MeasName, Measurement.RateInRoot\s
                                                                   FROM OrderDeliveryDetail\s
                                                                   INNER JOIN Product ON OrderDeliveryDetail.productID = Product.Id\s
                                                                   INNER JOIN Measurement ON OrderDeliveryDetail.measID = Measurement.Id WHERE OrderDeliveryDetail.orderDeliveryID = aa.id FOR JSON PATH) \s
                from OrderDelivery aa\s
                INNER JOIN Orders bb ON aa.orderID = bb.id\s
                INNER JOIN Partner cc ON bb.partnersID = cc.id\s
                WHERE aa.id = :id FOR JSON PATH\s
            """, nativeQuery = true)
    List<String> getOrderDeliveryById2(@Param("id") String id);

    @Query(value = "SELECT * FROM dbo.getDeliveryByReqDateOfOrder(:orderID, :reqDate) FOR JSON PATH", nativeQuery = true)
    List<String> getDeliveryByReqDateOfOrder(@Param("orderID") String orderID, @Param("reqDate") String reqDate);
}
