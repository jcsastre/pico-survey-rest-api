package com.jcsastre.picosurveyrestapi.service;

import com.jcsastre.picosurveyrestapi.domain.Subject;
import com.jcsastre.picosurveyrestapi.domain.Survey;
import com.jcsastre.picosurveyrestapi.repository.SurveyRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SurveyServiceImpl implements SurveyService {

    private final SurveyRepository surveyRepository;

    private final SubjectService subjectService;

    public SurveyServiceImpl(
        SurveyRepository surveyRepository,
        SubjectService subjectService
    ) {
        this.surveyRepository = surveyRepository;
        this.subjectService = subjectService;
    }

    @Override
    public List<Survey> findAll() {

        return
            surveyRepository.findAll();
    }

    @Override
    public List<Survey> findBySubjectName(String subjectName) {

        List<Survey> surveys = new ArrayList<>();

        final Optional<Subject> optionalSubject = subjectService.findByName(subjectName);

        if (optionalSubject.isPresent()) {

            final Subject subject = optionalSubject.get();

            return
                surveyRepository.findBySubject(subject);
        }

        return surveys;
    }
}
