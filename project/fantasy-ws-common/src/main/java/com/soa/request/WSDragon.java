package com.soa.request;

import com.soa.domain.Power;
import com.soa.domain.hero.Dragon;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class WSDragon {

    private String name;

    private Integer gold;

    private Dragon.Color color;

    private Power power;

    private Long caveId;

    public WSDragon(Dragon dragon) {
        this.name = dragon.getName();
        this.gold = dragon.getGold();
        this.color = dragon.getColor();
        this.power = dragon.getPower();
        this.caveId = dragon.getCave().getId();
    }

    public Dragon toDragon(){
        return Dragon.builder()
                .name(name)
                .gold(gold)
                .color(color)
                .power(power)
                .build();
    }
}
