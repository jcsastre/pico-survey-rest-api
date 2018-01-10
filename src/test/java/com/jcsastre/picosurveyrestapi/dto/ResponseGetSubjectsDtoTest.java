package com.jcsastre.picosurveyrestapi.dto;

import com.jcsastre.picosurveyrestapi.domain.Subject;
import org.junit.Test;
import org.springframework.http.HttpStatus;

import java.util.Arrays;
import java.util.List;

import static io.github.benas.randombeans.api.EnhancedRandom.random;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

public class ResponseGetSubjectsDtoTest {

    @Test
    public void shouldBuildDtoCorrectly() {

        // Given
        Subject subject1 = random(Subject.class);
        Subject subject2 = random(Subject.class);

        // When
        final ResponseGetSubjectsDto dto = ResponseGetSubjectsDto.buildDto.apply(Arrays.asList(subject1, subject2));

        // Then
        assertThat(dto.getStatus(), equalTo(HttpStatus.OK.value()));
        List<Subject> subjects = dto.getData().getSubjects();
        assertThat(subjects, hasSize(2));
        assertThat(subjects.get(0), equalTo(subject1));
        assertThat(subjects.get(1), equalTo(subject2));
    }
}
