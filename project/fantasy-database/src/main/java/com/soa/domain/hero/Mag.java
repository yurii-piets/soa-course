package com.soa.domain.hero;

import com.soa.domain.Power;
import com.soa.domain.categories.Tower;
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

@Entity(name = "HR_MAG")
@Data
@NoArgsConstructor
public class Mag {

    public static final String MAG_ID = "mag_id";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = MAG_ID)
    private Long id;

    private String name;

    private Integer mana;

    @Enumerated(EnumType.STRING)
    private Element element;

    @Enumerated(EnumType.STRING)
    private Power power;

    @ManyToOne
    @JoinColumn(name = Tower.TOWER_ID)
    private Tower tower;

    public enum Element {
        STICK_1,
        STICK_2,
        STICK_3,
        STICK_4
    }
}
