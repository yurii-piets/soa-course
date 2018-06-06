package com.soa.database.domain.categories;

import com.soa.database.domain.hero.Elf;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;


@Entity
@Data
@NoArgsConstructor
public class Cave {

    public static final String CAVE_ID = "cave_id";

    @Id
    @GeneratedValue
    @Column(name = CAVE_ID)
    private Long id;

    private Integer square;

    @OneToMany(mappedBy = "cave")
    private Set<Elf> elfs;

    public void addElf(Elf elf){
        if(elfs == null) {
            elfs = new HashSet<>();
        }
        elfs.add(elf);
    }
}
