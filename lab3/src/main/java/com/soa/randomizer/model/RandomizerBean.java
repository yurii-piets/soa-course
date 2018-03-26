package com.soa.randomizer.model;

import lombok.Getter;

import javax.ejb.Stateless;
import java.util.Random;

@Stateless
public class RandomizerBean {

    @Getter
    private Integer number;

    public void generate() {
        number = new Random(0).nextInt(100);
    }
}
