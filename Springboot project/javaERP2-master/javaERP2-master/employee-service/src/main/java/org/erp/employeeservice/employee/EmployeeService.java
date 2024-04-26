package org.erp.employeeservice.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(UUID id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));
    }

    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(UUID id, Employee updatedEmployee) {
        Employee existingEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));

        if (!existingEmployee.getLastName().equals(updatedEmployee.getLastName())) {
            existingEmployee.setLastName(updatedEmployee.getLastName());
        }

        if (!existingEmployee.getFirstName().equals(updatedEmployee.getFirstName())) {
            existingEmployee.setFirstName(updatedEmployee.getFirstName());
        }

        if (!existingEmployee.getTitle().equals(updatedEmployee.getTitle())) {
            existingEmployee.setTitle(updatedEmployee.getTitle());
        }

        if (!existingEmployee.getSex().equals(updatedEmployee.getSex())) {
            existingEmployee.setSex(updatedEmployee.getSex());
        }

        if (!existingEmployee.getBirthDate().equals(updatedEmployee.getBirthDate())) {
            existingEmployee.setBirthDate(updatedEmployee.getBirthDate());
        }

        if (updatedEmployee.getAddress() != null && !existingEmployee.getAddress().equals(updatedEmployee.getAddress())) {
            existingEmployee.setAddress(updatedEmployee.getAddress());
        }

        if (updatedEmployee.getHandPhone() != null && !existingEmployee.getHandPhone().equals(updatedEmployee.getHandPhone())) {
            existingEmployee.setHandPhone(updatedEmployee.getHandPhone());
        }

        if (!existingEmployee.getEmail().equals(updatedEmployee.getEmail())) {
            existingEmployee.setEmail(updatedEmployee.getEmail());
        }

        if (existingEmployee.isIsUser() != updatedEmployee.isIsUser()) {
            existingEmployee.setIsUser(updatedEmployee.isIsUser());
        }

        if (updatedEmployee.getJobDescription() != null && !existingEmployee.getJobDescription().equals(updatedEmployee.getJobDescription())) {
            existingEmployee.setJobDescription(updatedEmployee.getJobDescription());
        }

        return employeeRepository.save(existingEmployee);
    }

    public void deleteEmployee(UUID id) {
        employeeRepository.deleteById(id);
    }
}