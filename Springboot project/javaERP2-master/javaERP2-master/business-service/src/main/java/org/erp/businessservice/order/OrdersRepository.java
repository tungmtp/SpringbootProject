package org.erp.businessservice.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.UUID;
@Repository
public interface OrdersRepository extends JpaRepository<Orders, UUID> {
    List<Orders> findByOrderDate(Date orderDate);
}
