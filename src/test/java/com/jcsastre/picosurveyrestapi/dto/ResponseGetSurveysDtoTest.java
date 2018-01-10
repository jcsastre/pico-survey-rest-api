package com.jcsastre.picosurveyrestapi.dto;

import com.jcsastre.picosurveyrestapi.domain.Survey;
import org.junit.Test;
import org.springframework.http.HttpStatus;

import java.util.Arrays;
import java.util.List;

import static io.github.benas.randombeans.api.EnhancedRandom.random;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

public class ResponseGetSurveysDtoTest {

    @Test
    public void shouldBuildDtoCorrectly() {

        // Given
        Survey survey1 = random(Survey.class);
        Survey survey2 = random(Survey.class);

        // When
        final ResponseGetSurveysDto dto = ResponseGetSurveysDto.buildDto.apply(Arrays.asList(survey1, survey2));

        // Then
        assertThat(dto.getStatus(), equalTo(HttpStatus.OK.value()));
        final List<Survey> surveys = dto.getData().getSurveys();
        assertThat(surveys, hasSize(2));
        assertThat(surveys.get(0), equalTo(survey1));
        assertThat(surveys.get(1), equalTo(survey2));
    }
}
