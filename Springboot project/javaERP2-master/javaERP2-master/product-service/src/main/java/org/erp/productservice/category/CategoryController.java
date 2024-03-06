package org.erp.productservice.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/product-service/category")
public class CategoryController {
    @Autowired
    private CategoryService CategoryService;
    @GetMapping
    public ResponseEntity<List<Category>> getAllProduct() {
        return new ResponseEntity<List<Category>>(CategoryService.allProduct(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Category> getSingleProduct(@PathVariable UUID id) {
        return new ResponseEntity<Category>(CategoryService.singleProduct(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Category> createProduct(@RequestBody Category Category) {
        return new ResponseEntity<Category>(CategoryService.createProduct(Category), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> updateProduct(@PathVariable UUID id, @RequestBody Category Category) {
        return new ResponseEntity<Category>(CategoryService.updateProduct(id, Category), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable UUID id) {
        CategoryService.deleteProduct(id);
        return ResponseEntity.ok().build();
    }

}
