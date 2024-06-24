package org.erp.produceservice.ordersProduce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrdersProduceService {
    @Autowired
    private OrdersProduceRepository ordersProduceRepository;

    public List<OrdersProduce> getAllOrdersProduce() {
        return ordersProduceRepository.findAll();
    }

    public OrdersProduce getOrdersProduceById(UUID id) {
        return ordersProduceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("OrdersProduce not found with id: " + id));
    }

    public OrdersProduce createOrdersProduce(OrdersProduce ordersProduce) {
        return ordersProduceRepository.save(ordersProduce);
    }

    public OrdersProduce updateOrdersProduce(UUID id, OrdersProduce updatedOrdersProduce) {
        OrdersProduce existingOrdersProduce = ordersProduceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("OrdersProduce not found with id: " + id));

//        if (updatedOrdersProduce.getOrdersID() != null && !existingOrdersProduce.getOrdersID().equals(updatedOrdersProduce.getOrdersID())) {
//            existingOrdersProduce.setOrdersID(updatedOrdersProduce.getOrdersID());
//        }

        if (updatedOrdersProduce.getOrderDetailID() != null && !existingOrdersProduce.getOrderDetailID().equals(updatedOrdersProduce.getOrderDetailID())) {
            existingOrdersProduce.setOrderDetailID(updatedOrdersProduce.getOrderDetailID());
        }

        if (updatedOrdersProduce.getQuantity() != null && !existingOrdersProduce.getQuantity().equals(updatedOrdersProduce.getQuantity())) {
            existingOrdersProduce.setQuantity(updatedOrdersProduce.getQuantity());
        }

        if (updatedOrdersProduce.getReqDate() != null && !existingOrdersProduce.getReqDate().equals(updatedOrdersProduce.getReqDate())) {
            existingOrdersProduce.setReqDate(updatedOrdersProduce.getReqDate());
        }

//        if (updatedOrdersProduce.getComment() != null && !existingOrdersProduce.getComment().equals(updatedOrdersProduce.getComment())) {
//            existingOrdersProduce.setComment(updatedOrdersProduce.getComment());
//        }

        if (updatedOrdersProduce.isGenerated() != existingOrdersProduce.isGenerated()) {
            existingOrdersProduce.setGenerated(updatedOrdersProduce.isGenerated());
        }

        if (updatedOrdersProduce.isMarkDone() != existingOrdersProduce.isMarkDone()) {
            existingOrdersProduce.setMarkDone(updatedOrdersProduce.isMarkDone());
        }

        return ordersProduceRepository.save(existingOrdersProduce);
    }

    public void deleteOrdersProduce(UUID id) {
        ordersProduceRepository.deleteById(id);
    }

    public String orderRequestSumary(UUID uuid) {
        List<String> results = ordersProduceRepository.orderRequestSumary(uuid);
        return String.join("", results);
    }

    public String orderRequestDistinctDate(UUID uuid) {
        List<String> results = ordersProduceRepository.orderRequestDistinctDate(uuid);
        return String.join("", results);
    }

    public String getOrderRequestByOrderIdAndDate(UUID uuid, String mDate) {
        List<String> results = ordersProduceRepository.getOrderRequestByOrderIdAndDate(uuid, mDate);
        return String.join("", results);
    }

    public String getOrderRequestByOrderId(UUID uuid) {
        List<String> results = ordersProduceRepository.getOrderRequestByOrderId(uuid);
        return String.join("", results);
    }
}
