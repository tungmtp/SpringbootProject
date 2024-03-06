package org.erp.productservice.category;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class CategoryService {
    @Autowired
    private CategoryRepository CategoryRepository;

    public List<Category> allProduct() {
        return CategoryRepository.findAll();
    }

    public Category singleProduct(UUID id) {
        return CategoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Không tìm thấy sản phẩm này"));
    }

    public Category createProduct(Category Category) {
        return CategoryRepository.save(Category);
    }

    public Category updateProduct(UUID id, Category Category) {
        Category currentCategory = CategoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Không tìm thấy sản phẩm này"));
        if (currentCategory != null) {
            if ((Category.getCatName() != null) && (!"".equalsIgnoreCase(Category.getCatName()))) {
                currentCategory.setCatName(Category.getCatName());
            }
            if (Category.getIsChildOf() != null) {
                currentCategory.setIsChildOf(Category.getIsChildOf());
            }

            return CategoryRepository.save(currentCategory);
        }
        return null;
    }

    public void deleteProduct(UUID id) {
        CategoryRepository.deleteById(id);
    }
}
