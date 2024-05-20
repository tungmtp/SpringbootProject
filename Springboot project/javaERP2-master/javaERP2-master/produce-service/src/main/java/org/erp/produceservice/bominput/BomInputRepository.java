package org.erp.produceservice.bominput;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface BomInputRepository extends JpaRepository<BomInput, UUID> {
    List<BomInput> findByBomId(UUID uuid);
}
