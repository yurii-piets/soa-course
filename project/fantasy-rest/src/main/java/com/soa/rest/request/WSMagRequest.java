package com.soa.rest.request;

import com.soa.domain.Power;
import com.soa.domain.hero.Mag;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class WSMagRequest {

    private String name;

    private Integer mana;

    private Mag.Element element;

    private Power power;

    private Long towerId;

    public Mag toMag(){
        return Mag.builder()
                .name(name)
                .mana(mana)
                .element(element)
                .power(power)
                .build();
    }
}
