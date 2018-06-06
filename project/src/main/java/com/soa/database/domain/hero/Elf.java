package com.soa.database.domain.hero;

import com.soa.database.domain.Power;
import com.soa.database.domain.categories.Forest;
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

import static com.soa.database.domain.categories.Forest.FOREST_ID;

@Entity(name = "HR_ELF")
@Data
@NoArgsConstructor
public class Elf {

    private static final String ELF_ID = "elf_id";

    @Id
    @GeneratedValue
    @Column(name = ELF_ID)
    private Long id;

    private String name;

    private Integer arrowCount;

    @Column(name = "bow_type")
    @Enumerated(EnumType.STRING)
    private BowType bowType;

    @Enumerated(EnumType.STRING)
    private Power power;

    @ManyToOne
    @JoinColumn(name = FOREST_ID)
    private Forest forest;

    public enum BowType {
        BAD,
        MIDDLE,
        GOOD
    }
}
