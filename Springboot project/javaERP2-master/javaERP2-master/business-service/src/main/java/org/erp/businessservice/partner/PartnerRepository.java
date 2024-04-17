package org.erp.businessservice.partner;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface PartnerRepository extends JpaRepository<Partner, UUID> {
}
