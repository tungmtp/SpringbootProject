package org.erp.productservice.productRelation;


import org.erp.productservice.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ProductRelationRepository extends JpaRepository<ProductRelation, UUID> {
    List<ProductRelation> findByProductId(UUID ProductId);
}
