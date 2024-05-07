package org.erp.productservice.product;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
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
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping
    public ResponseEntity<List<Product>> getAllProduct() {
        return new ResponseEntity<List<Product>>(ProductService.allProduct(), HttpStatus.OK);
    }
    @GetMapping("/byCategoryID/{id}")
    public ResponseEntity<List<Product>> getAllProductByExtraCategoryID(@PathVariable UUID id) {
        return new ResponseEntity<List<Product>>(ProductService.getProductsByExtraCategoryID(id), HttpStatus.OK);
    }

    @GetMapping("/byNameStr/{query}") //Kien
    public ResponseEntity<List<ProductForSelect>> getAllProductByNameStr(@PathVariable String query) {
        return new ResponseEntity<List<ProductForSelect>>(ProductService.searchProductContainName(query), HttpStatus.OK);
    }

    @GetMapping("/firstCall/{id}") //Kien
    public ResponseEntity<List<ProductForSelect>> getProductFirstCall(@PathVariable UUID id) {
        return new ResponseEntity<List<ProductForSelect>>(ProductService.getProductFirstCall(id), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Product> getSingleProduct(@PathVariable UUID id) {
        return new ResponseEntity<Product>(ProductService.singleProduct(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product createdProduct = ProductService.createProduct(product);
        HttpHeaders headers = new HttpHeaders();
        headers.add("RequestType", "ADD_PRODUCT");
        ResponseEntity<Product> response = ResponseEntity.status(HttpStatus.CREATED)
                .headers(headers)
                .body(createdProduct);

        // Gửi message đến RabbitMQ
        rabbitTemplate.convertAndSend("javaguides_exchange", "javaguides_routing_key", response);

        return response;
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
