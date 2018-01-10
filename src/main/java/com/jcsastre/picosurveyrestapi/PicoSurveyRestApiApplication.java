package com.jcsastre.picosurveyrestapi;

import com.jcsastre.picosurveyrestapi.domain.Subject;
import com.jcsastre.picosurveyrestapi.domain.Survey;
import com.jcsastre.picosurveyrestapi.domain.Target;
import com.jcsastre.picosurveyrestapi.repository.SubjectRepository;
import com.jcsastre.picosurveyrestapi.repository.SurveyRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class PicoSurveyRestApiApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext ctxt = SpringApplication.run(PicoSurveyRestApiApplication.class, args);

//		SubjectRepository subjectRepository = ctxt.getBean(SubjectRepository.class);
//		Subject subject = subjectRepository.findOne(1L);
//
//		SurveyRepository surveyRepository = ctxt.getBean(SurveyRepository.class);
//		surveyRepository.save(new Survey(subject, new Target(Target.Gender.F, 20, 50)));
//		surveyRepository.save(new Survey(subject, new Target(Target.Gender.M, 22, 50)));
	}
}
