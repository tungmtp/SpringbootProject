package org.erp.productservice.classPrice;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class ClassPriceService {
    @Autowired
    private ClassPriceRepository ClassPriceRepository;

    public List<ClassPrice> allClassPrice() {
        return ClassPriceRepository.findAll();
    }

    public ClassPrice singleClassPrice(UUID id) {
        return ClassPriceRepository.findById(id).orElseThrow(() -> new RuntimeException("Không tìm thấy sản phẩm này"));
    }

    public ClassPrice createClassPrice(ClassPrice ClassPrice) {
        return ClassPriceRepository.save(ClassPrice);
    }

    public ClassPrice updateClassPrice(UUID id, ClassPrice ClassPrice) {
        ClassPrice currentClassPrice = ClassPriceRepository.findById(id).orElseThrow(() -> new RuntimeException("Không tìm thấy sản phẩm này"));
        if (currentClassPrice != null) {
            if ((ClassPrice.getClassId() != currentClassPrice.getClassId())) {
                currentClassPrice.setClassId(ClassPrice.getClassId());
            }

            if (ClassPrice.getDateEffected() != currentClassPrice.getDateEffected()) {
                currentClassPrice.setDateEffected(ClassPrice.getDateEffected());
            }
            if (ClassPrice.getPrice() != currentClassPrice.getPrice()) {
                currentClassPrice.setPrice(ClassPrice.getPrice());
            }
            if (ClassPrice.getDefaultMeas() != currentClassPrice.getDefaultMeas()) {
                currentClassPrice.setDefaultMeas(ClassPrice.getDefaultMeas());
            }

            return ClassPriceRepository.save(currentClassPrice);
        }
        return null;
    }

    public void deleteClassPrice(UUID id) {
        ClassPriceRepository.deleteById(id);
    }
}
