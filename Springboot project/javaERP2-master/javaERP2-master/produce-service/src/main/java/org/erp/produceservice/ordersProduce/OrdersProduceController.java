package org.erp.produceservice.ordersProduce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/produce-service/ordersProduce")
public class OrdersProduceController {
    @Autowired
    private OrdersProduceService ordersProduceService;

    @GetMapping
    public ResponseEntity<List<OrdersProduce>> getAllOrdersProduce() {
        return new ResponseEntity<>(ordersProduceService.getAllOrdersProduce(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrdersProduce> getOrdersProduceById(@PathVariable UUID id) {
        return new ResponseEntity<>(ordersProduceService.getOrdersProduceById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<OrdersProduce> createOrdersProduce(@RequestBody OrdersProduce ordersProduce) {
        return new ResponseEntity<>(ordersProduceService.createOrdersProduce(ordersProduce), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrdersProduce> updateOrdersProduce(@PathVariable UUID id, @RequestBody OrdersProduce ordersProduce) {
        return new ResponseEntity<>(ordersProduceService.updateOrdersProduce(id, ordersProduce), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOrdersProduce(@PathVariable UUID id) {
        ordersProduceService.deleteOrdersProduce(id);
        return ResponseEntity.ok().build();
    }
}
