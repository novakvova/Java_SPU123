package org.example.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "users") // Specify the table name for the entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "firstName", length = 100, nullable = false)
    private String firstName;

    @Column(name = "lastName", length = 100, nullable = false)
    private String lastName;

    @Column(name = "phone", length = 20, nullable = false)
    private String phone;
    @Column(name = "password", nullable = false)
    private String password;
}

