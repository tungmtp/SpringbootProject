package org.erp.employeeservice.employee;

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
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID Id;

    @Column(name = "lastName", nullable = false, columnDefinition = "nvarchar(50)")
    private String lastName;

    @Column(name = "firstName", nullable = false, columnDefinition = "nvarchar(50)")
    private String firstName;

    @Column(name = "title", nullable = false, columnDefinition = "nvarchar(50)")
    private String title;

    @Column(name = "sex", nullable = false, columnDefinition = "nvarchar(50)")
    private String sex;

    @Column(name = "birthDate", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date birthDate;

    @Column(name = "address", columnDefinition = "nvarchar(80)")
    private String address;

    @Column(name = "handPhone", length = 50)
    private String handPhone;

    @Column(name = "email", nullable = false, columnDefinition = "nvarchar(60)")
    private String email;

    @Column(name = "isUser", nullable = false)
    private boolean IsUser = true;

    @Column(name = "jobDescription", columnDefinition = "ntext")
    private String jobDescription;
}