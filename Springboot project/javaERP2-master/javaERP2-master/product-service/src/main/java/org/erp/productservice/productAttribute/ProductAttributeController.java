package org.erp.productservice.productAttribute;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/product-service/ProductAttribute")
public class ProductAttributeController {
    @Autowired
    private ProductAttributeService ProductAttributeService;
    @GetMapping
    public ResponseEntity<List<ProductAttribute>> getAllProductAttribute() {
        return new ResponseEntity<List<ProductAttribute>>(ProductAttributeService.allProductAttribute(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ProductAttribute> getSingleProductAttribute(@PathVariable UUID id) {
        return new ResponseEntity<ProductAttribute>(ProductAttributeService.singleProductAttribute(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProductAttribute> createProductAttribute(@RequestBody ProductAttribute ProductAttribute) {
        return new ResponseEntity<ProductAttribute>(ProductAttributeService.createProductAttribute(ProductAttribute), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductAttribute> updateProductAttribute(@PathVariable UUID id, @RequestBody ProductAttribute ProductAttribute) {
        return new ResponseEntity<ProductAttribute>(ProductAttributeService.updateProductAttribute(id, ProductAttribute), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProductAttribute(@PathVariable UUID id) {
        ProductAttributeService.deleteProductAttribute(id);
        return ResponseEntity.ok().build();
    }

}
