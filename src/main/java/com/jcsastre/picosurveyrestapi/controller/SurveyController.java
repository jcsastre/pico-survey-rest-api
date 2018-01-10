package com.jcsastre.picosurveyrestapi.controller;

import com.jcsastre.picosurveyrestapi.domain.Survey;
import com.jcsastre.picosurveyrestapi.dto.ResponseGetSurveysDto;
import com.jcsastre.picosurveyrestapi.service.SurveyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/surveys")
public class SurveyController {

    private final SurveyService surveyService;

    public SurveyController(SurveyService surveyService) {
        this.surveyService = surveyService;
    }

    @GetMapping(headers="Accept=application/json")
    public ResponseEntity<ResponseGetSurveysDto> findBySubjectName(
        @RequestParam(value = "subjectName", required = false) String subjectName
    ) {

        final List<Survey> surveys;

        if (subjectName !=null) {
            surveys = surveyService.findBySubjectName(subjectName);
        } else {
            surveys = surveyService.findAll();
        }

        ResponseGetSurveysDto responseDto = ResponseGetSurveysDto.buildDto.apply(surveys);

        return ResponseEntity.ok(responseDto);
    }
}
