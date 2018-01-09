package com.jcsastre.picosurveyrestapi.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class Survey {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @NonNull private Subject subject;

    @Embedded
    @NonNull private Target target;
}
