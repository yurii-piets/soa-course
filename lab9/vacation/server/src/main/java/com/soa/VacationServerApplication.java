package com.soa;

import com.soa.ws.VacationImpl;

import javax.xml.ws.Endpoint;

public class VacationServerApplication {

    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8080/vacation", new VacationImpl());
    }
}
