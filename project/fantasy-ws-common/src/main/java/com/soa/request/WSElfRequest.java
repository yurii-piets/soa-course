package com.soa.request;

import com.soa.domain.Power;
import com.soa.domain.hero.Elf;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class WSElfRequest {

    private String name;

    private Integer arrowCount;

    private Elf.BowType bowType;

    private Power power;

    private Long forestId;

    public Elf toElf(){
        return Elf.builder()
                .name(name)
                .arrowCount(arrowCount)
                .bowType(bowType)
                .power(power)
                .build();
    }
}
