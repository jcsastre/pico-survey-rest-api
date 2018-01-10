package com.jcsastre.picosurveyrestapi.dto;

import com.jcsastre.picosurveyrestapi.domain.Survey;
import lombok.Value;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.function.Function;

@Value
public class ResponseGetSurveysDto {

    private Integer status;
    private Data data;

    @Value
    public static class Data {

        private List<Survey> surveys;
    }

    public static Function<List<Survey>, ResponseGetSurveysDto> buildDto =
        surveys ->
        new ResponseGetSurveysDto(
            HttpStatus.OK.value(),
            new Data(surveys)
        );
}
