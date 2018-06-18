package com.soa.domain.hero;

import com.soa.domain.Ownable;
import com.soa.domain.Power;
import com.soa.domain.UserData;
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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import java.io.Serializable;

@Entity(name = "HR_ELF")
@Data
@NoArgsConstructor
@NamedQueries({@NamedQuery(name = Elf.REACHEST_ELF_QUERY_NAME, query = "SELECT elf FROM com.soa.domain.hero.Elf elf WHERE elf.arrowCount = (SELECT MAX(e.arrowCount) FROM com.soa.domain.hero.Elf e)")})
public class Elf implements Hero, Ownable, Serializable {

    private static final String ELF_ID = "elf_id";

    public static final String REACHEST_ELF_QUERY_NAME = "REACHEST_ELF_QUERY_NAME";

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
    private Forest forest;

    @Override
    public UserData getOwner() {
        return forest.getOwner();
    }

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
