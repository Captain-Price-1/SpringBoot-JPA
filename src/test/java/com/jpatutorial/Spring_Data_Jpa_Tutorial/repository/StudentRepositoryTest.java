package com.jpatutorial.Spring_Data_Jpa_Tutorial.repository;

import com.jpatutorial.Spring_Data_Jpa_Tutorial.entity.Guardian;
import com.jpatutorial.Spring_Data_Jpa_Tutorial.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;
    @Test
    public void saveStudent(){
        Student student = Student.builder()
                .emailId("parvez@gmail.com")
                .firstName("Parvez")
                .lastName("Ahmad")
//                .guardianName("ABG")
//                .guardianEmail("aptvns1@gmail.com")
//                .guardianMobile("9335369353")
                .build();
        studentRepository.save(student);
    }
    @Test
    public void saveStudentWithGuardian(){
        Guardian guardian = Guardian.builder()
                .email("parvez@gmail.com")
                .name("Parvez")
                .mobile("123453")
                .build();
        Student student = Student.builder()
                .firstName("Shivam")
                .emailId("shivam@gmail.com")
                .lastName("Kumar")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }
    @Test
    public void printAllStudent(){
        List<Student> studentList = studentRepository.findAll();
        System.out.println("student list = " + studentList);
    }
}