package com.soa.ws.category.response;

import com.soa.domain.categories.Forest;
import com.soa.domain.hero.Elf;
import com.soa.ws.hero.response.WSElfResponse;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class WSForestResponse {

    private Long id;

    private Integer amountOfTrees;

    private List<WSElfResponse> elves = new ArrayList<>();

    public WSForestResponse(Forest forest) {
        this.id = forest.getId();
        this.amountOfTrees = forest.getAmountOfTrees();
        mapElves(forest.getElfs());
    }

    private void mapElves(List<Elf> elves) {
        if(elves == null){
            return;
        }
        this.elves = elves.stream()
                .map(WSElfResponse::new)
                .collect(Collectors.toList());
    }
}
