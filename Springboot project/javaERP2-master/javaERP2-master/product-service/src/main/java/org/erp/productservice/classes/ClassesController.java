package org.erp.productservice.classes;

import org.erp.productservice.measurement.Measurement;
import org.erp.productservice.measurement.MeasurementForSelect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/product-service/classes")
public class ClassesController {
    @Autowired
    private ClassesService ClassesService;

    @GetMapping
    public ResponseEntity<List<Classes>> getAllClasses() {
        return new ResponseEntity<List<Classes>>(ClassesService.allClasses(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Classes> getSingleClass(@PathVariable UUID id) {
        return new ResponseEntity<Classes>(ClassesService.singleClass(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Classes> createClass(@RequestBody Classes Classes) {
        return new ResponseEntity<Classes>(ClassesService.createClass(Classes), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Classes> updateClass(@PathVariable UUID id, @RequestBody Classes Classes) {
        return new ResponseEntity<Classes>(ClassesService.updateClass(id, Classes), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteClass(@PathVariable UUID id) {
        ClassesService.deleteClass(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/byNameStr/{query}")
    public ResponseEntity<List<ClassForSelect>> getMeasurementContainingQuery(@PathVariable String query) {
        if ("all".equalsIgnoreCase(query)) {
            return new ResponseEntity<List<ClassForSelect>>(ClassesService.getClassFamiliar(), HttpStatus.OK);
        } else {
            return new ResponseEntity<List<ClassForSelect>>(ClassesService.getClassContainingQuery(query), HttpStatus.OK);
        }

    }

    @GetMapping("/firstCall/{id}") //Kien
    public ResponseEntity<List<ClassForSelect>> getMeasurementFamiliar(@PathVariable UUID id) {
        return new ResponseEntity<List<ClassForSelect>>(ClassesService.getClassFamiliar(), HttpStatus.OK);
    }

    @GetMapping("/oneForSelect/{id}")
    public ResponseEntity<ClassForSelect> oneForSelect(@PathVariable UUID id) {
        Classes xmeas = ClassesService.singleClass(id);
        ClassForSelect ymeas = new ClassForSelect(xmeas.getId(), xmeas.getNameStr());
        return new ResponseEntity<ClassForSelect>(ymeas, HttpStatus.OK);
    }
}
