package com.soa.ws.hero.response;

import com.soa.domain.hero.Dragon;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class WSDragonResponse {

    private Long id;

    private String name;

    private Integer gold;

    private String color;

    private String power;

    private Long caveId;

    public WSDragonResponse(Dragon dragon) {
        this.id = dragon.getId();
        this.name = dragon.getName();
        this.gold = dragon.getGold();
        this.color = dragon.getColor().toString();
        this.power = dragon.getPower().toString();
        this.caveId = dragon.getCave().getId();
    }
}
