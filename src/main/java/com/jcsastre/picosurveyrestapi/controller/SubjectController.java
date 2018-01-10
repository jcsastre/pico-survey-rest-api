package com.jcsastre.picosurveyrestapi.controller;

import com.jcsastre.picosurveyrestapi.domain.Subject;
import com.jcsastre.picosurveyrestapi.dto.ResponseGetSubjectsDto;
import com.jcsastre.picosurveyrestapi.service.SubjectService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/subjects")
public class SubjectController {

    private final SubjectService subjectService;

    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @GetMapping(headers="Accept=application/json")
    public ResponseEntity<ResponseGetSubjectsDto> findAll() {

        List<Subject> allSubjects = subjectService.findAll();

        ResponseGetSubjectsDto responseDto = ResponseGetSubjectsDto.buildDto.apply(allSubjects);

        return ResponseEntity.ok(responseDto);
    }
}
