package com.soa;

import com.soa.ws.HelloWorld;
import com.soa.ws.HelloWorldImplService;

public class Application {

    public static void main(String[] args) {
        HelloWorldImplService helloWorldService = new HelloWorldImplService();
        HelloWorld helloWorld = helloWorldService.getHelloWorldImplPort();
        System.out.println(helloWorld.helloWorld("World"));
    }
}
