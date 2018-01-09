package com.jcsastre.picosurveyrestapi.domain;

import lombok.*;

import javax.persistence.Embeddable;

@Embeddable
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class Target {

    @NonNull private Gender gender;
    @NonNull private Integer ageRangeLeft;
    @NonNull private Integer ageRangeRight;

    public enum Gender {
        M, F
    }
}
