package com.soa.ws;

import org.springframework.web.client.RestTemplate;

import javax.jws.WebService;

@WebService(endpointInterface = "com.soa.ws.Currency")
public class CurrencyImpl implements Currency {

    @Override
    public Double getCurrencyByCode(String currencyCode) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://free.currencyconverterapi.com/api/v5/convert?q=" + currencyCode.toUpperCase() + "_PLN&compact=y";
        String v = restTemplate.getForEntity(url, String.class).getBody();
        String s = v.split("val\":")[1].split("}}")[0];
        return Double.valueOf(s);
    }
}
