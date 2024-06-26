package org.erp.businessservice.partner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/business-service/partner")
public class PartnerController {
    @Autowired
    private PartnerService partnerService;

    @GetMapping
    public ResponseEntity<List<Partner>> getPartner() {
        return new ResponseEntity<List<Partner>>(partnerService.getAllPartners(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Partner> getSinglePartner(@PathVariable UUID id) {
        return new ResponseEntity<Partner>(partnerService.getPartnerById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Partner> createPartner(@RequestBody Partner partner) {
        return new ResponseEntity<Partner>(partnerService.createPartner(partner), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Partner> updatePartner(@PathVariable UUID id, @RequestBody Partner partner) {
        return new ResponseEntity<Partner>(partnerService.updatePartner(id, partner), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePartner(@PathVariable UUID id) {
        partnerService.deletePartner(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/byNameStr/{query}")
    public ResponseEntity<List<PartnerForSelect>> getItemContainingQuery(@PathVariable String query) {
        if ("all".equalsIgnoreCase(query)) {
            return new ResponseEntity<List<PartnerForSelect>>(partnerService.getAllItemForSelect(), HttpStatus.OK);
        } else {
            return new ResponseEntity<List<PartnerForSelect>>(partnerService.getItemContainingQuery(query), HttpStatus.OK);
        }
    }

    @GetMapping("/firstCall/{id}")
    public ResponseEntity<List<PartnerForSelect>> getItemFamiliar(@PathVariable UUID id) {
        return new ResponseEntity<List<PartnerForSelect>>(partnerService.getItemFamiliar(id), HttpStatus.OK);
    }

    @GetMapping("/oneForSelect/{id}")
    public ResponseEntity<PartnerForSelect> oneForSelect(@PathVariable UUID id) {
        Partner xmeas = partnerService.getPartnerById(id);
        PartnerForSelect ymeas = new PartnerForSelect(xmeas.getId(), xmeas.getNameStr());
        return new ResponseEntity<PartnerForSelect>(ymeas, HttpStatus.OK);
    }

}
