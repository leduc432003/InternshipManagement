package com.duc.studentservice.service;

import com.duc.studentservice.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    Student createStudent(Student student);
    Student getStudentById(Long id);
    List<Student> getAllStudents();
    Student updateStudent(Long id, Student student);
    Student getStudentByEmail(String email);
}
