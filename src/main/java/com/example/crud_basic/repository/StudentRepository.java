package com.example.crud_basic.repository;


import com.example.crud_basic.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
    // public Student getAll(){}
    // Các phương thức CRUD sẽ được thêm tự động bởi Spring Data JPA
}