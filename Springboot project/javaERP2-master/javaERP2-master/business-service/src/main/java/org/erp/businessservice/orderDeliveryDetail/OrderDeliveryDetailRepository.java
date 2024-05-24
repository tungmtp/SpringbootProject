package org.erp.businessservice.orderDeliveryDetail;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface OrderDeliveryDetailRepository extends JpaRepository<OrderDeliveryDetail, UUID> {
    List<OrderDeliveryDetail> findByOrderDeliveryID(UUID orderDeliveryID);
}
