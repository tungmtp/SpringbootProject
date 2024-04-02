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
    private SegmentService SegmentService;
    @GetMapping
    public ResponseEntity<List<Segment>> getAllSegment() {
        return new ResponseEntity<List<Segment>>(SegmentService.allSegment(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Segment> getSingleSegment(@PathVariable UUID id) {
        return new ResponseEntity<Segment>(SegmentService.singleSegment(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Segment> createSegment(@RequestBody Segment Segment) {
        return new ResponseEntity<Segment>(SegmentService.createSegment(Segment), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Segment> updateSegment(@PathVariable UUID id, @RequestBody Segment Segment) {
        return new ResponseEntity<Segment>(SegmentService.updateSegment(id, Segment), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteClassPrice(@PathVariable UUID id) {
        SegmentService.deleteSegment(id);
        return ResponseEntity.ok().build();
    }

}
