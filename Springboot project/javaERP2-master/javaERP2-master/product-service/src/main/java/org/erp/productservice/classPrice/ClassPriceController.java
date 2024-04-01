package org.erp.productservice.classPrice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/product-service/classPrice")
public class ClassPriceController {
    @Autowired
    private ClassPriceService ClassPriceService;
    @GetMapping
    public ResponseEntity<List<ClassPrice>> getAllClassPrice() {
        return new ResponseEntity<List<ClassPrice>>(ClassPriceService.allClassPrice(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ClassPrice> getSingleClassPrice(@PathVariable UUID id) {
        return new ResponseEntity<ClassPrice>(ClassPriceService.singleClassPrice(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ClassPrice> createClassPrice(@RequestBody ClassPrice ClassPrice) {
        return new ResponseEntity<ClassPrice>(ClassPriceService.createClassPrice(ClassPrice), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClassPrice> updateClassPrice(@PathVariable UUID id, @RequestBody ClassPrice ClassPrice) {
        return new ResponseEntity<ClassPrice>(ClassPriceService.updateClassPrice(id, ClassPrice), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteClassPrice(@PathVariable UUID id) {
        ClassPriceService.deleteClassPrice(id);
        return ResponseEntity.ok().build();
    }

}
