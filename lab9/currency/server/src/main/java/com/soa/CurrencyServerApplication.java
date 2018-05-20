package com.soa;

import com.soa.ws.CurrencyImpl;

import javax.xml.ws.Endpoint;

public class CurrencyServerApplication {

    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8080/currency", new CurrencyImpl());
    }
}
