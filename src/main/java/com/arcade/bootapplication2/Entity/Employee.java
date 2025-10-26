package com.arcade.bootapplication2.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    @Column(nullable = false)
    @NotBlank(message = "This field can not be blank")
    private String firstName;


    @NotBlank(message = "This field can not be blank")
    @Column(nullable = false)
    private String lastName;


    @NotBlank(message = "This field can not be blank")
    @Column(nullable = false)
    private int age;


    @NotBlank(message = "This field can not be blank")
    @Column(nullable = false)
    private String role;


    @NotBlank(message = "This field can not be blank")
    @Column(nullable = false , unique = true)
    @Email
    private String email;


    @NotBlank(message = "This field can not be blank")
    @Column(nullable = false)
    private int salary;

}
