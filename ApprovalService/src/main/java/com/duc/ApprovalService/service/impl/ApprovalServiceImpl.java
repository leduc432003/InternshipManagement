package com.duc.ApprovalService.service.impl;

import com.duc.ApprovalService.dto.request.ApprovalRequest;
import com.duc.ApprovalService.dto.request.InternshipRegistrationDto;
import com.duc.ApprovalService.model.Approval;
import com.duc.ApprovalService.model.Status;
import com.duc.ApprovalService.repository.ApprovalRepository;
import com.duc.ApprovalService.service.ApprovalService;
import com.duc.ApprovalService.service.InternshipRegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ApprovalServiceImpl implements ApprovalService {
    private final ApprovalRepository approvalRepository;
    private final InternshipRegistrationService internshipRegistrationService;

    @Override
    public Approval approveRequest(ApprovalRequest approvalRequest) {
        InternshipRegistrationDto internshipRegistrationDto = internshipRegistrationService.getInternshipRequestById(approvalRequest.getRequestId());
        if(internshipRegistrationDto != null) {
            Approval approval = new Approval();
            approval.setRequestId(approvalRequest.getRequestId());
            approval.setTeacherId(approvalRequest.getTeacherId());
            approval.setApprovalDate(LocalDateTime.now());
            approval.setStatus(Status.APPROVED);
            approval.setFeedback(approvalRequest.getFeedback());
            return approvalRepository.save(approval);
        }
        throw new RuntimeException("Request Id not found");
    }

    @Override
    public Approval rejectRequest(ApprovalRequest approvalRequest) {
        InternshipRegistrationDto internshipRegistrationDto = internshipRegistrationService.getInternshipRequestById(approvalRequest.getRequestId());
        if(internshipRegistrationDto != null) {
            Approval approval = new Approval();
            approval.setRequestId(approvalRequest.getRequestId());
            approval.setTeacherId(approvalRequest.getTeacherId());
            approval.setApprovalDate(LocalDateTime.now());
            approval.setStatus(Status.REJECTED);
            approval.setFeedback(approvalRequest.getFeedback());
            return approvalRepository.save(approval);
        }
        throw new RuntimeException("Request Id not found");
    }

    @Override
    public Approval getApprovalById(Long approvalId) {
        return approvalRepository.findById(approvalId).orElseThrow(() -> new RuntimeException("Approval not found"));
    }

    @Override
    public List<Approval> getApprovalsByTeacherId(Long teacherId) {
        return approvalRepository.findByTeacherId(teacherId);
    }

    @Override
    public List<Approval> getApprovalsByRequestId(Long requestId) {
        return approvalRepository.findByRequestId(requestId);
    }


}
