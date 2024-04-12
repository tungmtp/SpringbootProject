package org.erp.productservice.stockIn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/product-service/stockIn")
public class StockInController {
    @Autowired
    private StockInService StockInService;
    @GetMapping
    public ResponseEntity<List<StockIn>> getAllStockIn() {
        return new ResponseEntity<List<StockIn>>(StockInService.getAllStockIns(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<StockIn> getSingleStockIn(@PathVariable UUID id) {
        return new ResponseEntity<StockIn>(StockInService.getStockInById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<StockIn> createStockIn(@RequestBody StockIn StockIn) {
        return new ResponseEntity<StockIn>(StockInService.createStockIn(StockIn), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StockIn> updateStockIn(@PathVariable UUID id, @RequestBody StockIn StockIn) {
        return new ResponseEntity<StockIn>(StockInService.updateStockIn(id, StockIn), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStockIn(@PathVariable UUID id) {
        StockInService.deleteStockIn(id);
        return ResponseEntity.ok().build();
    }

}
