package org.erp.productservice.product;


import jakarta.transaction.Transactional;
//import org.erp.apigetway.eventList.EventList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> allProduct() {
        return productRepository.findAll();
    }

    public List<Product> getProductsByExtraCategoryID(UUID extraCategoryID) {
        return productRepository.findByExtraCategoryID(extraCategoryID);
    }

    public Product singleProduct(UUID id) {
        return productRepository.findById(id).orElseThrow(() -> new RuntimeException("Không tìm thấy sản phẩm này"));
    }

    public Product createProduct(Product Product) {
        return productRepository.save(Product);
    }


    public Product updateProduct(UUID id, Product newProductData) {
        Product currentProduct = productRepository.findById(id)
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

        return productRepository.save(currentProduct);
    }

    public void deleteProduct(UUID id) {
        productRepository.deleteById(id);
    }

    public List<ProductForSelect> getProductContainingName(String name) { //Kien
        return productRepository.getProductContainingName(name);
    }

    @Transactional
    public List<ProductForSelect> getProductFirstCall(UUID productID) {
        //@Transactional
        List<Object[]> results = productRepository.getProductFirstCall(productID);
        return results.stream()
                .map(result -> new ProductForSelect(UUID.fromString((String) result[0]), (String) result[1]))
                .collect(Collectors.toList());
    }

    public List<ProductForSelect> getProductMayBeSellContainingName(String name) { //Kien
        return productRepository.getProductMayBeSellContainingName(name);
    }

    public List<ProductForSelect> getProductMayBeSellFirstCall(UUID id) {
        return productRepository.getProductMaBeSellFirstCall(id);
    }

    public List<org.erp.productservice.product.ProductWithMeasurement> getSingleProductWithMeasurement(UUID id) {
        return productRepository.getProductWithMeasurement(id);
    }

    public List<ProductForSelect> getProductMayBeProduceContainingName(String name) {
        List<Object[]> results = productRepository.getProductMayBeProduceContainingName(name);
        return results.stream()
                .map(result -> new ProductForSelect(UUID.fromString((String) result[0]), (String) result[1]))
                .collect(Collectors.toList());
    }

    public List<ProductForSelect> getProductMayBeProduceFirstCall(UUID uuid) {
        List<Object[]> results = productRepository.getProductMayBeProduceFirstCall(uuid);
        return results.stream()
                .map(result -> new ProductForSelect(UUID.fromString((String) result[0]), (String) result[1]))
                .collect(Collectors.toList());
    }

    public List<ProductBom> getProductMayBeProduce() {
        List<Object[]> results = productRepository.getProductMayBeProduce();
        return results.stream()
                .map(result -> new ProductBom(UUID.fromString((String) result[0]), (String) result[1], (int) result[2]))
                .collect(Collectors.toList());
    }

    public String physicalStock(String productId, String measId, String dateCheck) {
        List<String> results = productRepository.physicalStock(productId, measId, dateCheck);
        return String.join("", results);
    }

    public String allProductInOneWarehouse(int warehouseId, String fromDate, String toDate, int quality) {
        List<String> results = productRepository.allProductInOneWarehouse(warehouseId, fromDate, toDate, quality);
        return String.join("", results);
    }

    public String getInOutOneProductAtOneWarehouse(int warehouseId, String fromDate, String toDate, String productId) {
        List<String> results = productRepository.getInOutOneProductAtOneWarehouse(warehouseId, fromDate, toDate, productId);
        return String.join("", results);
    }

    public String oneProductAtAllWarehouse(UUID productID, String lastDate) {
        List<String> results = productRepository.oneProductAtAllWarehouse(productID, lastDate);
        return String.join("", results);
    }

    public String allProductByAttrAtAllWarehouse(String productAttrId, String lastDate) {
        List<String> results = productRepository.allProductByAttrAtAllWarehouse(productAttrId, lastDate);
        return String.join("", results);
    }

    public String allProductByClassAtAllWarehouse(String productClassId, String lastDate) {
        List<String> results = productRepository.allProductByClassAtAllWarehouse(productClassId, lastDate);
        return String.join("", results);
    }

    public Long getInventoryLowCount() {
        return productRepository.getInventoryLowCount();
    }


}
