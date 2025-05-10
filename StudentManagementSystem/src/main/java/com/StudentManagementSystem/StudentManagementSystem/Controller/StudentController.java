package com.StudentManagementSystem.StudentManagementSystem.Controller;

import com.StudentManagementSystem.StudentManagementSystem.Repository.StudentRepository;
import com.StudentManagementSystem.StudentManagementSystem.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/students")
@CrossOrigin(origins = "*") // Allow frontend to connect
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping
    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student){
        return studentRepository.save(student);
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student studentDetail){ // this the new student detail send for front-end
        Student student = studentRepository.findById(id).  // Read an old student from database
                orElseThrow(() -> new RuntimeException("Student not found!"));
        student.setName(studentDetail.getName());
        student.setEmail(studentDetail.getEmail());
        student.setDob(studentDetail.getDob());

        return studentRepository.save(student); // Save new details
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id){
        studentRepository.deleteById(id);
    }
}
