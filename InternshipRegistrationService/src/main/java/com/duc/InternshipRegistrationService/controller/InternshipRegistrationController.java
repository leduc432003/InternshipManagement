package com.duc.InternshipRegistrationService.controller;

import com.duc.InternshipRegistrationService.model.InternshipRegistration;
import com.duc.InternshipRegistrationService.service.InternshipRegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/internship-registration")
public class InternshipRegistrationController {
    private final InternshipRegistrationService internshipRegistrationService;

    @PostMapping
    public ResponseEntity<InternshipRegistration> createInternshipRequest(
            @RequestParam Long studentId,
            @RequestParam String internshipPosition,
            @RequestParam String company) {
        InternshipRegistration request = internshipRegistrationService.createInternshipRequest(studentId, internshipPosition, company);
        return new ResponseEntity<>(request, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<InternshipRegistration> getInternshipRequestById(@PathVariable Long id) throws Exception {
        InternshipRegistration request = internshipRegistrationService.getInternshipRequestById(id);
        return new ResponseEntity<>(request, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<InternshipRegistration> updateInternshipRequest(
            @PathVariable Long id,
            @RequestBody InternshipRegistration updatedRequest) {
        InternshipRegistration request = internshipRegistrationService.updateInternshipRequest(id, updatedRequest);
        return new ResponseEntity<>(request, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInternshipRequest(@PathVariable Long id) {
        internshipRegistrationService.deleteInternshipRequest(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/{id}/approve")
    public ResponseEntity<InternshipRegistration> approveInternshipRequest(
            @PathVariable Long id,
            @RequestParam Long teacherId,
            @RequestParam String comments) {
        InternshipRegistration request = internshipRegistrationService.approveInternshipRequest(id, teacherId, comments);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/{id}/reject")
    public ResponseEntity<InternshipRegistration> rejectInternshipRequest(
            @PathVariable Long id,
            @RequestParam Long teacherId,
            @RequestParam String comments) {
        InternshipRegistration request = internshipRegistrationService.rejectInternshipRequest(id, teacherId, comments);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<InternshipRegistration>> listInternshipRequestsByStudent(@PathVariable Long studentId) {
        List<InternshipRegistration> requests = internshipRegistrationService.listInternshipRequestsByStudent(studentId);
        return new ResponseEntity<>(requests, HttpStatus.OK);
    }
}
