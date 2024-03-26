package org.erp.productservice.productRelation;
import org.erp.productservice.category.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class ProductRelationService {
    @Autowired
    private ProductRelationRepository ProductRelationRepository;

    public List<ProductRelation> allProductRelation() {
        return ProductRelationRepository.findAll();
    }

    public ProductRelation singleProductRelation(UUID id) {
        return ProductRelationRepository.findById(id).orElseThrow(() -> new RuntimeException("Không tìm thấy sản phẩm này"));
    }

    public ProductRelation createProductRelation(ProductRelation ProductRelation) {
        return ProductRelationRepository.save(ProductRelation);
    }

    public ProductRelation updateProductRelation(UUID id, ProductRelation ProductRelation) {
        ProductRelation currentProductRelation = ProductRelationRepository.findById(id).orElseThrow(() -> new RuntimeException("Không tìm thấy sản phẩm này"));
        if (currentProductRelation != null) {
            if ((ProductRelation.getRelTable() != null) && (!"".equalsIgnoreCase(ProductRelation.getRelTable()))) {
                currentProductRelation.setRelTable(ProductRelation.getRelTable());
            }
            if (ProductRelation.getRelType() != null) {
                currentProductRelation.setRelType(ProductRelation.getRelType());
            }
            if (ProductRelation.getRelData() != null) {
                currentProductRelation.setRelData(ProductRelation.getRelData());
            }

            return ProductRelationRepository.save(currentProductRelation);
        }
        return null;
    }

    public void deleteProductRelation(UUID id) {
        ProductRelationRepository.deleteById(id);
    }
}
