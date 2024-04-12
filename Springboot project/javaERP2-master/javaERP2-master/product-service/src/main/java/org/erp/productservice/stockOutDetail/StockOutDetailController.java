package org.erp.productservice.stockOutDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/product-service/stockOutDetail")
public class StockOutDetailController {
    @Autowired
    private StockOutDetailService StockOutDetailService;
    @GetMapping
    public ResponseEntity<List<StockOutDetail>> getAllStockOutDetail() {
        return new ResponseEntity<List<StockOutDetail>>(StockOutDetailService.getAllStockOutDetails(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<StockOutDetail> getSingleStockOutDetail(@PathVariable UUID id) {
        return new ResponseEntity<StockOutDetail>(StockOutDetailService.getStockOutDetailById(id), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<StockOutDetail> createStockOutDetail(@RequestBody StockOutDetail StockOutDetail) {
        return new ResponseEntity<StockOutDetail>(StockOutDetailService.createStockOutDetail(StockOutDetail), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<StockOutDetail> updateStockOutDetail(@PathVariable UUID id, @RequestBody StockOutDetail StockOutDetail) {
        return new ResponseEntity<StockOutDetail>(StockOutDetailService.updateStockOutDetail(id, StockOutDetail), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStockOutDetail(@PathVariable UUID id) {
        StockOutDetailService.deleteStockOutDetail(id);
        return ResponseEntity.ok().build();
    }

}
