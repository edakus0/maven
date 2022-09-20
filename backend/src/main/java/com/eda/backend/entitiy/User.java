package com.eda.backend.entitiy;

import lombok.Data;

import javax.persistence.*;

@Entity //Sınıfın bir varlık olduğunu ve bir veritabanı tablosuna eşlendiğini belirtir, JPA olduğunu belirtir
@Data //Sql söz dizimine gerek kalmadan veri alabilmemizi sağlar
@Table(name="users") //Varlığın eşlendiği tablo adını belirtir
public class User {
    @Id //Özelliğin tablodaki id olduğunu belirtir, birincil anahtar olduğunu belirtir
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Birincil anahtarın otomatik olarak üretileceğini belirtir
    private Long id;
    @Column(name = "user_name") //Sütunu belirtir
    private String userName;
    @Column(name = "password")
    private String password;
}
