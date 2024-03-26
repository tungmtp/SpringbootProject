package org.erp.productservice.productRelation;
import org.erp.productservice.category.Category;
import org.erp.productservice.category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/product-service/productRelation")
public class ProductRelationController {
    @Autowired
    private ProductRelationService ProductRelationService;
    @GetMapping
    public ResponseEntity<List<ProductRelation>> getAllProductRelation() {
        return new ResponseEntity<List<ProductRelation>>(ProductRelationService.allProductRelation(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ProductRelation> getSingleProductRelation(@PathVariable UUID id) {
        return new ResponseEntity<ProductRelation>(ProductRelationService.singleProductRelation(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProductRelation> createProductRelation(@RequestBody ProductRelation ProductRelation) {
        return new ResponseEntity<ProductRelation>(ProductRelationService.createProductRelation(ProductRelation), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductRelation> updateProductRelation(@PathVariable UUID id, @RequestBody ProductRelation ProductRelation) {
        return new ResponseEntity<ProductRelation>(ProductRelationService.updateProductRelation(id, ProductRelation), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProductRelation(@PathVariable UUID id) {
        ProductRelationService.deleteProductRelation(id);
        return ResponseEntity.ok().build();
    }

}
