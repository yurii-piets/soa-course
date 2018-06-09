package com.soa.domain.hero;

import com.soa.domain.Power;
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
import java.io.Serializable;

@Entity(name = "HR_DRAGON")
@Data
@NoArgsConstructor
public class Dragon implements Serializable {

    public static final String DRAGON_ID = "dragon_id";

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
    private Cave cave;

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
