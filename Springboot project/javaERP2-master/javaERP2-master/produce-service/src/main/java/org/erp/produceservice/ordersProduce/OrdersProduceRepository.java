package org.erp.produceservice.ordersProduce;

import org.erp.produceservice.bom.Bom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface OrdersProduceRepository extends JpaRepository<OrdersProduce, UUID> {
   
}
