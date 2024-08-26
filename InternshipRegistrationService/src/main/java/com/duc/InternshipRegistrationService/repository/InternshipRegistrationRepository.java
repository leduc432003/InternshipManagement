package com.duc.InternshipRegistrationService.repository;

import com.duc.InternshipRegistrationService.model.InternshipRegistration;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InternshipRegistrationRepository extends JpaRepository<InternshipRegistration, Long> {
    List<InternshipRegistration> findByStudentId(Long studentId);
}
