package com.soa.domain.categories;

import com.soa.domain.hero.Dragon;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "CT_CAVE")
@Data
@NoArgsConstructor
public class Cave {

    public static final String CAVE_ID = "cave_id";

    @Id
    @GeneratedValue
    @Column(name = CAVE_ID)
    private Long id;

    private Integer square;

    @OneToMany(mappedBy = "cave")
    private Set<Dragon> dragons;

    public void addDragon(Dragon dragon) {
        if (dragons == null) {
            dragons = new HashSet<>();
        }
        dragons.add(dragon);
    }
}
