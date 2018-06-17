package com.soa.request;

import com.soa.domain.categories.Cave;
import com.soa.domain.hero.Dragon;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class WSCaveRequest {

    private Long id;

    private Integer square;

    private List<WSDragonRequest> dragons = new ArrayList<>();

    public WSCaveRequest(Cave cave) {
        this.id = cave.getId();
        this.square = cave.getSquare();
        mapDragons(cave.getDragons());
    }

    private void mapDragons(List<Dragon> dragons) {
        if(dragons == null) {
            return;
        }
        this.dragons = dragons.stream()
                .map(WSDragonRequest::new)
                .collect(Collectors.toList());
    }

    public Cave toCave() {
        Cave cave = new Cave();
        cave.setId(this.id);
        cave.setSquare(this.square);
        cave.setDragons(this.dragons.stream()
                .map(WSDragonRequest::toDragon)
                .collect(Collectors.toList()));
        return cave;
    }
}
