package com.jpatutorial.Spring_Data_Jpa_Tutorial.repository;

import com.jpatutorial.Spring_Data_Jpa_Tutorial.entity.Course;
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
}