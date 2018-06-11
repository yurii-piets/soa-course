package com.soa.domain.hero;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.soa.domain.Power;
import com.soa.domain.categories.Forest;
import lombok.Builder;
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
import java.io.Serializable;

@Entity(name = "HR_ELF")
@Data
@NoArgsConstructor
public class Elf implements Serializable {

    private static final String ELF_ID = "elf_id";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = ELF_ID)
    private Long id;

    private String name;

    @Column(name = "arrow_count")
    private Integer arrowCount;

    @Column(name = "bow_type")
    @Enumerated(EnumType.STRING)
    private BowType bowType;

    @Enumerated(EnumType.STRING)
    private Power power;

    @ManyToOne
    @JoinColumn(name = Forest.FOREST_ID)
    @JsonIgnore
    private Forest forest;

    public enum BowType {
        BAD,
        MIDDLE,
        GOOD
    }

    @Builder
    public Elf(Long id, String name, Integer arrowCount, BowType bowType, Power power, Forest forest) {
        this.id = id;
        this.name = name;
        this.arrowCount = arrowCount;
        this.bowType = bowType;
        this.power = power;
        this.forest = forest;
    }
}
