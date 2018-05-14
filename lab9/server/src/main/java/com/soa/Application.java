package com.soa;

import com.soa.ws.HelloWorldImpl;

import javax.xml.ws.Endpoint;

public class Application {

    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8080/WS/HelloWorld", new HelloWorldImpl());
    }
}
