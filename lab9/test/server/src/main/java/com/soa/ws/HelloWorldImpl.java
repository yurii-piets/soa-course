package com.soa.ws;

import javax.jws.WebService;

@WebService(endpointInterface = "com.soa.ws.HelloWorld")
public class HelloWorldImpl implements HelloWorld {

    @Override
    public String helloWorld(String name) {
        return "Hello " + name;
    }
}
