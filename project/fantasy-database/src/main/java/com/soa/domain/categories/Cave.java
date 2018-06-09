package com.soa.domain.categories;

import com.soa.domain.hero.Dragon;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "CT_CAVE")
@Data
@NoArgsConstructor
@EqualsAndHashCode(exclude = "dragons")
@ToString(exclude = "dragons")
public class Cave implements Serializable {

    public static final String CAVE_ID = "cave_id";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = CAVE_ID)
    private Long id;

    private Integer square;

    @OneToMany(mappedBy = "cave", fetch = FetchType.EAGER)
    private List<Dragon> dragons;

    public void addDragon(Dragon dragon) {
        if (dragons == null) {
            dragons = new ArrayList<>();
        }
        dragons.add(dragon);
    }
}
