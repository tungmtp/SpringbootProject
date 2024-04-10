package org.erp.businessservice.orderDetail;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class OrderDetailService {
    @Autowired
    private org.erp.businessservice.orderDetail.OrderDetailRepository OrderDetailRepository;

    public List<OrderDetail> allOrdersDetail() {
        return OrderDetailRepository.findAll();
    }

    public OrderDetail singleOrdersDetail(UUID id) {
        return OrderDetailRepository.findById(id).orElseThrow(() -> new RuntimeException("Không tìm thấy sản phẩm này"));
    }

    public OrderDetail createOrdersDetail(OrderDetail OrderDetail) {
        return OrderDetailRepository.save(OrderDetail);
    }

    public OrderDetail updateOrdersDetail(UUID id, OrderDetail OrdersDetail) {
        OrderDetail currentOrdersDetail = OrderDetailRepository.findById(id).orElseThrow(() -> new RuntimeException("Không tìm thấy sản phẩm này"));
        if (currentOrdersDetail != null) {
            if (OrdersDetail.getOrderID() != currentOrdersDetail.getOrderID()) {
                currentOrdersDetail.setOrderID(OrdersDetail.getOrderID());
            }
            if (OrdersDetail.getProductID() != currentOrdersDetail.getProductID()) {
                currentOrdersDetail.setProductID(OrdersDetail.getProductID());
            }
            if (OrdersDetail.getMeasID() != currentOrdersDetail.getMeasID()) {
                currentOrdersDetail.setMeasID(OrdersDetail.getMeasID());
            }
            if (OrdersDetail.getQuality() != currentOrdersDetail.getQuality()) {
                currentOrdersDetail.setQuality(OrdersDetail.getQuality());
            }
            if (OrdersDetail.getQuantity() != currentOrdersDetail.getQuantity()) {
                currentOrdersDetail.setQuantity(OrdersDetail.getQuantity());
            }
            if (OrdersDetail.getPrice() != currentOrdersDetail.getPrice()) {
                currentOrdersDetail.setPrice(OrdersDetail.getPrice());
            }
            if (OrdersDetail.isConfirmed() != currentOrdersDetail.isConfirmed()) {
                currentOrdersDetail.setConfirmed(OrdersDetail.isConfirmed());
            }
            if (OrdersDetail.isCompleted() != currentOrdersDetail.isCompleted()) {
                currentOrdersDetail.setCompleted(OrdersDetail.isCompleted());
            }
            if (OrdersDetail.isReceiving() != currentOrdersDetail.isReceiving()) {
                currentOrdersDetail.setReceiving(OrdersDetail.isReceiving());
            }
            if (OrdersDetail.getImportTax() != currentOrdersDetail.getImportTax()) {
                currentOrdersDetail.setImportTax(OrdersDetail.getImportTax());
            }
            if ((OrdersDetail.getCurrency() != null) && (!"".equalsIgnoreCase(OrdersDetail.getCurrency()))) {
                currentOrdersDetail.setCurrency(OrdersDetail.getCurrency());
            }
            if (OrdersDetail.getRate() != currentOrdersDetail.getRate()) {
                currentOrdersDetail.setRate(OrdersDetail.getRate());
            }
            return OrderDetailRepository.save(currentOrdersDetail);
        }
        return null;
    }

    public void deleteOrdersDetail(UUID id) {
        OrderDetailRepository.deleteById(id);
    }
}
