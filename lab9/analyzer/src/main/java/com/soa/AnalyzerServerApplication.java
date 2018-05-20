package com.soa;

import com.soa.ws.AnalyzerImpl;

import javax.xml.ws.Endpoint;

public class AnalyzerServerApplication {

    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8081/analzyer", new AnalyzerImpl());
    }
}
