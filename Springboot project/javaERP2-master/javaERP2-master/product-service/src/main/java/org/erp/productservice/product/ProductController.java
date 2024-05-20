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
    private ProductService productService;
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping
    public ResponseEntity<List<Product>> getAllProduct() {
        return new ResponseEntity<List<Product>>(productService.allProduct(), HttpStatus.OK);
    }

    @GetMapping("/byCategoryID/{id}")
    public ResponseEntity<List<Product>> getAllProductByExtraCategoryID(@PathVariable UUID id) {
        return new ResponseEntity<List<Product>>(productService.getProductsByExtraCategoryID(id), HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Product> getSingleProduct(@PathVariable UUID id) {
        return new ResponseEntity<Product>(productService.singleProduct(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product createdProduct = productService.createProduct(product);
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
    public ResponseEntity<Product> updateProduct(@PathVariable UUID id, @RequestBody Product Product) {
        return new ResponseEntity<Product>(productService.updateProduct(id, Product), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable UUID id) {
        productService.deleteProduct(id);
        return ResponseEntity.ok().build();
    }

    //--------------------------------------------------//
    @GetMapping("/byNameStr/{query}") //Kien
    public ResponseEntity<List<ProductForSelect>> getAllProductByNameStr(@PathVariable String query) {
        return new ResponseEntity<List<ProductForSelect>>(productService.getProductContainingName(query), HttpStatus.OK);
    }

    @GetMapping("/byNameStr/mayBeSell/{query}") //Kien
    public ResponseEntity<List<ProductForSelect>> getAllProductMayBeSellByNameStr(@PathVariable String query) {
        return new ResponseEntity<List<ProductForSelect>>(productService.getProductMayBeSellContainingName(query), HttpStatus.OK);
    }

    @GetMapping("/firstCall/{id}") //Kien
    public ResponseEntity<List<ProductForSelect>> getProductFirstCall(@PathVariable UUID id) {
        return new ResponseEntity<List<ProductForSelect>>(productService.getProductFirstCall(id), HttpStatus.OK);
    }

    @GetMapping("/firstCall/mayBeSell/{id}") //Kien
    public ResponseEntity<List<ProductForSelect>> getProductMayBeSellFirstCall(@PathVariable UUID id) {
        return new ResponseEntity<List<ProductForSelect>>(productService.getProductMayBeSellFirstCall(id), HttpStatus.OK);
    }


    @GetMapping("/oneForSelect/{id}")
    public ResponseEntity<Product> getSelectedItem(@PathVariable UUID id) {
        return new ResponseEntity<Product>(productService.singleProduct(id), HttpStatus.OK);
    }

    @GetMapping("/oneForSelect/mayBeSell/{id}")
    public ResponseEntity<List<ProductWithMeasurement>> getSelectedItemMayBeSell(@PathVariable UUID id) {
        return new ResponseEntity<List<ProductWithMeasurement>>(productService.getSingleProductWithMeasurement(id), HttpStatus.OK);
    }

    @GetMapping("/byNameStr/bom/{query}")
    public ResponseEntity<List<ProductForSelect>> getProductMayBeProduceContainingName(@PathVariable String query) {
        return new ResponseEntity<List<ProductForSelect>>(productService.getProductMayBeProduceContainingName(query), HttpStatus.OK);
    }

    @GetMapping("/firstCall/bom/{id}")
    public ResponseEntity<List<ProductForSelect>> getProductMayBeProduceFirstCall(@PathVariable UUID id) {
        return new ResponseEntity<List<ProductForSelect>>(productService.getProductMayBeProduceFirstCall(id), HttpStatus.OK);
    }

    @GetMapping("/bom")
    public ResponseEntity<List<ProductBom>> getProductMayBeProduce() {
        return new ResponseEntity<List<ProductBom>>(productService.getProductMayBeProduce(), HttpStatus.OK);
    }

}
