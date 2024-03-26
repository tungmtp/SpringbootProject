package org.erp.productservice.productRelation;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRelationRepository extends JpaRepository<ProductRelation, UUID> {
}
