package com.vassouras.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private int registration;

    @Column(nullable = false)
    private String name;

    private char email;

    private Date birthDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "phone_id")
    private Phone phone;
}
