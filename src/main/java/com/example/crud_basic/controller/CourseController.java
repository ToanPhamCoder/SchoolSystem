package com.example.crud_basic.controller;

import com.example.crud_basic.entity.Course;
import com.example.crud_basic.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/course")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @PostMapping("")
    public ResponseEntity<Course> createOpenCourse(@RequestBody Course course) {
        Course createdCourse = courseService.createCourse(course);
        return new ResponseEntity<>(createdCourse, HttpStatus.CREATED);
    }

    @GetMapping("")
    public List<Course> getCurrentOpenCourses() {
        return courseService.getCourse();
    }
}
