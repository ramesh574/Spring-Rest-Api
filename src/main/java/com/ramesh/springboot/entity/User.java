package com.ramesh.springboot.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Schema(
        description = "User model information"
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(
            description = "User id"
    )
    private int id;
    @Schema(
            description = "User First Name"
    )
    private String firstName;
    @Schema(
            description = "User Last Name"
    )
    private String lastName;
    @Schema(
            description = "User email Address"
    )private String email;
}
