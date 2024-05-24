package org.erp.businessservice.orderDeliveryDetail;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrderDeliveryDetailService {
    @Autowired
    private OrderDeliveryDetailRepository orderDeliveryDetailRepository;

    public List<OrderDeliveryDetail> getAllOrderDeliveryDetails() {
        return orderDeliveryDetailRepository.findAll();
    }

    public OrderDeliveryDetail getOrderDeliveryDetailById(UUID id) {
        return orderDeliveryDetailRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("OrderDeliveryDetail not found with id: " + id));
    }

    public OrderDeliveryDetail createOrderDeliveryDetail(OrderDeliveryDetail orderDeliveryDetail) {
        return orderDeliveryDetailRepository.save(orderDeliveryDetail);
    }

    public OrderDeliveryDetail updateOrderDeliveryDetail(UUID id, OrderDeliveryDetail orderDeliveryDetail) {
        OrderDeliveryDetail existingOrderDeliveryDetail = orderDeliveryDetailRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("OrderDeliveryDetail not found with id: " + id));

        if (!orderDeliveryDetail.getOrderDeliveryID().equals(existingOrderDeliveryDetail.getOrderDeliveryID())) {
            existingOrderDeliveryDetail.setOrderDeliveryID(orderDeliveryDetail.getOrderDeliveryID());
        }
        if (!orderDeliveryDetail.getOrderDetailID().equals(existingOrderDeliveryDetail.getOrderDetailID())) {
            existingOrderDeliveryDetail.setOrderDetailID(orderDeliveryDetail.getOrderDetailID());
        }
        if (!orderDeliveryDetail.getProductID().equals(existingOrderDeliveryDetail.getProductID())) {
            existingOrderDeliveryDetail.setProductID(orderDeliveryDetail.getProductID());
        }
        if (orderDeliveryDetail.getQuality() != existingOrderDeliveryDetail.getQuality()) {
            existingOrderDeliveryDetail.setQuality(orderDeliveryDetail.getQuality());
        }
        if (orderDeliveryDetail.getQuantity() != null && !orderDeliveryDetail.getQuantity().equals(existingOrderDeliveryDetail.getQuantity())) {
            existingOrderDeliveryDetail.setQuantity(orderDeliveryDetail.getQuantity());
        }
        if (!orderDeliveryDetail.getMeasID().equals(existingOrderDeliveryDetail.getMeasID())) {
            existingOrderDeliveryDetail.setMeasID(orderDeliveryDetail.getMeasID());
        }
        if (orderDeliveryDetail.getPrice() != null && !orderDeliveryDetail.getPrice().equals(existingOrderDeliveryDetail.getPrice())) {
            existingOrderDeliveryDetail.setPrice(orderDeliveryDetail.getPrice());
        }
        if (orderDeliveryDetail.getVat() != null && !orderDeliveryDetail.getVat().equals(existingOrderDeliveryDetail.getVat())) {
            existingOrderDeliveryDetail.setVat(orderDeliveryDetail.getVat());
        }

        return orderDeliveryDetailRepository.save(existingOrderDeliveryDetail);
    }

    public void deleteOrderDeliveryDetail(UUID id) {
        orderDeliveryDetailRepository.deleteById(id);
    }

    public List<OrderDeliveryDetail> getByOrderDeliveryID(UUID orderDeliveryID) {
        return orderDeliveryDetailRepository.findByOrderDeliveryID(orderDeliveryID);

    }
}