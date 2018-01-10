package com.jcsastre.picosurveyrestapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
public class PicoSurveyRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PicoSurveyRestApiApplication.class, args);
	}
}
