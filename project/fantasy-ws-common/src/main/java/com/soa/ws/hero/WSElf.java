package com.soa.ws.hero;

import com.soa.domain.Power;
import com.soa.domain.hero.Elf;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class WSElf {

    private String name;

    private Integer arrowCount;

    private Elf.BowType bowType;

    private Power power;

    private Long forestId;

    public WSElf(Elf elf) {
        this.name = elf.getName();
        this.arrowCount = elf.getArrowCount();
        this.bowType = elf.getBowType();
        this.power = elf.getPower();
        this.forestId = elf.getForest().getId();
    }

    public Elf toElf(){
        return Elf.builder()
                .name(name)
                .arrowCount(arrowCount)
                .bowType(bowType)
                .power(power)
                .build();
    }
}
