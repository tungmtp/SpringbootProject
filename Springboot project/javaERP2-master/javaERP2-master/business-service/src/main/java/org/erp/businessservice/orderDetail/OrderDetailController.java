package org.erp.businessservice.orderDetail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/business-service/orderDetail")
public class OrderDetailController {
    @Autowired
    private OrderDetailService OrderDetailService;
    @GetMapping
    public ResponseEntity<List<OrderDetail>> getAllOrderDetail() {
        return new ResponseEntity<List<OrderDetail>>(OrderDetailService.allOrdersDetail(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<OrderDetail> getSingleOrderDetail(@PathVariable UUID id) {
        return new ResponseEntity<OrderDetail>(OrderDetailService.singleOrdersDetail(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<OrderDetail> createOrderDetail(@RequestBody OrderDetail OrderDetail) {
        return new ResponseEntity<OrderDetail>(OrderDetailService.createOrdersDetail(OrderDetail), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderDetail> updateSegment(@PathVariable UUID id, @RequestBody OrderDetail OrderDetail) {
        return new ResponseEntity<OrderDetail>(OrderDetailService.updateOrdersDetail(id, OrderDetail), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteClassPrice(@PathVariable UUID id) {
        OrderDetailService.deleteOrdersDetail(id);
        return ResponseEntity.ok().build();
    }

}
