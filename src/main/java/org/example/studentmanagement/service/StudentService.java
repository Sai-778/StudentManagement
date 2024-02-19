package org.example.studentmanagement.service;

import org.example.studentmanagement.entity.Student;
import org.example.studentmanagement.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    public List<Student> getStudentsByFirstName(String firstName) {
        return studentRepository.findByFirstName(firstName);
    }

    public List<Student> getStudentsByLastName(String lastName) {
        return studentRepository.findByLastName(lastName);
    }

    public Optional<Student> getStudentByEmail(String email) {
        return studentRepository.findByEmail(email);
    }

    public List<Student> getStudentsByDepartment(String department) {
        return studentRepository.findByDepartment(department);
    }

    public String addStudent(Student student) {
        Optional<Student> existingStudent = studentRepository.findByEmail(student.getEmail());
        if (existingStudent.isPresent()) {
            return "student already exist";
        } else {
            studentRepository.save(student);
            return "student details saved";
        }
    }

    public void updateStudent(Long id, Student updatedStudent) {
        // Implement update logic based on your requirements
        Student existingStudent = studentRepository.findById(id).orElse(null);
        if (existingStudent != null) {
            // Update fields of existingStudent with fields from updatedStudent
            studentRepository.save(existingStudent);
        }
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);





    }

    public Student getStudentEmailWithFirstName(String email,String firstName){
        System.out.println("in service");
        System.out.println(studentRepository.findByEmailAndFirstName(email,firstName));
        return studentRepository.findByEmailAndFirstName(email,firstName);
    }


    public Student getStudentDeatils(String firstName) {
        return studentRepository.getStudentDeatils(firstName);
    }
}
