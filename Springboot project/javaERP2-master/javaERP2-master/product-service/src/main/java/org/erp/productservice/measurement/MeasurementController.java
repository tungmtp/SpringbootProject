package org.erp.productservice.measurement;

import org.erp.productservice.product.ProductForSelect;
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
    private MeasurementService measurementService;

    @GetMapping
    public ResponseEntity<List<Measurement>> getAllMeasurement() {
        return new ResponseEntity<List<Measurement>>(measurementService.allMeasurement(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Measurement> getSingleMeasurement(@PathVariable UUID id) {
        return new ResponseEntity<Measurement>(measurementService.singleMeasurement(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Measurement> createMeasurement(@RequestBody Measurement Measurement) {
        return new ResponseEntity<Measurement>(measurementService.createMeasurement(Measurement), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Measurement> updateMeasurement(@PathVariable UUID id, @RequestBody Measurement Classes) {
        return new ResponseEntity<Measurement>(measurementService.updateMeasurement(id, Classes), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMeasurement(@PathVariable UUID id) {
        measurementService.deleteMeasurement(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/byNameStr/{query}")
    public ResponseEntity<List<MeasurementForSelect>> getMeasurementContainingQuery(@PathVariable String query) {
        return new ResponseEntity<List<MeasurementForSelect>>(measurementService.getMeasurementContainingQuery(query), HttpStatus.OK);
    }

    @GetMapping("/firstCall/{id}") //Kien
    public ResponseEntity<List<MeasurementForSelect>> getMeasurementFamiliar(@PathVariable UUID id) {
        return new ResponseEntity<List<MeasurementForSelect>>(measurementService.getMeasurementFamiliar(id), HttpStatus.OK);
    }

    @GetMapping("/oneForSelect/{id}")
    public ResponseEntity<MeasurementForSelect> oneForSelect(@PathVariable UUID id) {
        Measurement xmeas = measurementService.singleMeasurement(id);
        MeasurementForSelect ymeas = new MeasurementForSelect(xmeas.getId(), xmeas.getMeasName());
        return new ResponseEntity<MeasurementForSelect>(ymeas, HttpStatus.OK);
    }
}
