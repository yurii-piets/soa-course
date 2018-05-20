package com.soa.ws;

import javax.jws.WebService;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@WebService(endpointInterface = "com.soa.ws.Vacation")
public class VacationImpl implements Vacation {

    public static final LocalDateTime VACATION_DATE = LocalDateTime.of(2018, 7, 1, 0, 0);

    @Override
    public Double dayToVacation() {
        return (double) LocalDateTime.now().until(VACATION_DATE, ChronoUnit.DAYS);
    }
}
