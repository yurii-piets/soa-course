package com.soa.ws;

import com.soa.model.Info;

import javax.jws.WebService;

@WebService(endpointInterface = "com.soa.ws.Analyzer")
public class AnalyzerImpl implements Analyzer {

    @Override
    public Info analyze(String s) {
        Info info = new Info();
        return info;
    }
}
