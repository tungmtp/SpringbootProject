package org.erp.productservice.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/product-service/product")
public class ProductController {
    @Autowired
    private ProductService ProductService;
    @GetMapping
    public ResponseEntity<List<Product>> getAllProduct() {
        return new ResponseEntity<List<Product>>(ProductService.allProduct(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Product> getSingleProduct(@PathVariable UUID id) {
        return new ResponseEntity<Product>(ProductService.singleProduct(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product Product) {
        return new ResponseEntity<Product>(ProductService.createProduct(Product), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable UUID id,@RequestBody Product Product) {
        return new ResponseEntity<Product>(ProductService.updateProduct(id, Product), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable UUID id) {
        ProductService.deleteProduct(id);
        return ResponseEntity.ok().build();
    }

}
