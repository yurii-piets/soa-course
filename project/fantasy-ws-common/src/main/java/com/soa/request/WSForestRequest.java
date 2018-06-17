package com.soa.request;

import com.soa.domain.categories.Forest;
import com.soa.domain.hero.Elf;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class WSForestRequest {

    private Long id;

    private Integer amountOfTrees;

    private List<WSElfRequest> elfs = new ArrayList<>();

    public WSForestRequest(Forest forest) {
        this.id = forest.getId();
        this.amountOfTrees = forest.getAmountOfTrees();
        mapElfs(forest.getElfs());
    }

    public Forest toForest() {
        Forest forest = new Forest();
        forest.setId(this.id);
        forest.setAmountOfTrees(this.amountOfTrees);
        forest.setElfs(this.elfs.stream()
                .map(WSElfRequest::toElf)
                .collect(Collectors.toList()));
        return forest;
    }

    private void mapElfs(List<Elf> elfs) {
        if(elfs == null){
            return;
        }
        this.elfs = elfs.stream()
                .map(WSElfRequest::new)
                .collect(Collectors.toList());
    }
}
