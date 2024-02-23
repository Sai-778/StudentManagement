package org.example.studentmanagement.controller;

import org.example.studentmanagement.entity.Student;
import org.example.studentmanagement.repository.StudentRepository;
import org.example.studentmanagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/get")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public Optional<Student> getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    @GetMapping("/firstName/{firstName}")
    public List<Student> getStudentsByFirstName(@PathVariable String firstName) {
        return studentService.getStudentsByFirstName(firstName);
    }

    @GetMapping("/lastName/{lastName}")
    public List<Student> getStudentsByLastName(@PathVariable String lastName) {
        return studentService.getStudentsByLastName(lastName);
    }

    @GetMapping("/email/{email}")
    public Optional<Student> getStudentByEmail(@PathVariable String email) {
        return studentService.getStudentByEmail(email);
    }

    @GetMapping("/department/{department}")
    public List<Student> getStudentsByDepartment(@PathVariable String department) {
        return studentService.getStudentsByDepartment(department);
    }

    @PostMapping("/post")
    public String addStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }

    @PutMapping("/{id}")
    public void updateStudent(@PathVariable Long id, @RequestBody Student updatedStudent) {
        studentService.updateStudent(id, updatedStudent);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }



    @GetMapping("/student/details")
    public Student getStudentsByDepartment(@RequestParam String email,@RequestParam String firstName) {
        System.out.println("in controller");
        return studentService.getStudentEmailWithFirstName(email,firstName);
    }

    @GetMapping("/query/search")
    public  Student getStudentByQuery(@RequestParam String firstName){
        return studentService.getStudentDeatils(firstName);

    }


    @DeleteMapping("/query/delete")
    public ResponseEntity<String> deleteStudentByQuery(@RequestParam String email){
        Student deletedStudent= studentService.deleteStudentByEmail(email);

        if (deletedStudent != null) {
            return ResponseEntity.ok("Student with email " + email + " deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student with email " + email + " not found");
        }
    }



}