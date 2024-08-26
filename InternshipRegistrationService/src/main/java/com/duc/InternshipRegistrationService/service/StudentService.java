package com.duc.InternshipRegistrationService.service;

import com.duc.InternshipRegistrationService.model.StudentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "STUDENT-SERVICE", url = "http://localhost:5001")
public interface StudentService {
    @GetMapping("/api/students/{id}")
    public StudentDto getStudentById(@PathVariable Long id);
}
