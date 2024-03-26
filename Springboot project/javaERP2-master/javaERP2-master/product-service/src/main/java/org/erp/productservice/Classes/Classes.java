package org.erp.productservice.Classes;

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
public class Classes {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID Id;

    @Column(name = "NameStr", columnDefinition = "nvarchar(256)")
    private String NameStr;

    @Column(name = "classType", columnDefinition = "varchar(10)")
    private String classType;




}

