package com.jcsastre.picosurveyrestapi.repository;

import com.jcsastre.picosurveyrestapi.domain.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SubjectRepository extends JpaRepository<Subject, Long> {

    Optional<Subject> findByName(String name);
}
