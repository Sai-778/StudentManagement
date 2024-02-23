package org.example.studentmanagement.repository;

import org.example.studentmanagement.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    List<Student> findByFirstName(String firstName);

    List<Student> findByLastName(String lastName);

    Optional<Student> findByEmail(String email);

    List<Student> findByDepartment(String department);

    Student findByEmailAndFirstName(String email,String firstName);

   @Query(value = "select * from students  where first_Name=?1 ",nativeQuery = true)
   Student getStudentDeatils(String firstName);


   @Modifying
  @Query(value="delete  from students where email=?1",nativeQuery = true)
     int deleteStudentByEmail(String email);


}
