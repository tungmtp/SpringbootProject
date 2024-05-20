package org.erp.businessservice.contact;

import org.erp.businessservice.partner.PartnerForSelect;
import org.hibernate.annotations.Parameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ContactRepository extends JpaRepository<Contact, UUID> {
    @Query(value = "SELECT c, cr FROM Contact c INNER JOIN ContactRelation cr ON (c.id = cr.contactId AND cr.relTable = 'Partner' AND cr.relId = :partnerId)")
    List<Contact> selectContactByPartner(@Param("partnerId") UUID partnerID);

    @Query(value = "SELECT new org.erp.businessservice.contact.ContactForSelect(Id, nameStr) FROM Contact WHERE nameStr like %:query%")
    List<ContactForSelect> getItemContainingQuery(@Param("query") String query);

    @Query(value = "SELECT new org.erp.businessservice.contact.ContactForSelect(c.Id, nameStr) FROM Contact c INNER JOIN ContactRelation cr ON (c.id = cr.contactId AND cr.relTable = 'Partner' AND cr.relId = :partnerId)")
    List<ContactForSelect> getItemFamiliar(@Param("partnerId") UUID partnerID);
}
