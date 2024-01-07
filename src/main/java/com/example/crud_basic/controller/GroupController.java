package com.example.crud_basic.controller;

import com.example.crud_basic.entity.Course;
import com.example.crud_basic.entity.Group;
import com.example.crud_basic.entity.Student;
import com.example.crud_basic.request.GroupRequest;
import com.example.crud_basic.service.CourseService;
import com.example.crud_basic.service.GroupService;
import com.example.crud_basic.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/group")
public class GroupController {
    @Autowired
    private GroupService groupService;
    @Autowired
    private CourseService courseService;
    @Autowired
    private StudentService studentService;
    @GetMapping()
    public List<Group> getGroups(){
       return groupService.getGroups();
    }
    @GetMapping("/current")
    public List<Group> getGroupsByDateRange() {
        LocalDate currentDate = LocalDate.now();
        return groupService.getGroupsByDateRange(currentDate);
    }
    @PostMapping
    public ResponseEntity<Group> createGroup(@RequestBody GroupRequest groupRequest) {
        Group newGroup= new Group();
        Course course = courseService.getCourseById(groupRequest.getCourseId())
                .orElseGet(() -> {
                    Course newCourse = new Course();
                    newCourse.setId(groupRequest.getCourseId());
                    return newCourse;
                });
        newGroup.setCourse(course);
        newGroup.setStartDate(groupRequest.getStartDate());
        newGroup.setEndDate(groupRequest.getEndDate());
        newGroup.setRegisteredStudents(0);
        Group createdGroup= groupService.createGroup(newGroup);
        return new ResponseEntity<>(createdGroup, HttpStatus.CREATED);
    }
    @PostMapping("/addStudents/{groupId}/{studentId}")
    public ResponseEntity<Group> addStudentsToGroup(
            @PathVariable Long groupId,
            @PathVariable Long studentId) {

        Optional<Group> group = groupService.getGroupById(groupId);

        if (group == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Optional<Student> student = studentService.getStudentById(studentId);
        if (student.isPresent()) {
            List<Student> currentStudents = group.get().getStudents();
            currentStudents.add(student.get());
            group.get().setStudents(currentStudents);
            group.get().setRegisteredStudents(group.get().getRegisteredStudents() + 1);

            Group updatedGroup = groupService.updateGroup(group.get());
            return new ResponseEntity<>(updatedGroup, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
    @GetMapping("student/{studentId}")
    public ResponseEntity<List<Group>> getGroupsByStudentId(@PathVariable Long studentId) {
        List<Group> groups = groupService.getGroupsByStudentId(studentId);
        return new ResponseEntity<>(groups, HttpStatus.OK);
    }
}
