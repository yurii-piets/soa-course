package com.soa;

import com.soa.ws.Currency;
import com.soa.ws.CurrencyImplService;

public class CurrencyClientApplication {

    public static void main(String[] args) {
        CurrencyImplService currencyImplService = new CurrencyImplService();
        Currency currency = currencyImplService.getCurrencyImplPort();
        System.out.println(currency.getCurrencyByCode("UAH"));
    }
}
