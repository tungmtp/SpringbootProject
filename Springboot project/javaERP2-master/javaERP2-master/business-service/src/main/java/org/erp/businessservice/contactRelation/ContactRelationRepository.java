package org.erp.businessservice.contactRelation;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ContactRelationRepository extends JpaRepository<ContactRelation, UUID> {
    List<ContactRelation> findByContactId(UUID contactId);
}
