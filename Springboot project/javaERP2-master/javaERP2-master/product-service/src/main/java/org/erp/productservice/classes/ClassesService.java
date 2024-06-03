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
    private ClassesRepository classesRepository;

    public List<Classes> allClasses() {
        return classesRepository.findAll();
    }

    public Classes singleClass(UUID id) {
        return classesRepository.findById(id).orElseThrow(() -> new RuntimeException("Không tìm thấy sản phẩm này"));
    }

    public Classes createClass(Classes ProductAttribute) {
        return classesRepository.save(ProductAttribute);
    }

    public Classes updateClass(UUID id, Classes Classes) {
        Classes currentClasses = classesRepository.findById(id).orElseThrow(() -> new RuntimeException("Không tìm thấy sản phẩm này"));
        if (currentClasses != null) {
            if ((Classes.getNameStr() != null) && (!"".equalsIgnoreCase(Classes.getNameStr()))) {
                currentClasses.setNameStr(Classes.getNameStr());
            }
            if ((Classes.getClassType() != null) && (!"".equalsIgnoreCase(Classes.getNameStr()))) {
                currentClasses.setClassType(Classes.getClassType());
            }

            return classesRepository.save(currentClasses);
        }
        return null;
    }

    public void deleteClass(UUID id) {
        classesRepository.deleteById(id);
    }

    public List<ClassForSelect> getClassContainingQuery(String query) {
        return classesRepository.getClassContainingQuery(query);
    }

    public List<ClassForSelect> getClassFamiliar() {
        return classesRepository.getClassFamiliar();
    }
}
