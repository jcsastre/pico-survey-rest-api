package com.jcsastre.picosurveyrestapi.service;

import com.jcsastre.picosurveyrestapi.domain.Subject;

import java.util.List;
import java.util.Optional;

public interface SubjectService {

    List<Subject> findAll();

    Optional<Subject> findByName(String name);
}
