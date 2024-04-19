package org.erp.businessservice.contactRelation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/business-service/contactRelation")
public class ContactRelationController {
    @Autowired
    private ContactRelationService contactRelationService;
    @GetMapping
    public ResponseEntity<List<ContactRelation>> getAllContactRelation() {
        return new ResponseEntity<List<ContactRelation>>(contactRelationService.allContactRelation(), HttpStatus.OK);
    }
    @GetMapping("/byContactID/{id}")
    public ResponseEntity<List<ContactRelation>> getContactRelationByContactId(@PathVariable UUID id) {
        return new ResponseEntity<List<ContactRelation>>(contactRelationService.getContactRelationByContactId(id), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ContactRelation> getSingleContactRelation(@PathVariable UUID id) {
        return new ResponseEntity<ContactRelation>(contactRelationService.singleContactRelation(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ContactRelation> createContactRelation(@RequestBody ContactRelation contactRelation) {
        return new ResponseEntity<ContactRelation>(contactRelationService.createContactRelation(contactRelation), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContactRelation> updateContactRelation(@PathVariable UUID id, @RequestBody ContactRelation contactRelation) {
        return new ResponseEntity<ContactRelation>(contactRelationService.updateContactRelation(id, contactRelation), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteContactRelation(@PathVariable UUID id) {
        contactRelationService.deleteContactRelation(id);
        return ResponseEntity.ok().build();
    }

}
