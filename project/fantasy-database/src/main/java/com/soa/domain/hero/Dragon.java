package com.soa.domain.hero;

import com.soa.domain.Power;
import com.soa.domain.categories.Cave;
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

@Entity(name = "HR_DRAGON")
@Data
@NoArgsConstructor
public class Dragon {

    public static final String DRAGON_ID = "dragon_id";

    @Id
    @GeneratedValue
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

}
