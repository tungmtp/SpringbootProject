package org.erp.employeeservice.department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/employee-service/department")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;
    @GetMapping
    public ResponseEntity<List<Department>> getAllDepartment() {
        return new ResponseEntity<List<Department>>(departmentService.allDepartment(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Department> getSingleDepartment(@PathVariable UUID id) {
        return new ResponseEntity<Department>(departmentService.singleDepartment(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Department> createDepartment(@RequestBody Department department) {
        return new ResponseEntity<Department>(departmentService.createDepartment(department), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Department> updateDepartment(@PathVariable UUID id,@RequestBody Department department) {
        return new ResponseEntity<Department>(departmentService.updateDepartment(id, department), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDepartment(@PathVariable UUID id) {
        departmentService.deleteDepartment(id);
        return ResponseEntity.ok().build();
    }

}
