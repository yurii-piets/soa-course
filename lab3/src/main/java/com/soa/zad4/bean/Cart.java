package com.soa.zad4.bean;

import lombok.Getter;

import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@SessionScoped
public class Cart implements Serializable {

	@Getter
	private final Map<Long, Integer> products = new HashMap<>();

	public void add(Long productId) {
		Integer productCount = products.getOrDefault(productId, 0);
		products.put(productId, ++productCount);
	}

	public void add(Long productId, Integer amount) {
		if (amount == null || amount < 0) {
			return;
		}
		products.put(productId, amount);
	}

	public void remove(Long productId) {
		Integer productCount = products.get(productId);
		if (productCount != null && productCount > 0) {
			products.put(productId, --productCount);
		}
	}

	public void clear(Long productId) {
		products.remove(productId);
	}

	public void clearAll() {
		products.clear();
	}
}
