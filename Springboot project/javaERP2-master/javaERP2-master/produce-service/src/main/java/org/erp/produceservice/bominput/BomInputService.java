package org.erp.produceservice.bominput;

import org.erp.produceservice.bom.Bom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BomInputService {
    @Autowired
    private BomInputRepository bomInputRepository;

    public BomInput createBomInput(BomInput bomInput) {
        return bomInputRepository.save(bomInput);
    }

    public BomInput getSingleBomInput(UUID uuid) {
        return bomInputRepository.findById(uuid).orElseThrow(() -> new RuntimeException("Khong tim thay BomInput: " + uuid.toString()));
    }

    public List<BomInput> getBomInputByBomId(UUID uuid) {
        return bomInputRepository.findByBomId(uuid);
    }

    public BomInput updateBomInput(UUID uuid, BomInput bomInput) {
        BomInput currBomInput = getSingleBomInput(uuid);
        if (currBomInput != null) {
            if (bomInput.getQuantity() != null) {
                currBomInput.setQuantity(bomInput.getQuantity());
            }
            if (bomInput.getMeasId() != null) {
                currBomInput.setMeasId(bomInput.getMeasId());
            }
            if (bomInput.getProductId() != null) {
                currBomInput.setProductId(bomInput.getProductId());
            }

            return bomInputRepository.save(currBomInput);
        }
        return null;
    }

    public void deleteSingleBomInput(UUID uuid) {
        bomInputRepository.deleteById(uuid);
    }
}
