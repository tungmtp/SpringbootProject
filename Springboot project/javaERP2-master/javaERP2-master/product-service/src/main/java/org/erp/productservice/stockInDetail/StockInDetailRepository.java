package org.erp.productservice.stockInDetail;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StockInDetailRepository extends JpaRepository<StockInDetail, UUID> {
}
