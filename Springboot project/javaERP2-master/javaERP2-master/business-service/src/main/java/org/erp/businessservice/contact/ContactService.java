package org.erp.businessservice.contact;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ContactService {
    @Autowired
    private ContactRepository contactRepository;

    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }

    public Contact getContactById(UUID id) {
        return contactRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contact not found with id: " + id));
    }

    public Contact createContact(Contact contact) {
        return contactRepository.save(contact);
    }

    public Contact updateContact(UUID id, Contact contact) {
        Contact existingContact = contactRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contact not found with id: " + id));

        if ( contact.getPartnersID() != null &&!contact.getPartnersID().equals(existingContact.getPartnersID())) {
            existingContact.setPartnersID(contact.getPartnersID());
        }
        if (contact.getNameStr() != null && !contact.getNameStr().equals(existingContact.getNameStr())) {
            existingContact.setNameStr(contact.getNameStr());
        }
        if (contact.getEmail() != null && !contact.getEmail().equals(existingContact.getEmail())) {
            existingContact.setEmail(contact.getEmail());
        }
        if (contact.getHandPhone() != null && !contact.getHandPhone().equals(existingContact.getHandPhone())) {
            existingContact.setHandPhone(contact.getHandPhone());
        }
        if (contact.getTitle() != null && !contact.getTitle().equals(existingContact.getTitle())) {
            existingContact.setTitle(contact.getTitle());
        }

        return contactRepository.save(existingContact);
    }

    public void deleteContact(UUID id) {
        contactRepository.deleteById(id);
    }

    public List<Contact> selectContactByPartner(UUID partnerId) {
        return contactRepository.selectContactByPartner(partnerId);
    }
}