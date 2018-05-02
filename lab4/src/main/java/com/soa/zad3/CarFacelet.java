package com.soa.zad3;

import com.google.common.collect.Lists;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@SessionScoped
@ManagedBean(name = "carFacelet")
public class CarFacelet {

    private String mark;

    private String model;

    private Integer priceFrom;

    private Integer priceTo;

    private String engineType;

    private String userName;

    private String userPhone;

    private boolean valid = false;

    public List<String> results() {
        List<String> results = new ArrayList<>();
        if(engineType == null){
            return results;
        }
        if(engineType.equals("ON")) {
            results.add("Skoda Fabia - disel");
            results.add("Skoda Octavia - disel");
        } else {
            results.add("Alfa Rome 146 - benzyna");
            results.add("Alfa Rome 156 - benzyna");
        }
        return results;
    }

    public boolean validate() {
        this.valid = this.mark != null
                && this.model != null
                && this.priceFrom != null
                && this.priceTo != null
                && this.engineType != null
                && this.userName != null
                && priceFrom <= priceTo;

        return valid;
    }

    public void clear() {
        this.mark = null;
        this.model = null;
        this.priceFrom = null;
        this.priceTo = null;
        this.engineType = null;
        this.userName = null;
        this.valid = false;
    }

    private Map<String, List<String>> marks = new HashMap<String, List<String>>() {{
        put("Audi", Lists.newArrayList("80", "100", "A1", "A2", "A3", "A4"));
        put("BMW", Lists.newArrayList("113", "220", "320", "750i"));
        put("Citroene", Lists.newArrayList("100", "200", "300", "400"));
        put("Dacia", Lists.newArrayList("Logan", "Duster"));
        put("Fiat", Lists.newArrayList("126", "127", "125p"));
    }};
}
