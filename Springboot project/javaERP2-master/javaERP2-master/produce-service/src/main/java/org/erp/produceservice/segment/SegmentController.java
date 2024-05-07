package org.erp.produceservice.segment;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/produce-service/segment")
public class SegmentController {
    @Autowired
    private SegmentService segmentService;
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping
    public ResponseEntity<List<Segment>> getAllSegment(@RequestHeader("UserName") String userName) {
        System.out.println("UserName: " + userName);
        return new ResponseEntity<List<Segment>>(segmentService.allSegment(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Segment> getSingleSegment(@PathVariable UUID id) {
        return new ResponseEntity<Segment>(segmentService.singleSegment(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Segment> createSegment(@RequestBody Segment Segment, @RequestHeader("UserName") String userName) {
        Segment createdProduct = segmentService.createSegment(Segment);
        HttpHeaders headers = new HttpHeaders();
        headers.add("RequestType", "ADD_SEGMENT");
        headers.add("UserName", userName);
        ResponseEntity<Segment> response = ResponseEntity.status(HttpStatus.CREATED)
                .headers(headers)
                .body(createdProduct);
        System.out.println("UserName: " + userName);
        // Gửi message đến RabbitMQ
        rabbitTemplate.convertAndSend("javaguides_exchange", "javaguides_routing_key", response);

        return response;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Segment> updateSegment(@PathVariable UUID id, @RequestBody Segment Segment, @RequestHeader("UserName") String userName) {
//        return new ResponseEntity<Segment>(segmentService.updateSegment(id, Segment), HttpStatus.OK);
        Segment updatedProduct = segmentService.updateSegment(id, Segment);
        HttpHeaders headers = new HttpHeaders();
        headers.add("RequestType", "UPDATE_SEGMENT");
        headers.add("UserName", userName);
        ResponseEntity<Segment> response = ResponseEntity.status(HttpStatus.OK)
                .headers(headers)
                .body(updatedProduct);

        // Gửi message đến RabbitMQ
        rabbitTemplate.convertAndSend("javaguides_exchange", "javaguides_routing_key", response);
        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteClassPrice(@PathVariable UUID id, @RequestHeader("UserName") String userName) {
//        segmentService.deleteSegment(id);
//        return ResponseEntity.ok().build();
        UUID deletedProduct = segmentService.deleteSegment(id);
        HttpHeaders headers = new HttpHeaders();
        headers.add("RequestType", "DELETE_SEGMENT");
        headers.add("UserName", userName);
        ResponseEntity<UUID> response = ResponseEntity.status(HttpStatus.OK)
                .headers(headers)
                .body(deletedProduct);

        // Gửi message đến RabbitMQ
        rabbitTemplate.convertAndSend("javaguides_exchange", "javaguides_routing_key", response);
        return response;
    }
}
