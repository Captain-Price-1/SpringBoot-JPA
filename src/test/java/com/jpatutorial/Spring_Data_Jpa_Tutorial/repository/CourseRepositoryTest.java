package com.jpatutorial.Spring_Data_Jpa_Tutorial.repository;

import com.jpatutorial.Spring_Data_Jpa_Tutorial.entity.Course;
import com.jpatutorial.Spring_Data_Jpa_Tutorial.entity.Student;
import com.jpatutorial.Spring_Data_Jpa_Tutorial.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CourseRepositoryTest {
    @Autowired
    private CourseRepository courseRepository;
    @Test
    public void printCourses(){
        List<Course> course = courseRepository.findAll();
        System.out.println("course = " + course);
    }

    @Test
    public void saveCourseWithTeacher(){
        Teacher teacher = Teacher.builder()
                .firstName("Nawaz")
                .lastName("Parwez")
                .build();
        Course course = Course.builder()
                .title("python")
                .credit(6)
                .teacher(teacher)
                .build();
        courseRepository.save(course);
    }
    @Test
    public void saveCourseWithStudentAndTeacher(){
        Teacher teacher = Teacher.builder()
                .firstName("Lizzy")
                .lastName("Morgan")
                .build();

        Student student = Student.builder()
                .firstName("Nabeel")
                .lastName("Quraysh")
                .emailId("nq@gmail.com")
                .build();

        Course course = Course.builder()
                .title("AI")
                .credit(12)
                .teacher(teacher)
                .build();

        course.addStudents(student);
        courseRepository.save(course);
    }

}