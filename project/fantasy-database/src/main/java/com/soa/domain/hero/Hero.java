package com.soa.domain.hero;

import com.soa.domain.Power;

public interface Hero {

    Power getPower();

    void setPower(Power power);

    Long getId();
}
