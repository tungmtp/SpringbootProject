package org.erp.businessservice.partner;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PartnerRepository extends JpaRepository<Partner, UUID> {
    @Query(value = "SELECT new org.erp.businessservice.partner.PartnerForSelect(Id, nameStr) FROM Partner WHERE nameStr like %:query%")
    List<PartnerForSelect> getItemContainingQuery(@Param("query") String query);

    @Query(value = "SELECT new org.erp.businessservice.partner.PartnerForSelect(Id, nameStr) FROM Partner WHERE partnerType = (SELECT partnerType FROM Partner WHERE Id = :query)")
    List<PartnerForSelect> getItemFamiliar(@Param("query") UUID query);

    @Query(value = "SELECT new org.erp.businessservice.partner.PartnerForSelect(Id, nameStr) FROM Partner")
    List<PartnerForSelect> getAllItemForSelect();
}
