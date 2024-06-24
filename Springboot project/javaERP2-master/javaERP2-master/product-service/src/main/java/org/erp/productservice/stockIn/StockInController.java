package org.erp.productservice.stockIn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/product-service/stockIn")
public class StockInController {
    @Autowired
    private StockInService stockInService;

    @GetMapping
    public ResponseEntity<List<StockIn>> getAllStockIn() {
        return new ResponseEntity<List<StockIn>>(stockInService.getAllStockIns(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StockIn> getSingleStockIn(@PathVariable UUID id) {
        return new ResponseEntity<StockIn>(stockInService.getStockInById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<StockIn> createStockIn(@RequestBody StockIn StockIn) {
        return new ResponseEntity<StockIn>(stockInService.createStockIn(StockIn), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StockIn> updateStockIn(@PathVariable UUID id, @RequestBody StockIn StockIn) {
        return new ResponseEntity<StockIn>(stockInService.updateStockIn(id, StockIn), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStockIn(@PathVariable UUID id) {
        stockInService.deleteStockIn(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/byDate")
    public ResponseEntity<List<StockIn>> getStockInByDate(
            @RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate) {
        List<StockIn> stockIns = stockInService.getStockInByDate(startDate, endDate);
        return new ResponseEntity<>(stockIns, HttpStatus.OK);
    }

    @GetMapping("/byStockInID/{stockInID}")
    public ResponseEntity<String> getStockInDetailByStockInID(@PathVariable String stockInID) {
        return new ResponseEntity<String>(stockInService.getStockInDetailByStockInID(stockInID), HttpStatus.OK);
    }

    @GetMapping("/findByRelatedTableAndRelatedID/{relatedTable}/{relatedID}")
    public ResponseEntity<StockIn> findByRelatedTableAndRelatedID(@PathVariable String relatedTable, @PathVariable UUID relatedID) {
        return new ResponseEntity<>(stockInService.findByRelatedTableAndRelatedID(relatedTable, relatedID), HttpStatus.OK);
    }
}
