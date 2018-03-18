package com.soa.servlet.car;

import lombok.Getter;

import javax.ejb.Stateless;
import java.util.LinkedList;
import java.util.List;

@Getter
@Stateless
public class CarChoiceHelper {

    private List<String> carMarks = new LinkedList<String>() {{
       add("Volvo");
       add("BMW");
       add("Audi");
       add("Cadillac");
    }};
}
