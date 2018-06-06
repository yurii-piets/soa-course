package com.soa.database.domain.categories;

import com.soa.database.domain.hero.Mag;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class Tower {

    public static final String TOWER_ID = "tower_id";

    @Id
    @GeneratedValue
    @Column(name = TOWER_ID)
    private Long id;

    private Integer height;

    @OneToMany(mappedBy = "tower")
    private Set<Mag> mags;

    public void addMag(Mag mag) {
        if (mags == null) {
            mags = new HashSet<>();
        }
        mags.add(mag);
    }
}
