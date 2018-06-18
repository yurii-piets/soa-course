package com.soa.rest.service;

import com.soa.domain.Power;
import com.soa.domain.hero.Dragon;
import com.soa.domain.hero.Elf;
import com.soa.domain.hero.Mag;
import com.soa.ws.category.response.WSCaveResponse;
import com.soa.ws.category.response.WSForestResponse;
import com.soa.ws.category.response.WSTowerResponse;
import com.soa.ws.hero.response.WSDragonResponse;
import com.soa.ws.hero.response.WSElfResponse;
import com.soa.ws.hero.response.WSMagResponse;

import javax.ejb.Stateless;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Stateless
public class MerriamTranslateService implements TranslateService {

    private Map<String, String> wordsMap = new HashMap<String, String>() {{
        put(Power.POWER_1.toString(), "MOC_1");
        put(Power.POWER_2.toString(), "MOC_2");
        put(Power.POWER_3.toString(), "MOC_3");

        put(Dragon.Color.BLACK.toString(), "CZARNY");
        put(Dragon.Color.RED.toString(), "CZERWONY");
        put(Dragon.Color.WHITE.toString(), "BIA\u0141Y");

        put(Elf.BowType.BAD.toString(), "Z\u0141Y");
        put(Elf.BowType.GOOD.toString(), "DOBRY");
        put(Elf.BowType.MIDDLE.toString(), "\u015AREDNI");

        put(Mag.Element.STICK_1.toString(), "PA\u0141KA_1");
        put(Mag.Element.STICK_2.toString(), "PA\u0141KA_2");
        put(Mag.Element.STICK_3.toString(), "PA\u0141KA_3");
        put(Mag.Element.STICK_4.toString(), "PA\u0141KA_4");
    }};

    @Override
    public WSCaveResponse translate(WSCaveResponse wsCave) {
        wsCave.setDragons(wsCave.getDragons().stream()
                .map(this::translate)
                .collect(Collectors.toList()));
        return wsCave;
    }

    @Override
    public WSForestResponse translate(WSForestResponse wsForest) {
        wsForest.setElves(wsForest.getElves().stream()
                .map(this::translate)
                .collect(Collectors.toList()));
        return wsForest;
    }

    @Override
    public WSTowerResponse translate(WSTowerResponse wsTower) {
        wsTower.setMags(wsTower.getMags().stream()
                .map(this::translate)
                .collect(Collectors.toList()));
        return wsTower;
    }

    @Override
    public WSDragonResponse translate(WSDragonResponse wsDragon) {
        wsDragon.setColor(wordsMap.getOrDefault(wsDragon.getColor(), wsDragon.getColor()));
        wsDragon.setPower(wordsMap.getOrDefault(wsDragon.getPower(), wsDragon.getPower()));
        return wsDragon;
    }

    @Override
    public WSElfResponse translate(WSElfResponse wsElf) {
        wsElf.setBowType(wordsMap.getOrDefault(wsElf.getBowType(), wsElf.getBowType()));
        wsElf.setPower(wordsMap.getOrDefault(wsElf.getPower(), wsElf.getPower()));
        return wsElf;
    }

    @Override
    public WSMagResponse translate(WSMagResponse wsMag) {
        wsMag.setElement(wordsMap.getOrDefault(wsMag.getElement(), wsMag.getElement()));
        wsMag.setPower(wordsMap.getOrDefault(wsMag.getPower(), wsMag.getPower()));
        return wsMag;
    }
}
