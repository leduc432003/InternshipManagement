package com.duc.ApprovalService.service;

import com.duc.ApprovalService.dto.request.ApprovalRequest;
import com.duc.ApprovalService.model.Approval;

import java.util.List;

public interface ApprovalService {
    Approval approveRequest(ApprovalRequest approvalRequest);
    Approval rejectRequest(ApprovalRequest approvalRequest);    Approval getApprovalById(Long approvalId);
    List<Approval> getApprovalsByTeacherId(Long teacherId);
    List<Approval> getApprovalsByRequestId(Long requestId);
}
