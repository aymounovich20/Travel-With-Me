package com.rma.travelwithme.models;

import com.rma.travelwithme.enums.UserRole;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String username;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
    private boolean groupLeader;
    private UserRole role;

    // Getters and setters

    // You can add additional constructors and methods as needed
}