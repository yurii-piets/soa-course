package com.soa.domain.categories;

import com.soa.domain.UserData;
import com.soa.domain.hero.Dragon;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "CT_CAVE")
@Data
@NoArgsConstructor
@EqualsAndHashCode(exclude = "dragons")
@ToString(exclude = "dragons")
public class Cave implements Serializable, Category {

    public static final String CAVE_ID = "cave_id";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = CAVE_ID)
    private Long id;

    private Integer square;

    @OneToMany(mappedBy = "cave")
    private List<Dragon> dragons;

    @ManyToOne
    @JoinColumn(name = UserData.USER_ID)
    private UserData owner;

    public Cave(Long id, Integer square) {
        this.id = id;
        this.square = square;
    }

    public void addDragon(Dragon dragon) {
        if (dragons == null) {
            dragons = new ArrayList<>();
        }
        dragons.add(dragon);
    }
}
