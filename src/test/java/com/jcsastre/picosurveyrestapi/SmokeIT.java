package com.jcsastre.picosurveyrestapi;

import com.jcsastre.picosurveyrestapi.domain.Subject;
import com.jcsastre.picosurveyrestapi.dto.ResponseGetSubjectsDto;
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

    // 1. Get subjects: GET /subjects
    // 2. Get survey for valid subject: GET /surveys?subject=health
    // 3. Get survey for invalid subject: GET /surveys?subject=invalid

    @Test
    public void testGetSubjects() {

        ResponseEntity<ResponseGetSubjectsDto> getSubjectsResponseEntity =
                this.testRestTemplate.getForEntity("subjects", ResponseGetSubjectsDto.class);

<<<<<<< HEAD
        assertThat(getSubjectsResponseEntity.getStatusCode(), equalTo(HttpStatus.OK));
        assertThat(getSubjectsResponseEntity.getBody().getData(), notNullValue());
        assertThat(getSubjectsResponseEntity.getBody().getData().getSubjects(), notNullValue());
        List<Subject> subjects = getSubjectsResponseEntity.getBody().getData().getSubjects();
        assertThat(subjects, hasSize(3));
        assertThat(subjects.get(0).getId(), notNullValue());
        assertThat(subjects.get(0).getName(), notNullValue());
        assertThat(subjects.get(1).getId(), notNullValue());
        assertThat(subjects.get(1).getName(), notNullValue());
        assertThat(subjects.get(2).getId(), notNullValue());
        assertThat(subjects.get(2).getName(), notNullValue());
=======
//        assertThat(getSubjectsResponseEntity.getStatusCode(), equalTo(HttpStatus.OK));
//        assertThat(getSubjectsResponseEntity.getBody().getData().getClient().getEmail(), equalTo(email));
>>>>>>> d2607b3... ResponseGetSubjectsDto implementation and test done. Next: smokeIT.
    }
}
