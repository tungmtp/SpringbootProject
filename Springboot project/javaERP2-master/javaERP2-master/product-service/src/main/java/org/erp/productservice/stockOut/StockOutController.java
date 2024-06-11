package org.erp.productservice.stockOut;

import org.erp.productservice.stockIn.StockIn;
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
    private StockOutService stockOutService;

    @GetMapping
    public ResponseEntity<List<StockOut>> getAllStockOut() {
        return new ResponseEntity<List<StockOut>>(stockOutService.getAllStockOuts(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StockOut> getSingleStockOut(@PathVariable UUID id) {
        return new ResponseEntity<StockOut>(stockOutService.getStockOutById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<StockOut> createStockOut(@RequestBody StockOut StockOut) {
        return new ResponseEntity<StockOut>(stockOutService.createStockOut(StockOut), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StockOut> updateStockOut(@PathVariable UUID id, @RequestBody StockOut StockOut) {
        return new ResponseEntity<StockOut>(stockOutService.updateStockOut(id, StockOut), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStockOut(@PathVariable UUID id) {
        stockOutService.deleteStockOut(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/byDate")
    public ResponseEntity<List<StockOut>> getStockOutByDate(
            @RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate) {
        List<StockOut> stockOuts = stockOutService.getStockOutByDate(startDate, endDate);
        return new ResponseEntity<>(stockOuts, HttpStatus.OK);
    }

    @GetMapping("/byStockOutID/{stockOutID}")
    public ResponseEntity<String> getStockOutDetailByStockOutID(@PathVariable String stockOutID) {
        return new ResponseEntity<String>(stockOutService.getStockOutDetailByStockOutID(stockOutID), HttpStatus.OK);
    }
}
