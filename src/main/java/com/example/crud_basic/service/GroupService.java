package com.example.crud_basic.service;

import com.example.crud_basic.entity.Course;
import com.example.crud_basic.entity.Group;
import com.example.crud_basic.entity.Student;
import com.example.crud_basic.repository.GroupRepository;
import com.example.crud_basic.request.GroupRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class GroupService {
    @Autowired
    private GroupRepository groupRepository;
    @Autowired
    private StudentService studentService;
    @Autowired
    private CourseService courseService;


    public List<Group> getGroups() {
        return groupRepository.findAll();
    }
    public Optional<Group> getGroupById(Long id) {
        return groupRepository.findById(id);
    }

    public Group createGroup(Group group) {
        // Convert GroupRequest to Group entity and save
        // Implement this logic based on your requirements
        // (e.g., using ModelMapper or manual conversion)
        return groupRepository.save(group);
    }

    public List<Group> getGroupsByDateRange(LocalDate currentDate) {
        return groupRepository.findGroupsByDateRange(currentDate, currentDate);
    }
    public Group updateGroup(Group group){
        return groupRepository.save(group);
    }
    public List<Group> getGroupsByStudentId(Long studentId) {
        return groupRepository.findByStudentsId(studentId);
    }
//
//    public Group createGroupWithStudents(Long courseId, Long studentId) {
//        Group newGroup = new Group();
//
//        Optional<Course> optionalCourse = courseService.getCourseById(courseId);
//        Course course = optionalCourse.orElseThrow(() -> new NoSuchElementException("Course not found"));
//        newGroup.setCourse(course);
//
//        Optional<Student> optionalStudent = studentService.getStudentById(studentId);
//        List<Student> students = Arrays.asList(optionalStudent.orElse(null));
//        newGroup.setStudents(students);
//        return groupRepository.save(newGroup);
//    }
}