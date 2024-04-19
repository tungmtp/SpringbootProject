package org.erp.businessservice.contact;

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
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "partnersID", nullable = false)
    private UUID partnersID;

    @Column(name = "nameStr", nullable = false, columnDefinition = "nvarchar(250)")
    private String nameStr;

    @Column(name = "email", columnDefinition = "nvarchar(250)")
    private String email;

    @Column(name = "handPhone", columnDefinition = "nvarchar(50)")
    private String handPhone;

    @Column(name = "Title", columnDefinition = "nvarchar(256)")
    private String title;
}