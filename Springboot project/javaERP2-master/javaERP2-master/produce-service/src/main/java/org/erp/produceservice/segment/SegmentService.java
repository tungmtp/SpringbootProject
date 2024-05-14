package org.erp.produceservice.segment;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SegmentService {
//    @Value("${rabbitmq.exchange.name}")
//    private String exchange;
//    @Value("${rabbitmq.routing.key}")
//    private String routingKey;

    private static final Logger LOGGER = LoggerFactory.getLogger(SegmentService.class);
    private RabbitTemplate rabbitTemplate;

    public SegmentService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    //    public void sendMessage (String message){
//        LOGGER.info(String.format("Message sent -> %s", message));
////        rabbitTemplate.convertAndSend("javaguides_exchange", "javaguides_routing_key", message);
//    }
    @Autowired
    private SegmentRepository SegmentRepository;

    public List<Segment> allSegment() {
        return SegmentRepository.findAll();
    }

    public Segment singleSegment(UUID id) {
        return SegmentRepository.findById(id).orElseThrow(() -> new RuntimeException("Không tìm thấy sản phẩm này"));
    }

    public Segment createSegment(Segment Segment) {
//        rabbitTemplate.convertAndSend("javaguides_exchange", "javaguides_routing_key", Segment);
        return SegmentRepository.save(Segment);
    }

    public Segment updateSegment(UUID id, Segment Segment) {
        Segment currentSegment = SegmentRepository.findById(id).orElseThrow(() -> new RuntimeException("Không tìm thấy sản phẩm này"));
        if (currentSegment != null) {
            if ((Segment.getSegmentName() != null) && (!"".equalsIgnoreCase(Segment.getSegmentName()))) {
                currentSegment.setSegmentName(Segment.getSegmentName());
            }
            if ((Segment.getProductGroup() != null) && (!"".equalsIgnoreCase(Segment.getProductGroup()))) {
                currentSegment.setProductGroup(Segment.getProductGroup());
            }
            if ((Segment.getOrderLevel() != 0) && Segment.getOrderLevel() != currentSegment.getOrderLevel()) {
                currentSegment.setOrderLevel(Segment.getOrderLevel());
            }
            if (Segment.getSubCATID() != currentSegment.getSubCATID()) {
                currentSegment.setSubCATID(Segment.getSubCATID());
            }
            if (Segment.isSkipCalendar() != currentSegment.isSkipCalendar()) {
                currentSegment.setSkipCalendar(Segment.isSkipCalendar());
            }

            return SegmentRepository.save(currentSegment);
        }
        return null;
    }

    public UUID deleteSegment(UUID id) {
        SegmentRepository.deleteById(id);
        return id;
    }

    public List<SegmentForSelect> getItemContainingQuery(String query) {
        return SegmentRepository.getItemContainingQuery(query);
    }

    public List<SegmentForSelect> getItemFamiliar() {
        return SegmentRepository.getItemFamiliar();
    }
}
