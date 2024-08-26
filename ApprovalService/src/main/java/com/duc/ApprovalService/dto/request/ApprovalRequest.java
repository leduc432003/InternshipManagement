package com.duc.ApprovalService.dto.request;

import com.duc.ApprovalService.model.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ApprovalRequest {
    private Long requestId;
    private Long teacherId;
    private String feedback;
}
