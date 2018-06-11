package com.soa;

import com.soa.soap.CategoryService;
import com.soa.soap.CategoryServiceImplService;
import com.soa.soap.Cave;
import com.soa.soap.Color;
import com.soa.soap.HeroService;
import com.soa.soap.HeroServiceImplService;
import com.soa.soap.Power;
import com.soa.soap.WsDragonRequest;

public class SoapClientApplication {

    public static void main(String[] args) {
        CategoryServiceImplService categoryServiceImplService = new CategoryServiceImplService();
        CategoryService categoryService = categoryServiceImplService.getCategoryServiceImplPort();

        Cave cave = new Cave();
        cave.setSquare(314);
        categoryService.saveCave(cave);


        HeroServiceImplService heroServiceImplService = new HeroServiceImplService();
        HeroService heroService = heroServiceImplService.getHeroServiceImplPort();
        WsDragonRequest wsDragonRequest = new WsDragonRequest();
        wsDragonRequest.setName("Dragon_ohnw");
        wsDragonRequest.setPower(Power.POWER_1);
        wsDragonRequest.setColor(Color.BLACK);
        wsDragonRequest.setGold(87);
        wsDragonRequest.setCaveId(1001L);
        heroService.saveDragon(wsDragonRequest);
    }
}
