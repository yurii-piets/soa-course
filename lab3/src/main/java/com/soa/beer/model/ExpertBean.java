package com.soa.beer.model;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Stateless
public class ExpertBean {

    private Map<String, List<String>> beers = new HashMap<>();

    @PostConstruct
    public void postConstruct() {
        initBeers();
    }

    private void initBeers() {
        beers.put("jasny", new LinkedList<String>() {{
            add("piwo jasne 1");
            add("piwo jasne 2");
            add("piwo jasne 3");
            add("piwo jasne 4");
        }});

        beers.put("bursztynowy", new LinkedList<String>() {{
            add("piwo bursztynowy 1");
            add("piwo bursztynowy 2");
            add("piwo bursztynowy 3");
            add("piwo bursztynowy 4");
        }});

        beers.put("brazowy", new LinkedList<String>() {{
            add("piwo brazowy 1");
            add("piwo brazowy 2");
            add("piwo brazowy 3");
            add("piwo brazowy 4");
        }});

        beers.put("ciemny", new LinkedList<String>() {{
            add("piwo ciemny 1");
            add("piwo ciemny 2");
            add("piwo ciemny 3");
            add("piwo ciemny 4");
        }});
    }

    public List<String> getBeersByType(String beerType) {
        return beers.getOrDefault(beerType, Collections.emptyList());
    }
}
