package org.erp.productservice.stockIn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.UUID;
@Service
public class StockInService {
    @Autowired
    private StockInRepository stockInRepository;

    public List<StockIn> getAllStockIns() {
        return stockInRepository.findAll();
    }

    public StockIn getStockInById(UUID id) {
        return stockInRepository.findById(id).orElseThrow(() -> new RuntimeException("Không tìm thấy phiếu nhập kho này"));
    }

    public StockIn createStockIn(StockIn stockIn) {
        return stockInRepository.save(stockIn);
    }

    public StockIn updateStockIn(UUID id, StockIn newStockIn) {
        StockIn currentStockIn = stockInRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy phiếu nhập kho này"));

        // Kiểm tra và cập nhật các trường có giá trị mới khác giá trị cũ (không null)
        if (!Objects.equals(newStockIn.getSlipDate(), currentStockIn.getSlipDate())) {
            currentStockIn.setSlipDate(newStockIn.getSlipDate());
        }
        if (!Objects.equals(newStockIn.getComment(), currentStockIn.getComment())) {
            currentStockIn.setComment(newStockIn.getComment());
        }
        if (!Objects.equals(newStockIn.getRelatedTable(), currentStockIn.getRelatedTable())) {
            currentStockIn.setRelatedTable(newStockIn.getRelatedTable());
        }
        if (!Objects.equals(newStockIn.getRelatedID(), currentStockIn.getRelatedID())) {
            currentStockIn.setRelatedID(newStockIn.getRelatedID());
        }
        if (!Objects.equals(newStockIn.getCreatedBy(), currentStockIn.getCreatedBy())) {
            currentStockIn.setCreatedBy(newStockIn.getCreatedBy());
        }
        if (!Objects.equals(newStockIn.getCreatedOn(), currentStockIn.getCreatedOn())) {
            currentStockIn.setCreatedOn(newStockIn.getCreatedOn());
        }
        if (!Objects.equals(newStockIn.getPurpose(), currentStockIn.getPurpose())) {
            currentStockIn.setPurpose(newStockIn.getPurpose());
        }
        if (!Objects.equals(newStockIn.getPaymentDate(), currentStockIn.getPaymentDate())) {
            currentStockIn.setPaymentDate(newStockIn.getPaymentDate());
        }
        if (!Objects.equals(newStockIn.getReceiveFrom(), currentStockIn.getReceiveFrom())) {
            currentStockIn.setReceiveFrom(newStockIn.getReceiveFrom());
        }
        if (!Objects.equals(newStockIn.getLock(), currentStockIn.getLock())) {
            currentStockIn.setLock(newStockIn.getLock());
        }
        if (!Objects.equals(newStockIn.getNoidung(), currentStockIn.getNoidung())) {
            currentStockIn.setNoidung(newStockIn.getNoidung());
        }
        if (newStockIn.getWarehouseID() != null) {
            currentStockIn.setWarehouseID(newStockIn.getWarehouseID());
        }

        // Lưu và trả về phiếu nhập kho đã được cập nhật
        return stockInRepository.save(currentStockIn);
    }

    public void deleteStockIn(UUID id) {
        stockInRepository.deleteById(id);
    }
}