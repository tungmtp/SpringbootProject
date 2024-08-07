package org.erp.businessservice.orderDelivery;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrderDeliveryService {
    @Autowired
    private OrderDeliveryRepository orderDeliveryRepository;

    public List<OrderDelivery> getAllOrderDeliveries() {
        return orderDeliveryRepository.findAll();
    }

    public OrderDelivery getOrderDeliveryById(UUID id) {
        return orderDeliveryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("OrderDelivery not found with id: " + id));
    }

    public OrderDelivery createOrderDelivery(OrderDelivery orderDelivery) {
        return orderDeliveryRepository.save(orderDelivery);
    }

    public OrderDelivery updateOrderDelivery(UUID id, OrderDelivery orderDelivery) {
        OrderDelivery existingOrderDelivery = orderDeliveryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("OrderDelivery not found with id: " + id));

        if (orderDelivery.getOrderID() != null) {
            existingOrderDelivery.setOrderID(orderDelivery.getOrderID());
        }
        if (orderDelivery.getDeliveryDate() != null) {
            existingOrderDelivery.setDeliveryDate(orderDelivery.getDeliveryDate());
        }
        if (orderDelivery.getDeliveryAddress() != null && !orderDelivery.getDeliveryAddress().equals(existingOrderDelivery.getDeliveryAddress())) {
            existingOrderDelivery.setDeliveryAddress(orderDelivery.getDeliveryAddress());
        }
        if (orderDelivery.getWarehouseID() != 0 && orderDelivery.getWarehouseID() != (existingOrderDelivery.getWarehouseID())) {
            existingOrderDelivery.setWarehouseID(orderDelivery.getWarehouseID());
        }
        if (orderDelivery.getCreatedBy() != null) {
            existingOrderDelivery.setCreatedBy(orderDelivery.getCreatedBy());
        }
        if (orderDelivery.getCreatedOn() != null) {
            existingOrderDelivery.setCreatedOn(orderDelivery.getCreatedOn());
        }
        if (orderDelivery.isCancel() != existingOrderDelivery.isCancel()) {
            existingOrderDelivery.setCancel(orderDelivery.isCancel());
        }
        if (orderDelivery.isCompleted() != existingOrderDelivery.isCompleted()) {
            existingOrderDelivery.setCompleted(orderDelivery.isCompleted());
        }
        if (orderDelivery.getPurpose() != 0 && orderDelivery.getPurpose() != existingOrderDelivery.getPurpose()) {
            existingOrderDelivery.setPurpose(orderDelivery.getPurpose());
        }
        if (orderDelivery.getPaymentDate() != null && !orderDelivery.getPaymentDate().equals(existingOrderDelivery.getPaymentDate())) {
            existingOrderDelivery.setPaymentDate(orderDelivery.getPaymentDate());
        }
        if (orderDelivery.isInProcess() != existingOrderDelivery.isInProcess()) {
            existingOrderDelivery.setInProcess(orderDelivery.isInProcess());
        }

        return orderDeliveryRepository.save(existingOrderDelivery);
    }

    public UUID deleteOrderDelivery(UUID id) {
        orderDeliveryRepository.deleteById(id);
        return id;
    }
}