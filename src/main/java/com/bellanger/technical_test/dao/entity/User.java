package com.bellanger.technical_test.dao.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Usr")
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "username")
    private String username;
    @Column(name = "country")
    private String country;
    @Column(name = "birthdate")
    private Timestamp birthdate;
    @Column(name = "gender")
    private String gender;
    @Column(name = "phoneNumber")
    private String phoneNumber;

}
