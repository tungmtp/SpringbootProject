package org.erp.productservice.productAttribute;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class ProductAttributeService {
    @Autowired
    private ProductAttributeRepository ProductAttributeRepository;

    public List<ProductAttribute> allProductAttribute() {
        return ProductAttributeRepository.findAll();
    }

    public ProductAttribute singleProductAttribute(UUID id) {
        return ProductAttributeRepository.findById(id).orElseThrow(() -> new RuntimeException("Không tìm thấy sản phẩm này"));
    }

    public ProductAttribute createProductAttribute(ProductAttribute ProductAttribute) {
        return ProductAttributeRepository.save(ProductAttribute);
    }

    public ProductAttribute updateProductAttribute(UUID id, ProductAttribute ProductAttribute) {
        ProductAttribute currentCategory = ProductAttributeRepository.findById(id).orElseThrow(() -> new RuntimeException("Không tìm thấy sản phẩm này"));
        if (currentCategory != null) {
            if ((ProductAttribute.getAttName() != null) && (!"".equalsIgnoreCase(ProductAttribute.getAttName()))) {
                currentCategory.setAttName(ProductAttribute.getAttName());
            }
            if (ProductAttribute.getIsChildOf() != null) {
                currentCategory.setIsChildOf(ProductAttribute.getIsChildOf());
            }

            return ProductAttributeRepository.save(currentCategory);
        }
        return null;
    }

    public void deleteProductAttribute(UUID id) {
        ProductAttributeRepository.deleteById(id);
    }
}
