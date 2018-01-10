package com.jcsastre.picosurveyrestapi.repository;

import com.jcsastre.picosurveyrestapi.domain.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
}
