package com.soa.database.domain.hero;

import com.soa.database.domain.Power;
import com.soa.database.domain.categories.Tower;
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

import static com.soa.database.domain.categories.Tower.TOWER_ID;

@Entity(name = "HR_MAG")
@Data
@NoArgsConstructor
public class Mag {

    public static final String MAG_ID = "mag_id";

    @Id
    @GeneratedValue
    @Column(name = MAG_ID)
    private Long id;

    private String name;

    private Integer mana;

    @Enumerated(EnumType.STRING)
    private Element element;

    @Enumerated(EnumType.STRING)
    private Power power;

    @ManyToOne
    @JoinColumn(name = TOWER_ID)
    private Tower tower;

    public enum Element {
        STICK_1,
        STICK_2,
        STICK_3,
        STICK_4
    }
}
