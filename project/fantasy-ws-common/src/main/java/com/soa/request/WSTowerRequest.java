package com.soa.request;

import com.soa.domain.categories.Tower;
import com.soa.domain.hero.Mag;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class WSTowerRequest {

    private Long id;

    private Integer height;

    private List<WSMagRequest> mags = new ArrayList<>();

    public WSTowerRequest(Tower tower) {
        this.id = tower.getId();
        this.height = tower.getHeight();
        mapMags(tower.getMags());
    }

    public Tower toTower() {
        Tower tower = new Tower();
        tower.setId(this.id);
        tower.setHeight(this.height);
        tower.setMags(this.mags.stream()
                .map(WSMagRequest::toMag)
                .collect(Collectors.toList()));
        return tower;
    }

    private void mapMags(List<Mag> mags) {
        if(mags == null) {
            return;
        }
        this.mags = mags.stream()
                .map(WSMagRequest::new)
                .collect(Collectors.toList());
    }
}
