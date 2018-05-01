package com.soa.zad3.bean;

import lombok.Getter;

import javax.ejb.Singleton;
import java.util.concurrent.ThreadLocalRandom;

@Singleton
public class NumberBean {

    private Integer number;

    @Getter
    private int guess = 0;

    public NumberBean() {
        super();
        randomize();
    }

    private void randomize() {
        number = ThreadLocalRandom.current().nextInt(0, 100);
    }

    public int compare(Integer number){
        int compare = Integer.compare(this.number, number);
        if(compare == 0){
            randomize();
        }
        guess++;
        return compare;
    }
}
