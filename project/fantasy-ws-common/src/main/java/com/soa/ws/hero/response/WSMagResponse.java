package com.soa.ws.hero.response;

import com.soa.domain.hero.Mag;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class WSMagResponse {

    private Long id;

    private String name;

    private Integer mana;

    private String element;

    private String power;

    private Long towerId;

    public WSMagResponse(Mag mag) {
        this.id = mag.getId();
        this.name = mag.getName();
        this.mana = mag.getMana();
        this.element = mag.getElement().toString();
        this.power = mag.getPower().toString();
        this.towerId = mag.getTower().getId();
    }
}
