package org.erp.productservice.product;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.List;
@Service
public class ProductService {
    @Autowired
    private ProductRepository ProductRepository;

    public List<Product> allProduct() {
        return ProductRepository.findAll();
    }

    public Product singleProduct(UUID id) {
        return ProductRepository.findById(id).orElseThrow(() -> new RuntimeException("Không tìm thấy sản phẩm này"));
    }

    public Product createProduct(Product Product) {
        return ProductRepository.save(Product);
    }

    public Product updateProduct(UUID id, Product Product) {
        Product currentProduct = ProductRepository.findById(id).orElseThrow(() -> new RuntimeException("Không tìm thấy sản phẩm này"));
        if (currentProduct != null) {
            if ((Product.getCatName() != null) && (!"".equalsIgnoreCase(Product.getCatName()))) {
                currentProduct.setCatName(Product.getCatName());
            }
            if (Product.getIsChildOf() != null) {
                currentProduct.setIsChildOf(Product.getIsChildOf());
            }

            return ProductRepository.save(currentProduct);
        }
        return null;
    }

    public void deleteProduct(UUID id) {
        ProductRepository.deleteById(id);
    }
}
