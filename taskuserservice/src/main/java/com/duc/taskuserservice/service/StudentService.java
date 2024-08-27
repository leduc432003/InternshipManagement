package com.duc.taskuserservice.service;

import com.duc.taskuserservice.model.StudentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "STUDENT-SERVICE", url = "http://localhost:5001")
public interface StudentService {
    @PostMapping("/api/students")
    public ResponseEntity<StudentDto> createStudent(@RequestBody StudentDto student);
}
