package org.erp.productservice.classes;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
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
}
