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

    @GetMapping("/orderRequestSumary/{id}")
    public ResponseEntity<String> orderRequestSumary(@PathVariable UUID id) {
        String result = ordersProduceService.orderRequestSumary(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/addlist")
    public ResponseEntity<String> insertListOrderProduce(@RequestBody List<OrdersProduce> mlist) {
        int mCount = 0;

        for (OrdersProduce mm : mlist) {
            ordersProduceService.createOrdersProduce(mm);
            mCount++;
        }
        return new ResponseEntity<>(String.valueOf(mCount), HttpStatus.OK);
    }

    @GetMapping("/orderRequestDistinctDate/{id}")
    public ResponseEntity<String> orderRequestDistinctDate(@PathVariable UUID id) {
        String result = ordersProduceService.orderRequestDistinctDate(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/getOrderRequestByOrderIdAndDate/{id}/{mDate}")
    public ResponseEntity<String> getOrderRequestByOrderId(@PathVariable UUID id, @PathVariable String mDate) {
        String result = ordersProduceService.getOrderRequestByOrderIdAndDate(id, mDate);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
