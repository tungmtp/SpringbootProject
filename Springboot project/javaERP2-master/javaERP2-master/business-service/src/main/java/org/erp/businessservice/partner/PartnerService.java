package org.erp.businessservice.partner;

import com.fasterxml.jackson.databind.ser.std.UUIDSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PartnerService {
    @Autowired
    private PartnerRepository partnerRepository;

    public List<Partner> getAllPartners() {
        return partnerRepository.findAll();
    }

    public Partner getPartnerById(UUID id) {
        return partnerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Partner not found with id: " + id));
    }

    public Partner createPartner(Partner partner) {
        return partnerRepository.save(partner);
    }

    public Partner updatePartner(UUID id, Partner partner) {
        Partner existingPartner = partnerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Partner not found with id: " + id));

        if (partner.getNameStr() != null && !partner.getNameStr().equals(existingPartner.getNameStr())) {
            existingPartner.setNameStr(partner.getNameStr());
        }
        if (partner.getPartnerType() != existingPartner.getPartnerType()) {
            existingPartner.setPartnerType(partner.getPartnerType());
        }
        if (partner.getDetail() != null && !partner.getDetail().equals(existingPartner.getDetail())) {
            existingPartner.setDetail(partner.getDetail());
        }
        if (partner.getAddress() != null && !partner.getAddress().equals(existingPartner.getAddress())) {
            existingPartner.setAddress(partner.getAddress());
        }
        if (partner.getVATid() != null && !partner.getVATid().equals(existingPartner.getVATid())) {
            existingPartner.setVATid(partner.getVATid());
        }
        if (partner.getWarehouseAddress() != null && !partner.getWarehouseAddress().equals(existingPartner.getWarehouseAddress())) {
            existingPartner.setWarehouseAddress(partner.getWarehouseAddress());
        }

        return partnerRepository.save(existingPartner);
    }

    public void deletePartner(UUID id) {
        partnerRepository.deleteById(id);
    }

    public List<PartnerForSelect> getItemContainingQuery(String query) {
        return partnerRepository.getItemContainingQuery(query);
    }

    public List<PartnerForSelect> getItemFamiliar(UUID uuid) {
        return partnerRepository.getItemFamiliar(uuid);
    }
}