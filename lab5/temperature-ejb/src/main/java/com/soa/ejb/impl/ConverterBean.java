package com.soa.ejb.impl;

import com.soa.ejb.def.Converter;

import javax.ejb.Remote;
import javax.ejb.Stateful;

@Stateful
@Remote(Converter.class)
public class ConverterBean implements Converter {

    @Override
    public double fahr2Cels(double temp) {
        return 5.0 / 9.0 * (temp - 32.0);
    }

    @Override
    public double cels2Fahr(double temp) {
        return 9.0 / 5.0 * (temp + 32.0);
    }
}
