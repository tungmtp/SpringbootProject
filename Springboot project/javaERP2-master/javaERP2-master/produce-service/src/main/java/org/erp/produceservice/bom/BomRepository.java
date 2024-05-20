package org.erp.produceservice.bom;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface BomRepository extends JpaRepository<Bom, UUID> {
    List<Bom> findByProductId(UUID uuid);
}
