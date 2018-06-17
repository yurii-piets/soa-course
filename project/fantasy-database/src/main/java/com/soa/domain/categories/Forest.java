package com.soa.domain.categories;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.soa.domain.Ownable;
import com.soa.domain.UserData;
import com.soa.domain.hero.Elf;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "CT_FOREST")
@Data
@NoArgsConstructor
@EqualsAndHashCode(exclude = "elfs")
@ToString(exclude = "elfs")
public class Forest implements Serializable, Category, Ownable {

    public static final String FOREST_ID = "forest_id";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = FOREST_ID)
    private Long id;

    @Column(name = "amount_of_trees")
    private Integer amountOfTrees;

    @OneToMany(mappedBy = "forest", fetch = FetchType.LAZY)
    private List<Elf> elfs;

    @ManyToOne
    @JoinColumn(name = UserData.USER_ID)
    @JsonIgnore
    private UserData owner;

    public Forest(Long id, Integer amountOfTrees, UserData owner) {
        this.id = id;
        this.amountOfTrees = amountOfTrees;
        this.owner = owner;
    }

    public void addElf(Elf elf) {
        if (elfs == null) {
            elfs = new ArrayList<>();
        }
        elfs.add(elf);
    }
}
