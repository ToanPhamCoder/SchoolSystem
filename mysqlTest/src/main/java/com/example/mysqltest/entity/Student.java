package com.example.mysqltest.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "students")
@AllArgsConstructor
@Getter
@NoArgsConstructor
@Setter
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    private String email;
//    @ManyToOne
//    @JoinColumn(name = "course_id")
//    private Course course;
    // Constructors, getters, and setters
}
