package org.erp.businessservice.contactRelation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class ContactRelationService {
    @Autowired
    private ContactRelationRepository contactRelationRepository;

    public List<ContactRelation> allContactRelation() {
        return contactRelationRepository.findAll();
    }

    public List<ContactRelation> getContactRelationByContactId(UUID contactId) {
        return contactRelationRepository.findByContactId(contactId);
    }
    public ContactRelation singleContactRelation(UUID id) {
        return contactRelationRepository.findById(id).orElseThrow(() -> new RuntimeException("Không tìm thấy nguoi lien he này"));
    }

    public ContactRelation createContactRelation(ContactRelation ProductRelation) {
        return contactRelationRepository.save(ProductRelation);
    }

    public ContactRelation updateContactRelation(UUID id, ContactRelation contactRelation) {
        ContactRelation existingContactRelation = contactRelationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contact relation not found with id: " + id));

        if (contactRelation.getContactId() != null && !contactRelation.getContactId().equals(existingContactRelation.getContactId())) {
            existingContactRelation.setContactId(contactRelation.getContactId());
        }

        if (contactRelation.getRelId() != null && !contactRelation.getRelId().equals(existingContactRelation.getRelId())) {
            existingContactRelation.setRelId(contactRelation.getRelId());
        }

        if (contactRelation.getRelTable() != null && !contactRelation.getRelTable().equalsIgnoreCase(existingContactRelation.getRelTable())) {
            existingContactRelation.setRelTable(contactRelation.getRelTable());
        }

        if (contactRelation.getRelType() != null && !contactRelation.getRelType().equals(existingContactRelation.getRelType())) {
            existingContactRelation.setRelType(contactRelation.getRelType());
        }

        if (contactRelation.getRelData() != null && !contactRelation.getRelData().equals(existingContactRelation.getRelData())) {
            existingContactRelation.setRelData(contactRelation.getRelData());
        }

        return contactRelationRepository.save(existingContactRelation);
    }

    public void deleteContactRelation(UUID id) {
        contactRelationRepository.deleteById(id);
    }
}
