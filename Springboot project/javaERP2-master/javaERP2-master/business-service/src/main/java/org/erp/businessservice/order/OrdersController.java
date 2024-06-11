package org.erp.businessservice.order;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/business-service/orders")
public class OrdersController {
    @Autowired
    private OrdersService orderService;
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping
    public ResponseEntity<List<Orders>> getAllOrder() {
        return new ResponseEntity<List<Orders>>(orderService.getAllOrders(), HttpStatus.OK);
    }

    @GetMapping("/byOrderDate")
    public ResponseEntity<List<Orders>> getOrdersByOrderDate(
            @RequestParam("orderDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date orderDate) {
        List<Orders> orders = orderService.getOrdersByOrderDate(orderDate);
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Orders> getSingleOrder(@PathVariable UUID id) {
        return new ResponseEntity<Orders>(orderService.getOrderById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Orders> createOrder(@RequestBody Orders OrderDetail, @RequestHeader("UserName") String userName) {
//        return new ResponseEntity<Orders>(orderService.createOrder(OrderDetail), HttpStatus.CREATED);
        Orders createdProduct = orderService.createOrder(OrderDetail);
        HttpHeaders headers = new HttpHeaders();
        headers.add("RequestType", "ADD_ORDER");
        headers.add("UserName", userName);
        ResponseEntity<Orders> response = ResponseEntity.status(HttpStatus.CREATED)
                .headers(headers)
                .body(createdProduct);
        System.out.println("UserName: " + userName);
        // Gửi message đến RabbitMQ
        rabbitTemplate.convertAndSend("javaguides_exchange", "javaguides_routing_key", response);
        return response;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Orders> updateOrder(@PathVariable UUID id, @RequestBody Orders OrderDetail) {
        return new ResponseEntity<Orders>(orderService.updateOrder(id, OrderDetail), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOrder(@PathVariable UUID id) {
        orderService.deleteOrder(id);
        return ResponseEntity.ok().build();
    }

}
