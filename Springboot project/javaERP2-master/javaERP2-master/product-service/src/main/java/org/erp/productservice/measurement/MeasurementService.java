package org.erp.productservice.measurement;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class MeasurementService {
    @Autowired
    private MeasurementRepository MeasurementRepository;

    public List<Measurement> allMeasurement() {
        return MeasurementRepository.findAll();
    }

    public Measurement singleMeasurement(UUID id) {
        return MeasurementRepository.findById(id).orElseThrow(() -> new RuntimeException("Không tìm thấy sản phẩm này"));
    }

    public Measurement createMeasurement(Measurement Measurement) {
        return MeasurementRepository.save(Measurement);
    }

    public Measurement updateMeasurement(UUID id, Measurement Measurement) {
        Measurement currentMeasurement = MeasurementRepository.findById(id).orElseThrow(() -> new RuntimeException("Không tìm thấy sản phẩm này"));
        if (currentMeasurement != null) {
            if ((Measurement.getMeasCatId() != currentMeasurement.getMeasCatId())) {
                currentMeasurement.setMeasCatId(Measurement.getMeasCatId());
            }
            if ((Measurement.getMeasName() != null) && (!"".equalsIgnoreCase(Measurement.getMeasName()))) {
                currentMeasurement.setMeasName(Measurement.getMeasName());
            }
            if (Measurement.isIsRoot() != currentMeasurement.isIsRoot()) {
                currentMeasurement.setIsRoot(Measurement.isIsRoot());
            }
            if (Measurement.getRateInRoot() != currentMeasurement.getRateInRoot()) {
                currentMeasurement.setRateInRoot(Measurement.getRateInRoot());
            }
            if (Measurement.getLength() != currentMeasurement.getLength()) {
                currentMeasurement.setLength(Measurement.getLength());
            }
            if (Measurement.getWidth() != currentMeasurement.getWidth()) {
                currentMeasurement.setWidth(Measurement.getWidth());
            }
            if (Measurement.getHeight() != currentMeasurement.getHeight()) {
                currentMeasurement.setHeight(Measurement.getHeight());
            }
            if (Measurement.getUPC() != currentMeasurement.getUPC()) {
                currentMeasurement.setUPC(Measurement.getUPC());
            }
            return MeasurementRepository.save(currentMeasurement);
        }
        return null;
    }

    public void deleteMeasurement(UUID id) {
        MeasurementRepository.deleteById(id);
    }
}
