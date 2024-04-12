package org.erp.productservice.stockInDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/product-service/stockInDetail")
public class StockInDetailController {
    @Autowired
    private StockInDetailService StockInDetailService;
    @GetMapping
    public ResponseEntity<List<StockInDetail>> getAllStockInDetail() {
        return new ResponseEntity<List<StockInDetail>>(StockInDetailService.getAllStockInDetails(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<StockInDetail> getSingleStockInDetail(@PathVariable UUID id) {
        return new ResponseEntity<StockInDetail>(StockInDetailService.getStockInDetailById(id), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<StockInDetail> createStockInDetail(@RequestBody StockInDetail StockInDetail) {
        return new ResponseEntity<StockInDetail>(StockInDetailService.createStockInDetail(StockInDetail), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<StockInDetail> updateStockInDetail(@PathVariable UUID id, @RequestBody StockInDetail StockInDetail) {
        return new ResponseEntity<StockInDetail>(StockInDetailService.updateStockInDetail(id, StockInDetail), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStockInDetail(@PathVariable UUID id) {
        StockInDetailService.deleteStockInDetail(id);
        return ResponseEntity.ok().build();
    }

}
