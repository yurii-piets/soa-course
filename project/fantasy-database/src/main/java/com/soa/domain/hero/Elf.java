package com.soa.domain.hero;

import com.soa.domain.Power;
import com.soa.domain.categories.Forest;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "HR_ELF")
@Data
@NoArgsConstructor
public class Elf {

    private static final String ELF_ID = "elf_id";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @JoinColumn(name = Forest.FOREST_ID)
    private Forest forest;

    public enum BowType {
        BAD,
        MIDDLE,
        GOOD
    }
}
