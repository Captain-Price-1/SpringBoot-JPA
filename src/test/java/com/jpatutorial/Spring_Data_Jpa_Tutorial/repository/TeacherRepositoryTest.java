package com.jpatutorial.Spring_Data_Jpa_Tutorial.repository;

import com.jpatutorial.Spring_Data_Jpa_Tutorial.entity.Course;
import com.jpatutorial.Spring_Data_Jpa_Tutorial.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {
    @Autowired
    private TeacherRepository teacherRepository;
    @Test
    public void saveTeacher(){
        Course courseDBA = Course.builder()
                .title("DBA")
                .credit(5)
                .build();
        Course courseJava = Course.builder()
                .title("java")
                .credit(5)
                .build();
        Course courseC = Course.builder()
                .title("c++")
                .credit(8)
                .build();
        Teacher teacher = Teacher.builder()
                .firstName("Mohammad")
                .lastName("Khan")
//                .courses(List.of(courseDBA,courseC,courseJava))
                .build();
        teacherRepository.save(teacher);
    }
}