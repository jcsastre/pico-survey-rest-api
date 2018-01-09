package com.jcsastre.picosurveyrestapi.service;

import com.jcsastre.picosurveyrestapi.domain.Subject;
import com.jcsastre.picosurveyrestapi.repository.SubjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {

    private final SubjectRepository subjectRepository;

    public SubjectServiceImpl(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    @Override
    public List<Subject> findAll() {

        return subjectRepository.findAll();
    }
}
