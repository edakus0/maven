package com.eda.backend.entitiy;

import lombok.Data;

import javax.persistence.*;

@Entity //Sınıfın bir varlık olduğunu ve bir veritabanı tablosuna eşlendiğini belirtir, JPA olduğunu belirtir
@Data //Sql söz dizimine gerek kalmadan veri alabilmemizi sağlar
@Table(name="employee") //Varlığın eşlendiği tablo adını belirtir
public class Employee {
    @Id //Özelliğin tablodaki id olduğunu belirtir, birincil anahtar olduğunu belirtir
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Birincil anahtarın otomatik olarak üretileceğini belirtir
    private Long id;
    @Column(name = "employee_name") //Sütunu belirtir
    private String employeeName;
    @Column(name = "employee_lastname")
    private String employeeLastname;
    @Column(name = "employee_email")
    private String employeeEmail;
    @Column(name = "employee_phone")
    private String employeePhone;
    @Column(name = "employee_department")
    private String employeeDepartment;


}
