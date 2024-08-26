package com.duc.ApprovalService.service;

import com.duc.ApprovalService.dto.request.InternshipRegistrationDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "INTERNSHIP-REGISTRATION-SERVICE", url = "http://localhost:5002")
public interface InternshipRegistrationService {
    @GetMapping("/api/internship-registration/{requestId}")
    InternshipRegistrationDto getInternshipRequestById(@PathVariable Long requestId);
}
