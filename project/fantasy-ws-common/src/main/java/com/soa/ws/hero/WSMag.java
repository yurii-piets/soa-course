package com.soa.ws.hero;

import com.soa.domain.Power;
import com.soa.domain.hero.Mag;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class WSMag {

    private Long id;

    private String name;

    private Integer mana;

    private Mag.Element element;

    private Power power;

    private Long towerId;

    public WSMag(Mag mag) {
        this.id = mag.getId();
        this.name = mag.getName();
        this.mana = mag.getMana();
        this.element = mag.getElement();
        this.power = mag.getPower();
        this.towerId = mag.getTower().getId();
    }

    public Mag toMag() {
        return Mag.builder()
                .id(id)
                .name(name)
                .mana(mana)
                .element(element)
                .power(power)
                .build();
    }
}
