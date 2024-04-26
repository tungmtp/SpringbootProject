package org.erp.employeeservice.employeeRelation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class EmployeeRelationService {
    @Autowired
    private EmployeeRelationRepository EmployeeRelationRepository;

    public List<EmployeeRelation> allEmployeeRelation() {
        return EmployeeRelationRepository.findAll();
    }

    public List<EmployeeRelation> getEmployeeRelationByEmployeeId(UUID EmployeeId) {
        return EmployeeRelationRepository.findByEmployeeId(EmployeeId);
    }
    public EmployeeRelation singleEmployeeRelation(UUID id) {
        return EmployeeRelationRepository.findById(id).orElseThrow(() -> new RuntimeException("Không tìm thấy nguoi dung này"));
    }

    public EmployeeRelation createEmployeeRelation(EmployeeRelation EmployeeRelation) {
        return EmployeeRelationRepository.save(EmployeeRelation);
    }

    public EmployeeRelation updateEmployeeRelation(UUID id, EmployeeRelation EmployeeRelation) {
        EmployeeRelation currentEmployeeRelation = EmployeeRelationRepository.findById(id).orElseThrow(() -> new RuntimeException("Không tìm thấy sản phẩm này"));
        if (currentEmployeeRelation != null) {
            if (EmployeeRelation.getEmployeeId() != currentEmployeeRelation.getEmployeeId()) {
                currentEmployeeRelation.setEmployeeId(EmployeeRelation.getEmployeeId());
            }
            if (EmployeeRelation.getRelId() != currentEmployeeRelation.getRelId()) {
                currentEmployeeRelation.setRelId(EmployeeRelation.getRelId());
            }
            if ((EmployeeRelation.getRelTable() != null) && (!"".equalsIgnoreCase(EmployeeRelation.getRelTable()))) {
                currentEmployeeRelation.setRelTable(EmployeeRelation.getRelTable());
            }
            if (EmployeeRelation.getRelType().equalsIgnoreCase(currentEmployeeRelation.getRelType()) ) {
                currentEmployeeRelation.setRelType(EmployeeRelation.getRelType());
            }
            if (EmployeeRelation.getRelData() != null) {
                currentEmployeeRelation.setRelData(EmployeeRelation.getRelData());
            }

            return EmployeeRelationRepository.save(currentEmployeeRelation);
        }
        return null;
    }

    public void deleteEmployeeRelation(UUID id) {
        EmployeeRelationRepository.deleteById(id);
    }
}
