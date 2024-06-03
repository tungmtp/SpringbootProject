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
//        System.out.println(jsonResults);
        // Assuming the results are JSON strings, you can concatenate them or wrap them into a single JSON array.
        return String.join(",", jsonResults);
    }

    public String getOrderDeliveryByOrderID(String orderID) {
//        return orderDeliverySQLRepository.getOrderDeliveryByOrderID(orderID);
        List<String> jsonResults = orderDeliverySQLRepository.getOrderDeliveryByOrderID(orderID);
        // Assuming the results are JSON strings, you can concatenate them or wrap them into a single JSON array.
        return String.join(",", jsonResults);
    }

    public String getOrderDeliveryById(String id) {
        return orderDeliverySQLRepository.getOrderDeliveryById(id);
    }
}