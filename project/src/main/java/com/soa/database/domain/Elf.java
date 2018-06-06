package com.soa.database.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@NoArgsConstructor
public class Elf {

    public static final String ELF_CAVE_ID = "cave_id";

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @Column(name = ELF_CAVE_ID)
    @JoinColumn(name = "cave_id")
    private Cave cave;
}
