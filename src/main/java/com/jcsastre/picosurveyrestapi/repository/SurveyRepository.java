package com.jcsastre.picosurveyrestapi.repository;

import com.jcsastre.picosurveyrestapi.domain.Survey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SurveyRepository extends JpaRepository<Survey, Long> {
}
