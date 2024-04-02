package org.erp.produceservice.segment;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class SegmentService {
    @Autowired
    private SegmentRepository SegmentRepository;

    public List<Segment> allSegment() {
        return SegmentRepository.findAll();
    }

    public Segment singleSegment(UUID id) {
        return SegmentRepository.findById(id).orElseThrow(() -> new RuntimeException("Không tìm thấy sản phẩm này"));
    }

    public Segment createSegment(Segment Segment) {
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
            if (Segment.getOrderLevel() != currentSegment.getOrderLevel()) {
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

    public void deleteSegment(UUID id) {
        SegmentRepository.deleteById(id);
    }
}
