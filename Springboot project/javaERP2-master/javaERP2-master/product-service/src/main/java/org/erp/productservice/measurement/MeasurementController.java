package org.erp.productservice.measurement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/product-service/Measurement")
public class MeasurementController {
    @Autowired
    private MeasurementService MeasurementService;
    @GetMapping
    public ResponseEntity<List<Measurement>> getAllMeasurement() {
        return new ResponseEntity<List<Measurement>>(MeasurementService.allMeasurement(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Measurement> getSingleMeasurement(@PathVariable UUID id) {
        return new ResponseEntity<Measurement>(MeasurementService.singleMeasurement(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Measurement> createMeasurement(@RequestBody Measurement Measurement) {
        return new ResponseEntity<Measurement>(MeasurementService.createMeasurement(Measurement), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Measurement> updateMeasurement(@PathVariable UUID id, @RequestBody Measurement Classes) {
        return new ResponseEntity<Measurement>(MeasurementService.updateMeasurement(id, Classes), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMeasurement(@PathVariable UUID id) {
        MeasurementService.deleteMeasurement(id);
        return ResponseEntity.ok().build();
    }

}
