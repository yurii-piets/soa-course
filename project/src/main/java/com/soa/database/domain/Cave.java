package com.soa.database.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Collection;

import static com.soa.database.domain.Elf.ELF_CAVE_ID;

@Data
@NoArgsConstructor
public class Cave {

    @Id
    @GeneratedValue
    private Long id;

    private Integer square;

    @OneToMany(mappedBy = ELF_CAVE_ID)
    private Collection<Elf> elfs;

    public void addElf(Elf elf){
        elfs.add(elf);
    }
}
