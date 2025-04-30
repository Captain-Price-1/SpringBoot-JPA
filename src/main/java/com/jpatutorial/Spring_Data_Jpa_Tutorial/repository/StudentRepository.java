package com.jpatutorial.Spring_Data_Jpa_Tutorial.repository;

import com.jpatutorial.Spring_Data_Jpa_Tutorial.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
}
