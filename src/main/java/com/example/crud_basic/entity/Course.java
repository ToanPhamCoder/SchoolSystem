package com.example.crud_basic.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="courses")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long courseId;

    @Column(name = "name")
    private String name;

    public Course(Long courseId) {
    }

    public void setId(Long courseId) {
    }

//
//    @OneToMany(mappedBy = "course")
//    private List<Student> students;

}
