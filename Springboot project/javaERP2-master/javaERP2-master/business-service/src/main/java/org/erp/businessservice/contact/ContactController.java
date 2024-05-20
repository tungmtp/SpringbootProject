package org.erp.businessservice.contact;

import org.erp.businessservice.partner.Partner;
import org.erp.businessservice.partner.PartnerForSelect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/business-service/contact")
public class ContactController {
    @Autowired
    private ContactService contactService;

    @GetMapping
    public ResponseEntity<List<Contact>> getContact() {
        return new ResponseEntity<List<Contact>>(contactService.getAllContacts(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contact> getSingleContact(@PathVariable UUID id) {
        return new ResponseEntity<Contact>(contactService.getContactById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Contact> createContact(@RequestBody Contact contact) {
        return new ResponseEntity<Contact>(contactService.createContact(contact), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Contact> updateContact(@PathVariable UUID id, @RequestBody Contact contact) {
        return new ResponseEntity<Contact>(contactService.updateContact(id, contact), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteContact(@PathVariable UUID id) {
        contactService.deleteContact(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("byPartner/{partnerId}")
    public ResponseEntity<List<Contact>> selectContactByPartner(@PathVariable UUID partnerId) {
        return new ResponseEntity<List<Contact>>(contactService.selectContactByPartner(partnerId), HttpStatus.OK);
    }

    @GetMapping("/byNameStr/{query}")
    public ResponseEntity<List<ContactForSelect>> getItemContainingQuery(@PathVariable String query) {
        return new ResponseEntity<List<ContactForSelect>>(contactService.getItemContainingQuery(query), HttpStatus.OK);
    }

    @GetMapping("/firstCall/{id}")
    public ResponseEntity<List<ContactForSelect>> getItemFamiliar(@PathVariable UUID id) {
        return new ResponseEntity<List<ContactForSelect>>(contactService.getItemFamiliar(id), HttpStatus.OK);
    }

    @GetMapping("/oneForSelect/{id}")
    public ResponseEntity<ContactForSelect> oneForSelect(@PathVariable UUID id) {
        Contact xmeas = contactService.getContactById(id);
        ContactForSelect ymeas = new ContactForSelect(xmeas.getId(), xmeas.getNameStr());
        return new ResponseEntity<ContactForSelect>(ymeas, HttpStatus.OK);
    }
}
