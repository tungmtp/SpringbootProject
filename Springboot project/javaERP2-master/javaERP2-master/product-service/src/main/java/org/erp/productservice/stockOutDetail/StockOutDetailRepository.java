package org.erp.productservice.stockOutDetail;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StockOutDetailRepository extends JpaRepository<StockOutDetail, UUID> {
}
