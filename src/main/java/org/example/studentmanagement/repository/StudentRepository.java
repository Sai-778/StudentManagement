package org.example.studentmanagement.repository;

import org.example.studentmanagement.enity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student,Long> {
    List<Student> findByFirstName(String firstName);

    List<Student> findByLastName(String lastName);

    Optional<Student> findByEmail(String email);

    List<Student> findByDepartment(String department);
}
