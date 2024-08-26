package com.duc.InternshipRegistrationService.service.impl;

import com.duc.InternshipRegistrationService.model.InternshipRegistration;
import com.duc.InternshipRegistrationService.model.Status;
import com.duc.InternshipRegistrationService.model.StudentDto;
import com.duc.InternshipRegistrationService.repository.InternshipRegistrationRepository;
import com.duc.InternshipRegistrationService.service.InternshipRegistrationService;
import com.duc.InternshipRegistrationService.service.StudentService;
import exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class InternshipRegistrationServiceImpl implements InternshipRegistrationService {
    private final InternshipRegistrationRepository internshipRegistrationRepository;
    private final StudentService studentService;

    @Override
    public InternshipRegistration createInternshipRequest(Long studentId, String internshipPosition, String company) {
        StudentDto student = studentService.getStudentById(studentId);
        if(student != null) {
            InternshipRegistration request = new InternshipRegistration();
            request.setStudentId(studentId);
            request.setInternshipPosition(internshipPosition);
            request.setCompany(company);
            request.setRequestDate(LocalDateTime.now());
            request.setStatus(Status.PENDING);
            return internshipRegistrationRepository.save(request);
        }
        throw new ResourceNotFoundException("Student with ID " + studentId + " not found");
    }

    @Override
    public InternshipRegistration getInternshipRequestById(Long requestId) throws Exception {
        return internshipRegistrationRepository.findById(requestId).orElseThrow(() -> new Exception("InternshipRequest not found"));
    }

    @Override
    public InternshipRegistration updateInternshipRequest(Long requestId, InternshipRegistration updatedRequest) {
        return internshipRegistrationRepository.findById(requestId)
                .map(request -> {
                    request.setInternshipPosition(updatedRequest.getInternshipPosition());
                    request.setCompany(updatedRequest.getCompany());
                    request.setComments(updatedRequest.getComments());
                    return internshipRegistrationRepository.save(request);
                })
                .orElseThrow(() -> new RuntimeException("InternshipRequest not found"));
    }

    @Override
    public void deleteInternshipRequest(Long requestId) {
        internshipRegistrationRepository.deleteById(requestId);
    }

    @Override
    public InternshipRegistration approveInternshipRequest(Long requestId, Long teacherId, String comments) {
        return internshipRegistrationRepository.findById(requestId)
                .map(request -> {
                    request.setStatus(Status.APPROVED);
                    request.setComments(comments);
                    // Optionally handle teacherId and other logic
                    return internshipRegistrationRepository.save(request);
                })
                .orElseThrow(() -> new RuntimeException("InternshipRequest not found"));
    }

    @Override
    public InternshipRegistration rejectInternshipRequest(Long requestId, Long teacherId, String comments) {
        return internshipRegistrationRepository.findById(requestId)
                .map(request -> {
                    request.setStatus(Status.REJECTED);
                    request.setComments(comments);
                    // Optionally handle teacherId and other logic
                    return internshipRegistrationRepository.save(request);
                })
                .orElseThrow(() -> new RuntimeException("InternshipRequest not found"));
    }

    @Override
    public List<InternshipRegistration> listInternshipRequestsByStudent(Long studentId) {
        return internshipRegistrationRepository.findByStudentId(studentId);
    }
}
