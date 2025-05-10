package com.StudentManagementSystem.StudentManagementSystem.Repository;

import com.StudentManagementSystem.StudentManagementSystem.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
