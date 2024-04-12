package org.erp.productservice.stockOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/product-service/stockOut")
public class StockOutController {
    @Autowired
    private StockOutService StockOutService;
    @GetMapping
    public ResponseEntity<List<StockOut>> getAllStockOut() {
        return new ResponseEntity<List<StockOut>>(StockOutService.getAllStockOuts(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<StockOut> getSingleStockOut(@PathVariable UUID id) {
        return new ResponseEntity<StockOut>(StockOutService.getStockOutById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<StockOut> createStockOut(@RequestBody StockOut StockOut) {
        return new ResponseEntity<StockOut>(StockOutService.createStockOut(StockOut), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StockOut> updateStockOut(@PathVariable UUID id, @RequestBody StockOut StockOut) {
        return new ResponseEntity<StockOut>(StockOutService.updateStockOut(id, StockOut), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStockOut(@PathVariable UUID id) {
        StockOutService.deleteStockOut(id);
        return ResponseEntity.ok().build();
    }

}
