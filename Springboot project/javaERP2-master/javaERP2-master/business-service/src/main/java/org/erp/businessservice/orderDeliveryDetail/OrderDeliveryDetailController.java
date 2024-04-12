package org.erp.businessservice.orderDeliveryDetail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/business-service/orderDeliveryDetail")
public class OrderDeliveryDetailController {
    @Autowired
    private OrderDeliveryDetailService OrderDeliveryDetailService;
    @GetMapping
    public ResponseEntity<List<OrderDeliveryDetail>> getAllOrderDeliveryDetail() {
        return new ResponseEntity<List<OrderDeliveryDetail>>(OrderDeliveryDetailService.getAllOrderDeliveryDetails(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<OrderDeliveryDetail> getSingleOrderDeliveryDetail(@PathVariable UUID id) {
        return new ResponseEntity<OrderDeliveryDetail>(OrderDeliveryDetailService.getOrderDeliveryDetailById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<OrderDeliveryDetail> createOrderDeliveryDetail(@RequestBody OrderDeliveryDetail OrderDeliveryDetail) {
        return new ResponseEntity<OrderDeliveryDetail>(OrderDeliveryDetailService.createOrderDeliveryDetail(OrderDeliveryDetail), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderDeliveryDetail> updateOrderDeliveryDetail(@PathVariable UUID id, @RequestBody OrderDeliveryDetail OrderDeliveryDetail) {
        return new ResponseEntity<OrderDeliveryDetail>(OrderDeliveryDetailService.updateOrderDeliveryDetail(id, OrderDeliveryDetail), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOrderDeliveryDetail(@PathVariable UUID id) {
        OrderDeliveryDetailService.deleteOrderDeliveryDetail(id);
        return ResponseEntity.ok().build();
    }

}
