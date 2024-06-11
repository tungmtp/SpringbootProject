package org.erp.produceservice.bom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class BomService {
    @Autowired
    private BomRepository bomRepository;

    public Bom getSingleBOM(UUID uuid) {
        return bomRepository.findById(uuid).orElseThrow(() -> new RuntimeException("Khong tim thay BOM voi ID: " + uuid.toString()));
    }

    public Bom updateBOM(UUID uuid, Bom bom) {
        Bom currBom = bomRepository.findById(uuid).orElseThrow(() -> new RuntimeException("Loi khong tim thay BOM: " + uuid.toString()));
        if (currBom != null) {
            if ((bom.getBomCode() != null) && (!"".equalsIgnoreCase(bom.getBomCode()))) {
                currBom.setBomCode(bom.getBomCode());
            }

            if (bom.getQuantity() != null) {
                currBom.setQuantity(bom.getQuantity());
            }

            if (bom.getMeasId() != null) {
                currBom.setMeasId(bom.getMeasId());
            }
            if (bom.getSegmentId() != null) {
                currBom.setSegmentId(bom.getSegmentId());
            }
            if (bom.getProductId() != null) {
                currBom.setProductId(bom.getProductId());
            }
            if (bom.getTimeOfDelay() != null) {
                currBom.setTimeOfDelay(bom.getTimeOfDelay());
            }
            return bomRepository.save(currBom);
        }
        return null;
    }

    public Bom createBOM(Bom bom) {
        return bomRepository.save(bom);
    }

    public List<Bom> getBomByProductId(UUID uuid) {
        return bomRepository.findByProductId(uuid);
    }

    public List<BomInputByBomId> getInputByBomId(UUID bomId) {
        List<Object[]> results = bomRepository.getInputOfBomId(bomId);
        return results.stream().map(result -> new BomInputByBomId(
                UUID.fromString((String) result[0]),
                UUID.fromString((String) result[1]),
                UUID.fromString((String) result[2]),
                UUID.fromString((String) result[3]),
                (Double) result[4],
                (String) result[5],
                (String) result[6]
        )).collect(Collectors.toList());
    }

    public void deleteBOMById(UUID id) {
        bomRepository.deleteById(id);
    }

}
