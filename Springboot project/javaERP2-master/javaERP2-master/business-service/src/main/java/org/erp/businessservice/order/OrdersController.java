package org.erp.businessservice.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/business-service/orders")
public class OrdersController {
    @Autowired
    private OrdersService OrderService;
    @GetMapping
    public ResponseEntity<List<Orders>> getAllOrder() {
        return new ResponseEntity<List<Orders>>(OrderService.getAllOrders(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Orders> getSingleOrder(@PathVariable UUID id) {
        return new ResponseEntity<Orders>(OrderService.getOrderById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Orders> createOrder(@RequestBody Orders OrderDetail) {
        return new ResponseEntity<Orders>(OrderService.createOrder(OrderDetail), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Orders> updateOrder(@PathVariable UUID id, @RequestBody Orders OrderDetail) {
        return new ResponseEntity<Orders>(OrderService.updateOrder(id, OrderDetail), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOrder(@PathVariable UUID id) {
        OrderService.deleteOrder(id);
        return ResponseEntity.ok().build();
    }

}
