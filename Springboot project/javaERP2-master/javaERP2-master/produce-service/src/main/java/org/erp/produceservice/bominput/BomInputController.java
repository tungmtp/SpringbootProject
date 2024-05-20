package org.erp.produceservice.bominput;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/produce-service/bominput")
public class BomInputController {
    @Autowired
    private BomInputService bomInputService;

    @GetMapping("/{id}")
    public ResponseEntity<BomInput> getSingleBomInput(@PathVariable("id") UUID uuid) {
        return new ResponseEntity<BomInput>(bomInputService.getSingleBomInput(uuid), HttpStatus.OK);
    }

    @GetMapping("/bomid/{id}")
    public ResponseEntity<List<BomInput>> getBomInputByBomId(@PathVariable("id") UUID uuid) {
        return new ResponseEntity<>(bomInputService.getBomInputByBomId(uuid), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<BomInput> createBomInput(@RequestBody BomInput bomInput) {
        return new ResponseEntity<BomInput>(bomInputService.createBomInput(bomInput), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BomInput> updateBomInput(@PathVariable("id") UUID id, @RequestBody BomInput bomInput) {
        return new ResponseEntity<BomInput>(bomInputService.updateBomInput(id, bomInput), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteBomInput(@PathVariable("id") UUID id) {
        bomInputService.deleteSingleBomInput(id);
    }
}
