package com.soa.ws.category.response;

import com.soa.domain.categories.Tower;
import com.soa.domain.hero.Mag;
import com.soa.ws.hero.response.WSMagResponse;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class WSTowerResponse {

    private Long id;

    private Integer height;

    private List<WSMagResponse> mags = new ArrayList<>();

    public WSTowerResponse(Tower tower) {
        this.id = tower.getId();
        this.height = tower.getHeight();
        mapMags(tower.getMags());
    }

    private void mapMags(List<Mag> mags) {
        if(mags == null) {
            return;
        }
        this.mags = mags.stream()
                .map(WSMagResponse::new)
                .collect(Collectors.toList());
    }
}
