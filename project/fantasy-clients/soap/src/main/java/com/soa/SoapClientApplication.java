package com.soa;

import com.soa.soap.CategoryService;
import com.soa.soap.CategoryServiceImplService;
import com.soa.soap.HeroService;
import com.soa.soap.HeroServiceImplService;

public class SoapClientApplication {

    public static void main(String[] args) {
        CategoryServiceImplService categoryServiceImplService = new CategoryServiceImplService();
        CategoryService categoryService = categoryServiceImplService.getCategoryServiceImplPort();

//        WsCave cave = new WsCave();
//        cave.setSquare(314);
//        categoryService.saveCave(cave);

        HeroServiceImplService heroServiceImplService = new HeroServiceImplService();
        HeroService heroService = heroServiceImplService.getHeroServiceImplPort();
//        WsDragon wsDragonRequest = new WsDragon();
//        wsDragonRequest.setName("Dragon_ohnw");
//        wsDragonRequest.setPower(Power.POWER_1);
//        wsDragonRequest.setColor(Color.BLACK);
//        wsDragonRequest.setGold(87);
//        wsDragonRequest.setCaveId(1001L);
//        heroService.saveDragon(wsDragonRequest);

        heroService.modifyArrows(1013L, 1);
    }
}
