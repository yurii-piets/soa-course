package com.soa.ws;

import javax.jws.WebService;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebService(endpointInterface = "com.soa.ws.Analyzer")
public class AnalyzerImpl implements Analyzer {

    @Override
    public Info analyze(String s) {
        Info info = new Info();
        info.setCapitalAmount(countMatches(s, "[A-Z]"));
        info.setCharAmount(s.length());
        info.setLowerAmount(countMatches(s, "[a-z]"));
        info.setNumberAmount(countMatches(s, "[0-9]"));
        info.setSpaceAmount(countMatches(s, " "));
        return info;
    }

    private int countMatches(String s, String regex) {
        int amount = 0;
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(s);
        while (matcher.find()) {
            amount++;
        }
        return amount;
    }
}
