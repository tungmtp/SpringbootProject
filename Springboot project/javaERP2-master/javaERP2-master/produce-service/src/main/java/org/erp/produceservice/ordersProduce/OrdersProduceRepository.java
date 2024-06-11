package org.erp.produceservice.ordersProduce;

import org.erp.produceservice.bom.Bom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface OrdersProduceRepository extends JpaRepository<OrdersProduce, UUID> {
    @Query(value = "SELECT * FROM dbo.OrderRequestSumary(:orderID) FOR JSON PATH", nativeQuery = true)
    List<String> orderRequestSumary(@Param("orderID") UUID uuid);

    @Query(value = "SELECT * FROM dbo.OrderRequestDistinctDate(:orderID) FOR JSON PATH", nativeQuery = true)
    List<String> orderRequestDistinctDate(@Param("orderID") UUID uuid);

    @Query(value = "SELECT * FROM dbo.getOrderRequestByOrderIdAndDate(:orderId, :mDate)  FOR JSON PATH", nativeQuery = true)
    List<String> getOrderRequestByOrderIdAndDate(@Param("orderId") UUID uuid, @Param("mDate") String mDate);
}
