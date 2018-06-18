package com.soa.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Power {
    POWER_1(1),
    POWER_2(2),
    POWER_3(3);

    private final Integer intValue;
}
