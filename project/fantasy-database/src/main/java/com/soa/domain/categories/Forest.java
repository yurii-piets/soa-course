package com.soa.domain.categories;

import com.soa.domain.hero.Elf;
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

@Entity(name = "CT_FOREST")
@Data
@NoArgsConstructor
public class Forest {

    public static final String FOREST_ID = "forest_id";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = FOREST_ID)
    private Long id;

    @Column(name = "amount_of_trees")
    private Integer amountOfTrees;

    @OneToMany(mappedBy = "forest")
    private Set<Elf> elfs;

    public void addElf(Elf elf) {
        if (elfs == null) {
            elfs = new HashSet<>();
        }
        elfs.add(elf);
    }
}
