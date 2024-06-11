package org.erp.produceservice.bom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/produce-service/bom")
public class BomController {
    @Autowired
    private BomService bomService;

    @GetMapping("/{id}")
    public ResponseEntity<Bom> getSingleBom(@PathVariable("id") UUID id) {
        return new ResponseEntity<Bom>(bomService.getSingleBOM(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Bom> updateBom(@PathVariable("id") UUID id, @RequestBody Bom bom) {
        return new ResponseEntity<Bom>(bomService.updateBOM(id, bom), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Bom> creatBom(@RequestBody Bom bom) {
        return new ResponseEntity<Bom>(bomService.createBOM(bom), HttpStatus.OK);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<List<Bom>> findBomByProductId(@PathVariable("id") UUID id) {
        return new ResponseEntity<List<Bom>>(bomService.getBomByProductId(id), HttpStatus.OK);
    }

    @GetMapping("/input/{id}")
    public ResponseEntity<List<BomInputByBomId>> getInputByBomId(@PathVariable UUID id) {
        return new ResponseEntity<List<BomInputByBomId>>(bomService.getInputByBomId(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteBOMById(@PathVariable UUID id) {
        bomService.deleteBOMById(id);
    }
}
