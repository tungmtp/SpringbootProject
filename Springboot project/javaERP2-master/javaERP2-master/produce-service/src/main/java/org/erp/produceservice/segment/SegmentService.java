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

    public Segment updateSegment(UUID id, Segment segment) {
        Segment currentSegment = SegmentRepository.findById(id).orElseThrow(() -> new RuntimeException("Không tìm thấy sản phẩm này"));
        if (currentSegment != null) {
            if ((segment.getSegmentName() != null) && (!"".equalsIgnoreCase(segment.getSegmentName()))) {
                currentSegment.setSegmentName(segment.getSegmentName());
            }
            if ((segment.getProductGroup() != null) && (!"".equalsIgnoreCase(segment.getProductGroup()))) {
                currentSegment.setProductGroup(segment.getProductGroup());
            }
            if ((segment.getOrderLevel() != 0) && segment.getOrderLevel() != currentSegment.getOrderLevel()) {
                currentSegment.setOrderLevel(segment.getOrderLevel());
            }
            if (segment.getSubCATID() != currentSegment.getSubCATID()) {
                currentSegment.setSubCATID(segment.getSubCATID());
            }
            if (segment.isSkipCalendar() != currentSegment.isSkipCalendar()) {
                currentSegment.setSkipCalendar(segment.isSkipCalendar());
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
