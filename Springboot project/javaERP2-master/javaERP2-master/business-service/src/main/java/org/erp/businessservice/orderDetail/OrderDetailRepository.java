package org.erp.businessservice.orderDetail;

import org.erp.businessservice.order.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, UUID> {
    List<OrderDetail> findByOrderID(UUID orderID);

    @Query(value = "SELECT * FROM dbo.deliveryByShcedule(:reqDate) FOR JSON PATH", nativeQuery = true)
    List<String> deliveryByShcedule(@Param("reqDate") String reqDate);
}
