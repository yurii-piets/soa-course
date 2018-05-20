package com.soa.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface Vacation {

    @WebMethod
    Double dayToVacation();
}
