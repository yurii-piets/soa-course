package com.soa.zad3;

import lombok.Getter;

import javax.faces.bean.ManagedBean;

@ManagedBean(name = "carFacelet")
public class CarFacelet {

	@Getter
	private String message = "Message";
}
