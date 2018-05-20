package com.soa.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface Currency {

    @WebMethod
    Double getCurrencyByCode(String currencyCode);
}
