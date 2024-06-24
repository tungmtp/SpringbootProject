package org.erp.productservice.stockOut;

import org.erp.productservice.stockIn.StockIn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
public class StockOutService {
    @Autowired
    private StockOutRepository stockOutRepository;

    public List<StockOut> getAllStockOuts() {
        return stockOutRepository.findAll();
    }

    public StockOut getStockOutById(UUID id) {
        return stockOutRepository.findById(id).orElseThrow(() -> new RuntimeException("Không tìm thấy phiếu nhập kho này"));
    }

    public StockOut createStockOut(StockOut StockOut) {
        return stockOutRepository.save(StockOut);
    }

    public StockOut updateStockOut(UUID id, StockOut newStockOut) {
        StockOut currentStockOut = stockOutRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy phiếu nhập kho này"));

        // Kiểm tra và cập nhật các trường có giá trị mới khác giá trị cũ (không null)
        if (!Objects.equals(newStockOut.getSlipDate(), currentStockOut.getSlipDate())) {
            currentStockOut.setSlipDate(newStockOut.getSlipDate());
        }
        if (!Objects.equals(newStockOut.getComment(), currentStockOut.getComment())) {
            currentStockOut.setComment(newStockOut.getComment());
        }
        if (!Objects.equals(newStockOut.getRelatedTable(), currentStockOut.getRelatedTable())) {
            currentStockOut.setRelatedTable(newStockOut.getRelatedTable());
        }
        if (!Objects.equals(newStockOut.getRelatedID(), currentStockOut.getRelatedID())) {
            currentStockOut.setRelatedID(newStockOut.getRelatedID());
        }
        if (!Objects.equals(newStockOut.getCreatedBy(), currentStockOut.getCreatedBy())) {
            currentStockOut.setCreatedBy(newStockOut.getCreatedBy());
        }
        if (!Objects.equals(newStockOut.getCreatedOn(), currentStockOut.getCreatedOn())) {
            currentStockOut.setCreatedOn(newStockOut.getCreatedOn());
        }
        if (!Objects.equals(newStockOut.getPurpose(), currentStockOut.getPurpose())) {
            currentStockOut.setPurpose(newStockOut.getPurpose());
        }
        if (!Objects.equals(newStockOut.getPaymentDate(), currentStockOut.getPaymentDate())) {
            currentStockOut.setPaymentDate(newStockOut.getPaymentDate());
        }
        if (!Objects.equals(newStockOut.getShipTo(), currentStockOut.getShipTo())) {
            currentStockOut.setShipTo(newStockOut.getShipTo());
        }
        if (!Objects.equals(newStockOut.getLock(), currentStockOut.getLock())) {
            currentStockOut.setLock(newStockOut.getLock());
        }
        if (!Objects.equals(newStockOut.getNoidung(), currentStockOut.getNoidung())) {
            currentStockOut.setNoidung(newStockOut.getNoidung());
        }
        if (newStockOut.getWarehouseID() != 0) {
            currentStockOut.setWarehouseID(newStockOut.getWarehouseID());
        }

        // Lưu và trả về phiếu nhập kho đã được cập nhật
        return stockOutRepository.save(currentStockOut);
    }

    public void deleteStockOut(UUID id) {
        stockOutRepository.deleteById(id);
    }

    public List<StockOut> getStockOutByDate(String startDate, String endDate) {
        return stockOutRepository.getStockOutByDate(startDate, endDate);
    }

    public String getStockOutDetailByStockOutID(String stockOutID) {
        List<String> jsonResults = stockOutRepository.getStockOutDetailByStockOutID(stockOutID);
//        System.out.println(jsonResults);
        return String.join("", jsonResults);
    }

    public List<StockOut> getStockOutBetweenWarehouses(String startDate, String endDate, int warehouseID) {
        return stockOutRepository.getStockOutBetweenWareHouses(startDate, endDate, warehouseID);
    }
}