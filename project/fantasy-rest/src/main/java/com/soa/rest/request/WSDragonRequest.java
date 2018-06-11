package com.soa.rest.request;

import com.soa.domain.Power;
import com.soa.domain.hero.Dragon;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class WSDragonRequest {

    private String name;

    private Integer gold;

    private Dragon.Color color;

    private Power power;

    private Long caveId;

    public Dragon toDragon(){
        return Dragon.builder()
                .name(name)
                .gold(gold)
                .color(color)
                .power(power)
                .build();
    }
}
