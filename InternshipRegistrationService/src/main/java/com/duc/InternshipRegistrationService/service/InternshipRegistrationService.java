package com.duc.InternshipRegistrationService.service;

import com.duc.InternshipRegistrationService.model.InternshipRegistration;

import java.util.List;


public interface InternshipRegistrationService {
    InternshipRegistration createInternshipRequest(Long studentId, String internshipPosition, String company);
    InternshipRegistration getInternshipRequestById(Long requestId) throws Exception;
    InternshipRegistration updateInternshipRequest(Long requestId, InternshipRegistration updatedRequest);
    void deleteInternshipRequest(Long requestId);
    InternshipRegistration approveInternshipRequest(Long requestId, Long teacherId, String comments);
    InternshipRegistration rejectInternshipRequest(Long requestId, Long teacherId, String comments);
    public List<InternshipRegistration> listInternshipRequestsByStudent(Long studentId);
}
