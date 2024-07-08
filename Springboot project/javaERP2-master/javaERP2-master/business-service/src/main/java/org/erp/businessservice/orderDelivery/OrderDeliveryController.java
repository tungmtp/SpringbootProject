package org.erp.businessservice.orderDelivery;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
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
    @Autowired
    private RabbitTemplate rabbitTemplate;

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
    public ResponseEntity<?> deleteOrderDelivery(@PathVariable UUID id, @RequestHeader("UserName") String userName) {
//        orderDeliveryService.deleteOrderDelivery(id);
//        return ResponseEntity.ok().build();
        UUID deletedOrderDelivery = orderDeliveryService.deleteOrderDelivery(id);
        HttpHeaders headers = new HttpHeaders();
        headers.add("RequestType", "DELETE_ORDER_DELIVERY");
        headers.add("UserName", userName);
        ResponseEntity<UUID> response = ResponseEntity.status(HttpStatus.OK)
                .headers(headers)
                .body(deletedOrderDelivery);

        // Gửi message đến RabbitMQ
        rabbitTemplate.convertAndSend("javaguides_exchange", "javaguides_routing_key", response);
        return response;

    }


    @PostMapping("/sendMessage/orderDeliveryID/process")
    public ResponseEntity<String> sendMessageInProcess(@RequestBody String message, @RequestHeader("UserName") String userName) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("RequestType", "SENDMESSAGE_orderDelivery");
        headers.add("Status", "process");
        headers.add("UserName", userName);
        ResponseEntity<String> response = ResponseEntity.status(HttpStatus.OK)
                .headers(headers)
                .body(message);
        System.out.println("UserName: " + userName);
        // Gửi message đến RabbitMQ
        rabbitTemplate.convertAndSend("javaguides_exchange", "javaguides_routing_key", response);
        return response;
    }

    @PostMapping("/sendMessage/orderDeliveryID/normal")
    public ResponseEntity<String> sendMessageNotProcess(@RequestBody String message, @RequestHeader("UserName") String userName) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("RequestType", "SENDMESSAGE_orderDelivery");
        headers.add("Status", "normal");
        headers.add("UserName", userName);
        ResponseEntity<String> response = ResponseEntity.status(HttpStatus.OK)
                .headers(headers)
                .body(message);
        System.out.println("UserName: " + userName);
        // Gửi message đến RabbitMQ
        rabbitTemplate.convertAndSend("javaguides_exchange", "javaguides_routing_key", response);
        return response;
    }

    @PostMapping("/sendMessage/orderDeliveryID/cancel")
    public ResponseEntity<String> sendMessageCancel(@RequestBody String message, @RequestHeader("UserName") String userName) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("RequestType", "SENDMESSAGE_orderDelivery");
        headers.add("Status", "cancel");
        headers.add("UserName", userName);
        ResponseEntity<String> response = ResponseEntity.status(HttpStatus.OK)
                .headers(headers)
                .body(message);
        System.out.println("UserName: " + userName);
        // Gửi message đến RabbitMQ
        rabbitTemplate.convertAndSend("javaguides_exchange", "javaguides_routing_key", response);
        return response;
    }

    @PostMapping("/sendMessage/orderDeliveryID/success")
    public ResponseEntity<String> sendMessageSuccess(@RequestBody String message, @RequestHeader("UserName") String userName) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("RequestType", "SENDMESSAGE_orderDelivery");
        headers.add("Status", "success");
        headers.add("UserName", userName);
        ResponseEntity<String> response = ResponseEntity.status(HttpStatus.OK)
                .headers(headers)
                .body(message);
        System.out.println("UserName: " + userName);
        // Gửi message đến RabbitMQ
        rabbitTemplate.convertAndSend("javaguides_exchange", "javaguides_routing_key", response);
        return response;
    }

}
