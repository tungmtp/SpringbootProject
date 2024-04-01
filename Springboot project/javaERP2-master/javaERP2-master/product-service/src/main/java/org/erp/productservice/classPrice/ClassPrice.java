package org.erp.productservice.classPrice;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ClassPrice {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID Id;
    @Column(name = "classId")
    private UUID classId;
    @Column(name = "dateEffected", columnDefinition = "date")
    private Date DateEffected;
    @Column(name = "price", columnDefinition = "float")
    private float price;
    @Column(name = "defaultMeas")
    private UUID defaultMeas;



}

