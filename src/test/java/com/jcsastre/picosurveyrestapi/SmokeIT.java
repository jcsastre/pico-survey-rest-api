package com.jcsastre.picosurveyrestapi;

import com.jcsastre.picosurveyrestapi.domain.Subject;
import com.jcsastre.picosurveyrestapi.domain.Survey;
import com.jcsastre.picosurveyrestapi.domain.Target;
import com.jcsastre.picosurveyrestapi.dto.ResponseGetSubjectsDto;
import com.jcsastre.picosurveyrestapi.dto.ResponseGetSurveysDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.IsNull.notNullValue;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SmokeIT {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void testGetSubjects() {

        ResponseEntity<ResponseGetSubjectsDto> response =
            this.testRestTemplate.getForEntity("/subjects", ResponseGetSubjectsDto.class);

        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
        assertThat(response.getBody().getData(), notNullValue());
        assertThat(response.getBody().getData().getSubjects(), notNullValue());
        List<Subject> subjects = response.getBody().getData().getSubjects();
        assertThat(subjects, hasSize(3));
        assertThat(subjects.get(0).getId(), notNullValue());
        assertThat(subjects.get(0).getName(), notNullValue());
        assertThat(subjects.get(1).getId(), notNullValue());
        assertThat(subjects.get(1).getName(), notNullValue());
        assertThat(subjects.get(2).getId(), notNullValue());
        assertThat(subjects.get(2).getName(), notNullValue());
    }

    @Test
    public void testGetSurveysWithoutSpecifyingASubject() {

        ResponseEntity<ResponseGetSurveysDto> response =
            this.testRestTemplate.getForEntity("/surveys", ResponseGetSurveysDto.class);

        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
        assertThat(response.getBody().getData(), notNullValue());
        assertThat(response.getBody().getData().getSurveys(), notNullValue());
        final List<Survey> surveys = response.getBody().getData().getSurveys();
        assertThat(surveys, hasSize(6));
        assertThat(surveys.get(0).getId(), equalTo(1L));
        assertThat(surveys.get(0).getSubject().getName(), equalTo("health"));
        assertThat(surveys.get(0).getTarget().getGender(), equalTo(Target.Gender.M));
        assertThat(surveys.get(2).getId(), equalTo(3L));
        assertThat(surveys.get(2).getSubject().getName(), equalTo("technology"));
        assertThat(surveys.get(2).getTarget().getAgeRangeLeft(), equalTo(15));
        assertThat(surveys.get(5).getId(), equalTo(6L));
        assertThat(surveys.get(5).getSubject().getName(), equalTo("climate"));
        assertThat(surveys.get(5).getTarget().getAgeRangeRight(), equalTo(40));
    }

    @Test
    public void testGetSurveysSpecifyingASubjectThatHaveSurveys() {

        ResponseEntity<ResponseGetSurveysDto> response =
            this.testRestTemplate.getForEntity("/surveys?subjectName=technology", ResponseGetSurveysDto.class);

        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
        assertThat(response.getBody().getData(), notNullValue());
        assertThat(response.getBody().getData().getSurveys(), notNullValue());
        final List<Survey> surveys = response.getBody().getData().getSurveys();
        assertThat(surveys, hasSize(2));
        assertThat(surveys.get(0).getId(), equalTo(3L));
        assertThat(surveys.get(0).getSubject().getName(), equalTo("technology"));
        assertThat(surveys.get(0).getTarget().getGender(), equalTo(Target.Gender.M));
        assertThat(surveys.get(1).getId(), equalTo(4L));
        assertThat(surveys.get(1).getSubject().getName(), equalTo("technology"));
        assertThat(surveys.get(1).getTarget().getAgeRangeLeft(), equalTo(15));
    }

    @Test
    public void testGetSurveysSpecifyingASubjectThatDoesNotHaveSurveys() {

        ResponseEntity<ResponseGetSurveysDto> response =
            this.testRestTemplate.getForEntity("/surveys?subjectName=abcde", ResponseGetSurveysDto.class);

        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
        assertThat(response.getBody().getData(), notNullValue());
        assertThat(response.getBody().getData().getSurveys(), notNullValue());
        final List<Survey> surveys = response.getBody().getData().getSurveys();
        assertThat(surveys, hasSize(0));
    }
}
