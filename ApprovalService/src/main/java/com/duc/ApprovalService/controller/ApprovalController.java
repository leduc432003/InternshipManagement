package com.duc.ApprovalService.controller;

import com.duc.ApprovalService.dto.request.ApprovalRequest;
import com.duc.ApprovalService.model.Approval;
import com.duc.ApprovalService.service.ApprovalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/approvals")
public class ApprovalController {
    private final ApprovalService approvalService;

    @PostMapping("/approve")
    public ResponseEntity<Approval> approveRequest(@RequestBody ApprovalRequest approvalRequest) {
        Approval approval = approvalService.approveRequest(approvalRequest);
        return new ResponseEntity<>(approval, HttpStatus.CREATED);
    }

    @PostMapping("/reject")
    public ResponseEntity<Approval> rejectRequest(@RequestBody ApprovalRequest approvalRequest) {
        Approval approval = approvalService.rejectRequest(approvalRequest);
        return new ResponseEntity<>(approval, HttpStatus.CREATED);
    }

    @GetMapping("/{approvalId}")
    public ResponseEntity<Approval> getApprovalById(@PathVariable Long approvalId) {
        Approval approval = approvalService.getApprovalById(approvalId);
        return new ResponseEntity<>(approval, HttpStatus.OK);
    }

    @GetMapping("/by-teacher/{teacherId}")
    public ResponseEntity<List<Approval>> getApprovalsByTeacherId(@PathVariable Long teacherId) {
        List<Approval> approvals = approvalService.getApprovalsByTeacherId(teacherId);
        return new ResponseEntity<>(approvals, HttpStatus.OK);
    }

    @GetMapping("/by-request/{requestId}")
    public ResponseEntity<List<Approval>> getApprovalsByRequestId(@PathVariable Long requestId) {
        List<Approval> approvals = approvalService.getApprovalsByRequestId(requestId);
        return new ResponseEntity<>(approvals, HttpStatus.OK);
    }
}
