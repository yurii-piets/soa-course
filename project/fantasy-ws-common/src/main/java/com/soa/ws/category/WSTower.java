package com.soa.ws.category;

import com.soa.domain.categories.Tower;
import com.soa.domain.hero.Mag;
import com.soa.ws.hero.WSMag;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class WSTower {

    private Long id;

    private Integer height;

    private List<WSMag> mags = new ArrayList<>();

    public WSTower(Tower tower) {
        this.id = tower.getId();
        this.height = tower.getHeight();
        mapMags(tower.getMags());
    }

    public Tower toTower() {
        Tower tower = new Tower();
        tower.setId(this.id);
        tower.setHeight(this.height);
        tower.setMags(this.mags.stream()
                .map(WSMag::toMag)
                .collect(Collectors.toList()));
        return tower;
    }

    private void mapMags(List<Mag> mags) {
        if(mags == null) {
            return;
        }
        this.mags = mags.stream()
                .map(WSMag::new)
                .collect(Collectors.toList());
    }
}
