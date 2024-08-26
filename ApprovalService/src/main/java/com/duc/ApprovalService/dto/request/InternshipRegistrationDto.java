package com.duc.ApprovalService.dto.request;

import com.duc.ApprovalService.model.Status;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class InternshipRegistrationDto {
    private Long requestId;
    private Long studentId;
    private String internshipPosition;
    private String company;
    private Status status;
    private LocalDateTime requestDate;
    private String comments;
}
