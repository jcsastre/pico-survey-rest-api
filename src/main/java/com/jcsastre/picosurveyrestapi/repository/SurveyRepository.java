package com.jcsastre.picosurveyrestapi.repository;

import com.jcsastre.picosurveyrestapi.domain.Subject;
import com.jcsastre.picosurveyrestapi.domain.Survey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SurveyRepository extends JpaRepository<Survey, Long> {

    List<Survey> findBySubject(Subject subject);
}
