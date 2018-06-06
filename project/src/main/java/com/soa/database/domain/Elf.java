package com.soa.database.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import static com.soa.database.domain.Cave.CAVE_ID;

@Entity
@Data
@NoArgsConstructor
public class Elf {

    public static final String ELF_CAVE_ID = "cave_id";

    private static final String ELF_ID = "elf_id";

    @Id
    @GeneratedValue
    @Column(name = ELF_ID)
    private Long id;

    private String name;

    private Integer arrowCount;

    @Enumerated(EnumType.STRING)
    private BowType bowType;

    @Enumerated(EnumType.STRING)
    private Power power;

    @ManyToOne
    @JoinColumn(name = CAVE_ID)
    private Cave cave;

    public enum BowType {
        BAD,
        MIDDLE,
        GOOD
    }

    public enum Power {
        POWER_1,
        POWER_2,
        POWER_3
    }
}
