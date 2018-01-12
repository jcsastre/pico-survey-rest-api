Super simplistic REST API based on a surveys domain (micro, nano, pico...)

Spent time: about 2 hours 30 minutes.

## Test code

When I know well the framework/library and what to implement, I use a TDD approach. So first I implement the
tests, and then I start to code to pass these tests. When I don't know well the framework/library or what
to implement, I use an hybrid approach, but at the end I always implement unit and integration tests. Normally
I don't implement test code for all classes, I prefer to focus on the relevant ones, and be sure to implement
tests that makes sense based on the responsibilities of each of the classes.

* [SmokeIT.java](https://github.com/jcsastre/pico-survey-rest-api/blob/master/src/test/java/com/jcsastre/picosurveyrestapi/SmokeIT.java)
Integration test based on SpringBootTest (faster than the typical integration test). It test 4 basic scenarios.

* [ResponseGetSubjectsDtoTest.java](https://github.com/jcsastre/pico-survey-rest-api/blob/master/src/test/java/com/jcsastre/picosurveyrestapi/dto/ResponseGetSubjectsDtoTest)
Unit test to check a mapping function.

* [ResponseGetSurveysDtoTest.java](https://github.com/jcsastre/pico-survey-rest-api/blob/master/src/test/java/com/jcsastre/picosurveyrestapi/dto/ResponseGetSurveysDtoTest.java)
Unit test to check a mapping function.

## Regular code

Regarding to the code that implements the functionality, I've used Spring Boot and the typical MVC pattern. I've
used package by layer to organize the classes. There are model classes, controllers, repositories, services and dto's.

## Build and start the app

```
~ git clone https://github.com/jcsastre/pico-survey-rest-api.git
~ cd pico-survey-rest-api
~ mvn install
~ java -jar target/pico-survey-rest-api-0.0.1-SNAPSHOT.jar
```

## Test using curl

These curl tests are the same performed by [SmokeIT.java](https://github.com/jcsastre/pico-survey-rest-api/blob/master/src/test/java/com/jcsastre/picosurveyrestapi/SmokeIT.java)

### Use case A: Get available Subjects

```
~ curl http://localhost:8080/subjects
```

### Use case B: Get available Surveys without specifying a Subject

```
~ curl http://localhost:8080/surveys
```

### Use case C: Get available Surveys specifying a Subject that have Surveys

```
~ curl http://localhost:8080/surveys?subjectName=technology
```

### Use case D: Get available Surveys specifying a Subject that doesn't have Surveys

```
~ curl http://localhost:8080/surveys?subjectName=abcde
```
