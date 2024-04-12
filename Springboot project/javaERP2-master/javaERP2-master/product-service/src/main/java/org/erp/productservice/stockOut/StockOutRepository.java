package org.erp.productservice.stockOut;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StockOutRepository extends JpaRepository<StockOut, UUID> {
}
