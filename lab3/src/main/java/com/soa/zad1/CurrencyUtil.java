package com.soa.zad1;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;
import java.util.Properties;

public class CurrencyUtil {

    public static Double covert(Double value, String in, String out) {
        String propertyKey = in + "." + out;

        Double propertyValue = Double.valueOf(Objects.requireNonNull(getProperty(propertyKey)));
        return new BigDecimal(value * propertyValue).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    private static String getProperty(String key) {
        try {
            Properties properties = new Properties();
            properties.load(CurrencyUtil.class.getClassLoader().getResourceAsStream("currency.properties"));
            return properties.getProperty(key);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
