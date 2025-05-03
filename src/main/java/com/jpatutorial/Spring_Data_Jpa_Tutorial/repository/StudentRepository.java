package com.jpatutorial.Spring_Data_Jpa_Tutorial.repository;

import com.jpatutorial.Spring_Data_Jpa_Tutorial.entity.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
     List<Student> findByFirstName(String firstName);
     List<Student> findByFirstNameContaining(String name);
     List<Student> findByLastNameNotNull();
     List<Student> findByGuardianName(String guardianName);


     @Query("select s from Student s where s.emailId = ?1")
     Student getStudentByEmailAddress(String emailId);

     // native Query
     @Query(
             value = "select * from tbl_student s where where s.email_address = ?1",
             nativeQuery = true
     )
     Student getStudentByEmailAddressNative(String emailId);

     // native named parameter
     @Query(
             value = "Select * from tbl_student s where s.email_address = :emailId",
             nativeQuery = true
     )
     Student getStudentByEmailAddressNativeNamedParam(@Param("emailId") String emailId);


     // updating records
     @Modifying
     @Transactional
     @Query(
             value = "update tbl_student set first_name = ?1 where email_address = ?2",
             nativeQuery = true
     )
     int updateStudentNameByEmailId(String firstName, String emailId);
}
