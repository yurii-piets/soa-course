package com.soa.database.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
        elfs.add(elf);
    }
}
