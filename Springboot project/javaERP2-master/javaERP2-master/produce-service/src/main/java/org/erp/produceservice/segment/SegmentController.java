package org.erp.produceservice.segment;

import org.springframework.beans.factory.annotation.Autowired;
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

    public SegmentController(SegmentService segmentService) {
        this.segmentService = segmentService;
    }

    @GetMapping("/publish")
    public ResponseEntity<String> sendMessage(@RequestParam("message") String message) {
        segmentService.sendMessage(message);
        return ResponseEntity.ok("Message sent to RabbitMQ ...");
    }

    @GetMapping
    public ResponseEntity<List<Segment>> getAllSegment() {
        return new ResponseEntity<List<Segment>>(segmentService.allSegment(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Segment> getSingleSegment(@PathVariable UUID id) {
        return new ResponseEntity<Segment>(segmentService.singleSegment(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Segment> createSegment(@RequestBody Segment Segment) {
        return new ResponseEntity<Segment>(segmentService.createSegment(Segment), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Segment> updateSegment(@PathVariable UUID id, @RequestBody Segment Segment) {
        return new ResponseEntity<Segment>(segmentService.updateSegment(id, Segment), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteClassPrice(@PathVariable UUID id) {
        segmentService.deleteSegment(id);
        return ResponseEntity.ok().build();
    }

}
