package com.soa.zad3;

import com.google.common.collect.Lists;
import lombok.Getter;
import lombok.Setter;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@ManagedBean(name = "carFacelet")
@SessionScoped
public class CarFacelet {

	private String mark;

	private String model;

	private List<String> models;

	private Map<String, List<String>> marks = new HashMap<String, List<String>>(){{
		put("Audi", Lists.newArrayList("80", "100", "A1", "A2", "A3", "A4"));
		put("BMW", Lists.newArrayList("113", "220", "320", "750i"));
		put("Citroene", Lists.newArrayList("100", "200", "300", "400"));
		put("Dacia", Lists.newArrayList("Logan", "Duster"));
		put("Fiat", Lists.newArrayList("126", "127", "125p"));
	}};
}
