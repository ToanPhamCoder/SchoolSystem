package com.example.crud_basic.service;

import com.example.crud_basic.entity.Course;
import com.example.crud_basic.entity.Student;
import com.example.crud_basic.repository.CourseRepository;
import com.example.crud_basic.repository.StudentRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    public Page<Student> getAllStudents(Pageable pageable) {
        return studentRepository.findAll(pageable);
    }
    //studentRepository.findAll(); => List<Student> => id:1,email:student@gmail.com. id:2,email:student@gmail.com


    public Optional<Student> getStudentById(Long id){
        // id lúc này là từ bên kia ch
        Optional<Student> student= studentRepository.findById(id);
        System.out.println("hello"+studentRepository.findById(id));
        return studentRepository.findById(id);
    }
//    public Optional<Student> getStudentById(Long id) {
//        Optional<Student> studentOptional =studentRepository.findById(id);
//        if (studentOptional.isPresent()) {
//            Student student = studentOptional.get();
//
//            // Now, you can safely access the associated Course and its ID
//            Long courseId = student.getCourse().getId();
//            System.out.println("Course ID: " + courseId);
//
//            if (courseId != null) {
//                Optional<Course> optionalCourse = courseRepository.findById(courseId);
//
//                // Check if the Course exists in the database
//                if (optionalCourse.isPresent()) {
//                    Course course = optionalCourse.get();
//
//                    // Set the Course to the Student
//                    student.setCourse(course);
//
//                    // Save the Student
//                    return Optional.of(student);
//                } else {
//                    // Handle the case where the Course with the provided ID doesn't exist
//                    throw new EntityNotFoundException("Course with ID " + courseId + " not found");
//                }
//            } else {
//                // Handle the case where courseId is not provided
//                throw new IllegalArgumentException("courseId is required");
//            }
//        } else {
//            // Handle the case where the student with the given ID is not found
//            return Optional.empty();
//        }
//    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
//        Long courseId = student.getCourse().getId();
//
//        if (courseId != null) {
//            Optional<Course> optionalCourse = courseRepository.findById(courseId);
//
//            // Check if the Course exists in the database
//            if (optionalCourse.isPresent()) {
//                Course course = optionalCourse.get();
//
//                // Set the Course to the Student
//                student.setCourse(course);
//
//                // Save the Student
//                return studentRepository.save(student);
//            } else {
//                // Handle the case where the Course with the provided ID doesn't exist
//                throw new EntityNotFoundException("Course with ID " + courseId + " not found");
//            }
//        } else {
//            // Handle the case where courseId is not provided
//            throw new IllegalArgumentException("courseId is required");
//        }
    }

    public Student updateStudent(Long id, Student updatedStudent) {
        if (studentRepository.existsById(id)) {
            return studentRepository.save(updatedStudent);
        } else {
            throw new RuntimeException("Student not found with id: " + id);
        }
    }

    public void deleteStudent(Long id) {
        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Student not found with id: " + id);
        }    }
}
