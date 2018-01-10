package com.jcsastre.picosurveyrestapi.service;

import com.jcsastre.picosurveyrestapi.domain.Survey;

import java.util.List;

public interface SurveyService {

    List<Survey> findAll();

    List<Survey> findBySubjectName(String subjectName);
}
