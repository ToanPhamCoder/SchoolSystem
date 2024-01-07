package com.example.crud_basic.service;

import com.example.crud_basic.entity.Course;
import com.example.crud_basic.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;
    public Course createCourse(Course course){
        return courseRepository.save(course);
    }

    public List<Course> getCourse(){
        return courseRepository.findAll();
    }

    public Optional<Course> getCourseById(Long id){
        return courseRepository.findById(id);
    }
}
