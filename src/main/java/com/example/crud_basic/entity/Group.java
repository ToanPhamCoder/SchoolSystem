package com.example.crud_basic.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Controller;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="`group`")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="group_id")
    private Long id;

    private String groupName;
    @PrePersist
    public void prePersist() {
        if (groupName == null) {
            // Replace this with your logic to generate the groupId
            // For simplicity, assuming the id is not null (not recommended for production)
            groupName = "A" + id;
        }
    }
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @ManyToMany(cascade = CascadeType.ALL
    )
    @JoinTable(name = "group_student",
            joinColumns = @JoinColumn(name = "group_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id"))

    private List<Student> students;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "registered_students")
    private int registeredStudents;
    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", groupName='" + groupName + '\'' +
                ", course=" + course +
                // Omitting 'students' from the toString representation
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", registeredStudents=" + registeredStudents +
                '}';
    }
}
