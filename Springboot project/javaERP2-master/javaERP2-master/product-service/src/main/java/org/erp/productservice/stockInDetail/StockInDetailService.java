package org.erp.productservice.stockInDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.UUID;
@Service
public class StockInDetailService {
    @Autowired
    private StockInDetailRepository stockInDetailRepository;

    public List<StockInDetail> getAllStockInDetails() {
        return stockInDetailRepository.findAll();
    }

    public StockInDetail getStockInDetailById(UUID id) {
        return stockInDetailRepository.findById(id).orElseThrow(() -> new RuntimeException("Không tìm thấy chi tiết phiếu nhập kho này"));
    }

    public StockInDetail createStockInDetail(StockInDetail stockInDetail) {
        return stockInDetailRepository.save(stockInDetail);
    }

    public StockInDetail updateStockInDetail(UUID id, StockInDetail newStockInDetail) {
        StockInDetail currentStockInDetail = stockInDetailRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy chi tiết phiếu nhập kho này"));
            // Kiểm tra và cập nhật stockInId
            if (!Objects.equals(newStockInDetail.getStockInId(), currentStockInDetail.getStockInId())) {
                currentStockInDetail.setStockInId(newStockInDetail.getStockInId());
            }

            // Kiểm tra và cập nhật productId
            if (!Objects.equals(newStockInDetail.getProductId(), currentStockInDetail.getProductId())) {
                currentStockInDetail.setProductId(newStockInDetail.getProductId());
            }

            // Kiểm tra và cập nhật messageId
            if (!Objects.equals(newStockInDetail.getMessageId(), currentStockInDetail.getMessageId())) {
                currentStockInDetail.setMessageId(newStockInDetail.getMessageId());
            }

            // Kiểm tra và cập nhật quality
            if (!Objects.equals(newStockInDetail.getQuality(), currentStockInDetail.getQuality())) {
                currentStockInDetail.setQuality(newStockInDetail.getQuality());
            }

            // Kiểm tra và cập nhật quantity
            if (!Objects.equals(newStockInDetail.getQuantity(), currentStockInDetail.getQuantity())) {
                currentStockInDetail.setQuantity(newStockInDetail.getQuantity());
            }

            // Kiểm tra và cập nhật relatedTable
            if (!Objects.equals(newStockInDetail.getRelatedTable(), currentStockInDetail.getRelatedTable())) {
                currentStockInDetail.setRelatedTable(newStockInDetail.getRelatedTable());
            }

            // Kiểm tra và cập nhật relatedId
            if (!Objects.equals(newStockInDetail.getRelatedId(), currentStockInDetail.getRelatedId())) {
                currentStockInDetail.setRelatedId(newStockInDetail.getRelatedId());
            }

            // Kiểm tra và cập nhật createdBy
            if (!Objects.equals(newStockInDetail.getCreatedBy(), currentStockInDetail.getCreatedBy())) {
                currentStockInDetail.setCreatedBy(newStockInDetail.getCreatedBy());
            }

            // Kiểm tra và cập nhật createdOn
            if (!Objects.equals(newStockInDetail.getCreatedOn(), currentStockInDetail.getCreatedOn())) {
                currentStockInDetail.setCreatedOn(newStockInDetail.getCreatedOn());
            }

            // Kiểm tra và cập nhật price
            if (!Objects.equals(newStockInDetail.getPrice(), currentStockInDetail.getPrice())) {
                currentStockInDetail.setPrice(newStockInDetail.getPrice());
            }

            // Kiểm tra và cập nhật vat
            if (!Objects.equals(newStockInDetail.getVat(), currentStockInDetail.getVat())) {
                currentStockInDetail.setVat(newStockInDetail.getVat());
            }

            // Kiểm tra và cập nhật priceType
            if (!Objects.equals(newStockInDetail.getPriceType(), currentStockInDetail.getPriceType())) {
                currentStockInDetail.setPriceType(newStockInDetail.getPriceType());
            }

            // Kiểm tra và cập nhật importTax
            if (!Objects.equals(newStockInDetail.getImportTax(), currentStockInDetail.getImportTax())) {
                currentStockInDetail.setImportTax(newStockInDetail.getImportTax());
            }

            // Kiểm tra và cập nhật currency
            if (!Objects.equals(newStockInDetail.getCurrency(), currentStockInDetail.getCurrency())) {
                currentStockInDetail.setCurrency(newStockInDetail.getCurrency());
            }

            // Kiểm tra và cập nhật rate
            if (!Objects.equals(newStockInDetail.getRate(), currentStockInDetail.getRate())) {
                currentStockInDetail.setRate(newStockInDetail.getRate());
            }

            // Lưu và trả về chi tiết phiếu nhập kho đã được cập nhật
            return stockInDetailRepository.save(currentStockInDetail);

    }


    public void deleteStockInDetail(UUID id) {
        stockInDetailRepository.deleteById(id);
    }
}