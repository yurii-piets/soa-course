package com.soa.ws.hero.response;

import com.soa.domain.hero.Elf;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class WSElfResponse {

    private Long id;

    private String name;

    private Integer arrowCount;

    private String bowType;

    private String power;

    private Long forestId;

    public WSElfResponse(Elf elf) {
        this.id = elf.getId();
        this.name = elf.getName();
        this.arrowCount = elf.getArrowCount();
        this.bowType = elf.getBowType().toString();
        this.power = elf.getPower().toString();
        this.forestId = elf.getForest().getId();
    }
}
