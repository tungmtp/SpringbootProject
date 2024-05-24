package org.erp.businessservice.orderDelivery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/business-service/orderDelivery")
public class OrderDeliveryController {
    @Autowired
    private OrderDeliveryService orderDeliveryService;

    @GetMapping
    public ResponseEntity<List<OrderDelivery>> getAllOrderDelivery() {
        return new ResponseEntity<List<OrderDelivery>>(orderDeliveryService.getAllOrderDeliveries(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDelivery> getSingleOrderDelivery(@PathVariable UUID id) {
        return new ResponseEntity<OrderDelivery>(orderDeliveryService.getOrderDeliveryById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<OrderDelivery> createOrderDelivery(@RequestBody OrderDelivery OrderDelivery) {
        return new ResponseEntity<OrderDelivery>(orderDeliveryService.createOrderDelivery(OrderDelivery), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderDelivery> updateOrderDelivery(@PathVariable UUID id, @RequestBody OrderDelivery OrderDelivery) {
        return new ResponseEntity<OrderDelivery>(orderDeliveryService.updateOrderDelivery(id, OrderDelivery), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOrderDelivery(@PathVariable UUID id) {
        orderDeliveryService.deleteOrderDelivery(id);
        return ResponseEntity.ok().build();
    }

}
