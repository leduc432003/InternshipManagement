package com.duc.ApprovalService.repository;

import com.duc.ApprovalService.model.Approval;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApprovalRepository extends JpaRepository<Approval, Long> {
    List<Approval> findByTeacherId(Long teacherId);
    List<Approval> findByRequestId(Long requestId);
}
