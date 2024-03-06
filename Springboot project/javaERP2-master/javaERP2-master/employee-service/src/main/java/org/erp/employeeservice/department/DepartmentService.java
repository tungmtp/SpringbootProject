package org.erp.employeeservice.department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.List;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    public List<Department> allDepartment() {
        return departmentRepository.findAll();
    }

    public Department singleDepartment(UUID id) {
        return departmentRepository.findById(id).orElseThrow(() -> new RuntimeException("Không tìm thấy phòng ban này"));
    }

    public Department createDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public Department updateDepartment(UUID id, Department department) {
        Department currentDepartment = departmentRepository.findById(id).orElseThrow(() -> new RuntimeException("Không tìm thấy phòng ban này"));
        if (currentDepartment != null) {
            if ((department.getDeptName() != null) && (!"".equalsIgnoreCase(department.getDeptName()))) {
                currentDepartment.setDeptName(department.getDeptName());
            }
            if (department.getIsChildOf() != null) {
                currentDepartment.setIsChildOf(department.getIsChildOf());
            }
            if (department.getIsActive() != null) {
                currentDepartment.setIsActive(department.getIsActive());
            }
            return departmentRepository.save(currentDepartment);
        }
        return null;
    }

    public void deleteDepartment(UUID id) {
        departmentRepository.deleteById(id);
    }
}