package org.erp.productservice.stockIn;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface StockInRepository extends JpaRepository<StockIn, UUID> {
}
