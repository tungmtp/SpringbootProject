package org.erp.businessservice.partner;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Partner {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "nameStr", nullable = false, columnDefinition = "nvarchar(250)")
    private String nameStr;

    @Column(name = "partnerType", nullable = false)
    private short partnerType;

    @Column(name = "detail", columnDefinition = "TEXT")
    private String detail;

    @Column(name = "address", columnDefinition = "nvarchar(250)")
    private String address;

    @Column(name = "VATid",columnDefinition = "nvarchar(250)")
    private String VATid;

    @Column(name = "warehouseAddress", columnDefinition = "nvarchar(250)")
    private String warehouseAddress;
}