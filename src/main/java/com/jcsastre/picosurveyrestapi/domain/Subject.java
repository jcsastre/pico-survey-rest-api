package com.jcsastre.picosurveyrestapi.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class Subject {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true, nullable = false)
    @NonNull private String name;
}
