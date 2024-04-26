package org.erp.employeeservice.employeeRelation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/Employee-service/employeeRelation")
public class EmployeeRelationController {
    @Autowired
    private EmployeeRelationService EmployeeRelationService;
    @GetMapping
    public ResponseEntity<List<EmployeeRelation>> getAllEmployeeRelation() {
        return new ResponseEntity<List<EmployeeRelation>>(EmployeeRelationService.allEmployeeRelation(), HttpStatus.OK);
    }
    @GetMapping("/byEmployeeID/{id}")
    public ResponseEntity<List<EmployeeRelation>> getEmployeeRelationByEmployeeId(@PathVariable UUID id) {
        return new ResponseEntity<List<EmployeeRelation>>(EmployeeRelationService.getEmployeeRelationByEmployeeId(id), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeRelation> getSingleEmployeeRelation(@PathVariable UUID id) {
        return new ResponseEntity<EmployeeRelation>(EmployeeRelationService.singleEmployeeRelation(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<EmployeeRelation> createEmployeeRelation(@RequestBody EmployeeRelation EmployeeRelation) {
        return new ResponseEntity<EmployeeRelation>(EmployeeRelationService.createEmployeeRelation(EmployeeRelation), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeRelation> updateEmployeeRelation(@PathVariable UUID id, @RequestBody EmployeeRelation EmployeeRelation) {
        return new ResponseEntity<EmployeeRelation>(EmployeeRelationService.updateEmployeeRelation(id, EmployeeRelation), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEmployeeRelation(@PathVariable UUID id) {
        EmployeeRelationService.deleteEmployeeRelation(id);
        return ResponseEntity.ok().build();
    }

}
