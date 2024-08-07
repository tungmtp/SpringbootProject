package org.erp.businessservice.orderDelivery;

import org.erp.businessservice.orderDelivery.OrderDeliveryWithPartner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class OrderDeliverySQLService {
    @Autowired
    private OrderDeliverySQLRepository orderDeliverySQLRepository;

    public String getOrderDeliveryByDeliveryDate(String mDate) {
//        return orderDeliverySQLRepository.getOrderDeliveryByDeliveryDate(mDate);
        List<String> jsonResults = orderDeliverySQLRepository.getOrderDeliveryByDeliveryDate(mDate);
        return String.join("", jsonResults);
    }

    public String getOrderDeliveryByOrderID(String orderID) {
//        return orderDeliverySQLRepository.getOrderDeliveryByOrderID(orderID);
        List<String> jsonResults = orderDeliverySQLRepository.getOrderDeliveryByOrderID(orderID);
        // Assuming the results are JSON strings, you can concatenate them or wrap them into a single JSON array.
        return String.join("", jsonResults);
    }

    public String getOrderDeliveryById(String id) {
        List<String> jsonResults = orderDeliverySQLRepository.getOrderDeliveryById(id);
//        System.out.println(jsonResults);
        return String.join("", jsonResults);
    }

    public String getOrderDeliveryById2(String id) {
        List<String> results = orderDeliverySQLRepository.getOrderDeliveryById2(id);
        if (results.isEmpty()) {
            return null;
        }
//        return results.get(0);
        return String.join("", results);
    }

    public String getDeliveryByReqDateOfOrder(String orderID, String reqDate) {
        List<String> results = orderDeliverySQLRepository.getDeliveryByReqDateOfOrder(orderID, reqDate);
        if (results.isEmpty()) return null;
        return String.join("", results);
    }
}