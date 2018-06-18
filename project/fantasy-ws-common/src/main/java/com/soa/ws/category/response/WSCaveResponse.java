package com.soa.ws.category.response;

import com.soa.domain.categories.Cave;
import com.soa.domain.hero.Dragon;
import com.soa.ws.hero.response.WSDragonResponse;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class WSCaveResponse implements Serializable {

    private Long id;

    private Integer square;

    private List<WSDragonResponse> dragons = new ArrayList<>();

    public WSCaveResponse(Cave cave) {
        this.id = cave.getId();
        this.square = cave.getSquare();
        mapDragons(cave.getDragons());
    }

    private void mapDragons(List<Dragon> dragons) {
        if(dragons == null) {
            return;
        }
        this.dragons = dragons.stream()
                .map(WSDragonResponse::new)
                .collect(Collectors.toList());
    }
}
