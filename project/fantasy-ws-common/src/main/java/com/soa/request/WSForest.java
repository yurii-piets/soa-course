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
public class WSForest {

    private Long id;

    private Integer amountOfTrees;

    private List<WSElf> elfs = new ArrayList<>();

    public WSForest(Forest forest) {
        this.id = forest.getId();
        this.amountOfTrees = forest.getAmountOfTrees();
        mapElfs(forest.getElfs());
    }

    public Forest toForest() {
        Forest forest = new Forest();
        forest.setId(this.id);
        forest.setAmountOfTrees(this.amountOfTrees);
        forest.setElfs(this.elfs.stream()
                .map(WSElf::toElf)
                .collect(Collectors.toList()));
        return forest;
    }

    private void mapElfs(List<Elf> elfs) {
        if(elfs == null){
            return;
        }
        this.elfs = elfs.stream()
                .map(WSElf::new)
                .collect(Collectors.toList());
    }
}
