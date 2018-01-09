package com.jcsastre.picosurveyrestapi.dto;

import com.jcsastre.picosurveyrestapi.domain.Subject;
import lombok.Value;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.function.Function;

@Value
public class ResponseGetSubjectsDto {

    private Integer status;
    private Data data;

    @Value
    public static class Data {

        private List<Subject> subjects;
    }

    public static Function<List<Subject>, ResponseGetSubjectsDto> buildDto =
        subjects ->
            new ResponseGetSubjectsDto(
                HttpStatus.OK.value(),
                new Data(subjects)
            );
}
