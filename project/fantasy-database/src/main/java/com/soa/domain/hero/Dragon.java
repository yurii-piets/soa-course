package com.soa.domain.hero;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.soa.domain.Ownable;
import com.soa.domain.Power;
import com.soa.domain.UserData;
import com.soa.domain.categories.Cave;
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

@Entity(name = "HR_DRAGON")
@NamedQueries({@NamedQuery(name = Dragon.REACHEST_DRAGON_QUERY_NAME, query = "SELECT dragon FROM com.soa.domain.hero.Dragon dragon WHERE dragon.gold = (SELECT MAX(d.gold) FROM com.soa.domain.hero.Dragon d)")})
@Data
@NoArgsConstructor
public class Dragon implements Hero, Ownable, Serializable {

    public static final String DRAGON_ID = "dragon_id";

    public static final String REACHEST_DRAGON_QUERY_NAME = "REACHEST_DRAGON_QUERY_NAME";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = DRAGON_ID)
    private Long id;

    private String name;

    private Integer gold;

    @Enumerated(EnumType.STRING)
    private Color color;

    @Enumerated(EnumType.STRING)
    private Power power;

    @ManyToOne
    @JoinColumn(name = Cave.CAVE_ID)
    @JsonIgnore
    private Cave cave;

    @Override
    public UserData getOwner() {
        return cave.getOwner();
    }

    public enum Color {
        BLACK,
        RED,
        WHITE
    }

    @Builder
    public Dragon(Long id, String name, Integer gold, Color color, Power power, Cave cave) {
        this.id = id;
        this.name = name;
        this.gold = gold;
        this.color = color;
        this.power = power;
        this.cave = cave;
    }
}
