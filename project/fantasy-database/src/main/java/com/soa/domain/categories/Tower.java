package com.soa.domain.categories;

import com.soa.domain.hero.Mag;
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

@Entity(name = "CT_TOWER")
@Data
@NoArgsConstructor
@EqualsAndHashCode(exclude = "mags")
@ToString(exclude = "mags")
public class Tower implements Serializable {

    public static final String TOWER_ID = "tower_id";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = TOWER_ID)
    private Long id;

    private Integer height;

    @OneToMany(mappedBy = "tower", fetch = FetchType.LAZY)
    private List<Mag> mags;

    public Tower(Integer height) {
        this.height = height;
    }

    public void addMag(Mag mag) {
        if (mags == null) {
            mags = new ArrayList<>();
        }
        mags.add(mag);
    }
}
