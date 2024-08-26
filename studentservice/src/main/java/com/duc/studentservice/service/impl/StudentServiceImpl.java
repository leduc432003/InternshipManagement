package com.duc.studentservice.service.impl;

import com.duc.studentservice.model.Student;
import com.duc.studentservice.repository.StudentRepository;
import com.duc.studentservice.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    @Override
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student updateStudent(Long id, Student student) {
        Student updateStudent = studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
        updateStudent.setName(student.getName());
        updateStudent.setEmail(student.getEmail());
        updateStudent.setPhone(student.getPhone());
        updateStudent.setMajor(student.getMajor());
        updateStudent.setDiaChi(student.getDiaChi());
        return studentRepository.save(updateStudent);
    }
}
