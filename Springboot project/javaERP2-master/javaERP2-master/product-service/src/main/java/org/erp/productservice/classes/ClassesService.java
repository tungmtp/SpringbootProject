package org.erp.productservice.classes;


import org.erp.productservice.measurement.MeasurementForSelect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ClassesService {
    @Autowired
    private ClassesRepository ClassesRepository;

    public List<Classes> allClasses() {
        return ClassesRepository.findAll();
    }

    public Classes singleClass(UUID id) {
        return ClassesRepository.findById(id).orElseThrow(() -> new RuntimeException("Không tìm thấy sản phẩm này"));
    }

    public Classes createClass(Classes ProductAttribute) {
        return ClassesRepository.save(ProductAttribute);
    }

    public Classes updateClass(UUID id, Classes Classes) {
        Classes currentClasses = ClassesRepository.findById(id).orElseThrow(() -> new RuntimeException("Không tìm thấy sản phẩm này"));
        if (currentClasses != null) {
            if ((Classes.getNameStr() != null) && (!"".equalsIgnoreCase(Classes.getNameStr()))) {
                currentClasses.setNameStr(Classes.getNameStr());
            }
            if ((Classes.getClassType() != null) && (!"".equalsIgnoreCase(Classes.getNameStr()))) {
                currentClasses.setClassType(Classes.getClassType());
            }

            return ClassesRepository.save(currentClasses);
        }
        return null;
    }

    public void deleteClass(UUID id) {
        ClassesRepository.deleteById(id);
    }

    public List<ClassForSelect> getMeasurementContainingQuery(String query) {
        return ClassesRepository.getMeasurementContainingQuery(query);
    }

    public List<ClassForSelect> getMeasurementFamiliar(UUID measID) {
        return ClassesRepository.getClassFamiliar();
//        return results.stream()
//                .map(result -> new ClassForSelect(UUID.fromString((String) result[0]), (String) result[1]))
//                .collect(Collectors.toList());
    }
}
