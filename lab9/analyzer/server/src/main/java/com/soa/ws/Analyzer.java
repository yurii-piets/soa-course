package com.soa.ws;

import com.soa.model.Info;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface Analyzer {

    @WebMethod
    Info analyze(String s);
}
