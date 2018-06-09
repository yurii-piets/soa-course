package com.soa.domain.categories;

import com.soa.domain.hero.Mag;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "CT_TOWER")
@Data
@NoArgsConstructor
public class Tower {

    public static final String TOWER_ID = "tower_id";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
