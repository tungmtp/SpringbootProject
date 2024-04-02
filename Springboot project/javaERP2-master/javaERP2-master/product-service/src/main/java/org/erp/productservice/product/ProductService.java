package org.erp.productservice.product;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;
import java.util.List;
@Service
public class ProductService {
    @Autowired
    private ProductRepository ProductRepository;

    public List<Product> allProduct() {
        return ProductRepository.findAll();
    }
    public List<Product> getProductsByExtraCategoryID(UUID extraCategoryID) {
        return ProductRepository.findByExtraCategoryID(extraCategoryID);
    }

    public Product singleProduct(UUID id) {
        return ProductRepository.findById(id).orElseThrow(() -> new RuntimeException("Không tìm thấy sản phẩm này"));
    }

    public Product createProduct(Product Product) {
        return ProductRepository.save(Product);
    }


    public Product updateProduct(UUID id, Product newProductData) {
        Product currentProduct = ProductRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy sản phẩm này"));

        if (newProductData.getNameStr() != null && !newProductData.getNameStr().isEmpty()) {
            currentProduct.setNameStr(newProductData.getNameStr());
        }
        if (newProductData.getMeasID() != currentProduct.getMeasID()) {
            currentProduct.setMeasID(newProductData.getMeasID());
        }
        if (newProductData.getExtraCategoryID() != currentProduct.getExtraCategoryID()) {
            currentProduct.setExtraCategoryID(newProductData.getExtraCategoryID());
        }
        if (newProductData.getMinimumStock() != currentProduct.getMinimumStock()) {
            currentProduct.setMinimumStock(newProductData.getMinimumStock());
        }
        if (newProductData.isMayBeBuy() != currentProduct.isMayBeBuy()) {
            currentProduct.setMayBeBuy(newProductData.isMayBeBuy());
        }
        if (newProductData.isMayBeProduce() != currentProduct.isMayBeProduce()) {
            currentProduct.setMayBeProduce(newProductData.isMayBeProduce());
        }
        if (newProductData.isMayBeSell() != currentProduct.isMayBeSell()) {
            currentProduct.setMayBeSell(newProductData.isMayBeSell());
        }
        if (newProductData.isCanSellWithOutStock() != currentProduct.isCanSellWithOutStock()) {
            currentProduct.setCanSellWithOutStock(newProductData.isCanSellWithOutStock());
        }
        if (newProductData.isDisContinue() != currentProduct.isDisContinue()) {
            currentProduct.setDisContinue(newProductData.isDisContinue());
        }
        if (newProductData.getClassPriceID() != currentProduct.getClassPriceID()) {
            currentProduct.setClassPriceID(newProductData.getClassPriceID());
        }
        if (newProductData.getSegmentID() != currentProduct.getSegmentID()) {
            currentProduct.setSegmentID(newProductData.getSegmentID());
        }
        if (!newProductData.getComment().equals(currentProduct.getComment())) {
            currentProduct.setComment(newProductData.getComment());
        }
        if (newProductData.getCopyFrom() != currentProduct.getCopyFrom()) {
            currentProduct.setCopyFrom(newProductData.getCopyFrom());
        }
        if (newProductData.getCreatedOn() != currentProduct.getCreatedOn()) {
            currentProduct.setCreatedOn(newProductData.getCreatedOn());
        }

        return ProductRepository.save(currentProduct);
    }

    public void deleteProduct(UUID id) {
        ProductRepository.deleteById(id);
    }
}
