package org.erp.businessservice.orderDelivery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/business-service/orderDeliverySql")
public class OrderDeliverySQLController {
    @Autowired
    private OrderDeliverySQLService orderDeliverySQLService;

    @GetMapping("/{xdate}")
    public ResponseEntity<String> getOrderDeliveryByDeliveryDate(@PathVariable String xdate) {
        return new ResponseEntity<String>(orderDeliverySQLService.getOrderDeliveryByDeliveryDate(xdate), HttpStatus.OK);
    }

    @GetMapping("/byOrderID/{orderID}")
    public ResponseEntity<String> getOrderDeliveryByOrderID(@PathVariable String orderID) {
        return new ResponseEntity<String>(orderDeliverySQLService.getOrderDeliveryByOrderID(orderID), HttpStatus.OK);
    }

    @GetMapping("/byId/{id}")
    public ResponseEntity<String> getOrderDeliveryById(@PathVariable String id) {
        return new ResponseEntity<String>(orderDeliverySQLService.getOrderDeliveryById(id), HttpStatus.OK);
    }

    @GetMapping("/byId2/{id}")
    public ResponseEntity<String> getOrderDeliveryById2(@PathVariable String id) {
        String result = orderDeliverySQLService.getOrderDeliveryById2(id);
        if (result == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/getDeliveryByReqDateOfOrder/{orderID}/{reqDate}")
    public ResponseEntity<String> getDeliveryByReqDateOfOrder(@PathVariable String orderID, @PathVariable String reqDate) {
        String result = orderDeliverySQLService.getDeliveryByReqDateOfOrder(orderID, reqDate);
        if (result == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
