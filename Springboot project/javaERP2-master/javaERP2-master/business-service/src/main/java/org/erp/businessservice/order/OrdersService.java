package org.erp.businessservice.order;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;
@Service
public class OrdersService {
    @Autowired
    private OrdersRepository orderRepository;

    public List<Orders> getAllOrders() {
        return orderRepository.findAll();
    }

    public List<Orders> getOrdersByOrderDate(Date orderDate) {
        return orderRepository.findByOrderDate(orderDate);
    }
    public Orders getOrderById(UUID id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found with id: " + id));
    }

    public Orders createOrder(Orders order) {
        return orderRepository.save(order);
    }

    public Orders updateOrder(UUID id, Orders order) {
        Orders existingOrder = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found with id: " + id));

        if (order.getOrderType() != existingOrder.getOrderType()) {
            existingOrder.setOrderType(order.getOrderType());
        }
        if (!order.getOrderDate().equals(existingOrder.getOrderDate())) {
            existingOrder.setOrderDate(order.getOrderDate());
        }
        if (!order.getEndDate().equals(existingOrder.getEndDate())) {
            existingOrder.setEndDate(order.getEndDate());
        }
        if (order.getComment() != null && !order.getComment().equals(existingOrder.getComment())) {
            existingOrder.setComment(order.getComment());
        }
        if (order.getPartnersID() != existingOrder.getPartnersID()) {
            existingOrder.setPartnersID(order.getPartnersID());
        }
        if (order.getProjectID() != null && !order.getProjectID().equals(existingOrder.getProjectID())) {
            existingOrder.setProjectID(order.getProjectID());
        }
        if (order.getContactID() != null && !order.getContactID().equals(existingOrder.getContactID())) {
            existingOrder.setContactID(order.getContactID());
        }
        if (order.getStaffControl() != null && !order.getStaffControl().equals(existingOrder.getStaffControl())) {
            existingOrder.setStaffControl(order.getStaffControl());
        }
        if (order.isComplete() != existingOrder.isComplete()) {
            existingOrder.setComplete(order.isComplete());
        }
        if (!order.getCreatedBy().equals(existingOrder.getCreatedBy())) {
            existingOrder.setCreatedBy(order.getCreatedBy());
        }
        if (!order.getCreatedOn().equals(existingOrder.getCreatedOn())) {
            existingOrder.setCreatedOn(order.getCreatedOn());
        }
        if (order.getCalcType() != existingOrder.getCalcType()) {
            existingOrder.setCalcType(order.getCalcType());
        }
        if (order.getLotNo() != null && !order.getLotNo().equals(existingOrder.getLotNo())) {
            existingOrder.setLotNo(order.getLotNo());
        }
        if (order.getProjectitemID() != null && !order.getProjectitemID().equals(existingOrder.getProjectitemID())) {
            existingOrder.setProjectitemID(order.getProjectitemID());
        }
        if (order.getEditBy() != null && !order.getEditBy().equals(existingOrder.getEditBy())) {
            existingOrder.setEditBy(order.getEditBy());
        }

        return orderRepository.save(existingOrder);
    }

    public void deleteOrder(UUID id) {
        orderRepository.deleteById(id);
    }
}
