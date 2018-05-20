package com.soa;

import com.soa.ws.Vacation;
import com.soa.ws.VacationImplService;

public class VacationClientApplication {

    public static void main(String[] args) {
        VacationImplService vacationImplService = new VacationImplService();
        Vacation vacation = vacationImplService.getVacationImplPort();
        System.out.println(vacation.dayToVacation());
    }
}
