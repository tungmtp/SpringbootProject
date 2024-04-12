package org.erp.productservice.stockOutDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.UUID;
@Service
public class StockOutDetailService {
    @Autowired
    private StockOutDetailRepository stockOutDetailRepository;

    public List<StockOutDetail> getAllStockOutDetails() {
        return stockOutDetailRepository.findAll();
    }

    public StockOutDetail getStockOutDetailById(UUID id) {
        return stockOutDetailRepository.findById(id).orElseThrow(() -> new RuntimeException("Không tìm thấy chi tiết phiếu xuat kho này"));
    }

    public StockOutDetail createStockOutDetail(StockOutDetail StockOutDetail) {
        return stockOutDetailRepository.save(StockOutDetail);
    }

    public StockOutDetail updateStockOutDetail(UUID id, StockOutDetail newStockOutDetail) {
        StockOutDetail currentStockOutDetail = stockOutDetailRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy chi tiết phiếu xuat kho này"));
            // Kiểm tra và cập nhật StockOutId
            if (!Objects.equals(newStockOutDetail.getStockOutID(), currentStockOutDetail.getStockOutID())) {
                currentStockOutDetail.setStockOutID(newStockOutDetail.getStockOutID());
            }

            // Kiểm tra và cập nhật productId
            if (!Objects.equals(newStockOutDetail.getProductID(), currentStockOutDetail.getProductID())) {
                currentStockOutDetail.setProductID(newStockOutDetail.getProductID());
            }

            // Kiểm tra và cập nhật messageId
            if (!Objects.equals(newStockOutDetail.getMeasID(), currentStockOutDetail.getMeasID())) {
                currentStockOutDetail.setMeasID(newStockOutDetail.getMeasID());
            }

            // Kiểm tra và cập nhật quality
            if (!Objects.equals(newStockOutDetail.getQuality(), currentStockOutDetail.getQuality())) {
                currentStockOutDetail.setQuality(newStockOutDetail.getQuality());
            }

            // Kiểm tra và cập nhật quantity
            if (!Objects.equals(newStockOutDetail.getQuantity(), currentStockOutDetail.getQuantity())) {
                currentStockOutDetail.setQuantity(newStockOutDetail.getQuantity());
            }

            // Kiểm tra và cập nhật relatedTable
            if (!Objects.equals(newStockOutDetail.getRelatedTable(), currentStockOutDetail.getRelatedTable())) {
                currentStockOutDetail.setRelatedTable(newStockOutDetail.getRelatedTable());
            }

            // Kiểm tra và cập nhật relatedId
            if (!Objects.equals(newStockOutDetail.getRelatedID(), currentStockOutDetail.getRelatedID())) {
                currentStockOutDetail.setRelatedID(newStockOutDetail.getRelatedID());
            }

            // Kiểm tra và cập nhật createdBy
            if (!Objects.equals(newStockOutDetail.getCreatedBy(), currentStockOutDetail.getCreatedBy())) {
                currentStockOutDetail.setCreatedBy(newStockOutDetail.getCreatedBy());
            }

            // Kiểm tra và cập nhật createdOn
            if (!Objects.equals(newStockOutDetail.getCreatedOn(), currentStockOutDetail.getCreatedOn())) {
                currentStockOutDetail.setCreatedOn(newStockOutDetail.getCreatedOn());
            }

            // Kiểm tra và cập nhật price
            if (!Objects.equals(newStockOutDetail.getPrice(), currentStockOutDetail.getPrice())) {
                currentStockOutDetail.setPrice(newStockOutDetail.getPrice());
            }

            // Kiểm tra và cập nhật vat
            if (!Objects.equals(newStockOutDetail.getVat(), currentStockOutDetail.getVat())) {
                currentStockOutDetail.setVat(newStockOutDetail.getVat());
            }

            // Kiểm tra và cập nhật priceType
            if (!Objects.equals(newStockOutDetail.getPriceType(), currentStockOutDetail.getPriceType())) {
                currentStockOutDetail.setPriceType(newStockOutDetail.getPriceType());
            }

           
            

            // Lưu và trả về chi tiết phiếu nhập kho đã được cập nhật
            return stockOutDetailRepository.save(currentStockOutDetail);

    }


    public void deleteStockOutDetail(UUID id) {
        stockOutDetailRepository.deleteById(id);
    }
}