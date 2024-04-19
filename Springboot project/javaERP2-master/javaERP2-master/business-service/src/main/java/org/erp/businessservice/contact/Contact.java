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

    @Column(name = "nameStr", nullable = false, length = 256)
    private String nameStr;

    @Column(name = "email", length = 128)
    private String email;

    @Column(name = "handPhone", length = 50)
    private String handPhone;

    @Column(name = "Title", length = 256)
    private String title;
}