package com.example.crud_basic.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "students",indexes = @Index(name = "idx_student_id", columnList = "student_id"))
public class Student {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    Long id;
    String email;
    String firstName;
    String lastName;
    int age;
    @ManyToMany(mappedBy = "students", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Group> groups;
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }
}
