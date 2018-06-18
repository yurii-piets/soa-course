package com.soa.ws.hero;

import com.soa.domain.Power;
import com.soa.domain.hero.Dragon;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class WSDragon {

    private Long id;

    private String name;

    private Integer gold;

    private Dragon.Color color;

    private Power power;

    private Long caveId;

    public WSDragon(Dragon dragon) {
        this.id = dragon.getId();
        this.name = dragon.getName();
        this.gold = dragon.getGold();
        this.color = dragon.getColor();
        this.power = dragon.getPower();
        this.caveId = dragon.getCave().getId();
    }

    public Dragon toDragon(){
        return Dragon.builder()
                .id(id)
                .name(name)
                .gold(gold)
                .color(color)
                .power(power)
                .build();
    }
}
