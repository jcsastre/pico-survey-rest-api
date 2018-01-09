package com.jcsastre.picosurveyrestapi.domain;

import lombok.*;

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
    @NonNull
    private String name;
}
