package com.lide.shop.domain;

import java.util.List;

public class Shop {
	private Integer id;
	private String name;
	private String created;
	private	List<goods> goods;
	public Shop() {
		super();
	}
	
	public List<goods> getGoods() {
		return goods;
	}

	public void setGoods(List<goods> goods) {
		this.goods = goods;
	}

	public Shop(Integer id, String name, String created, List<com.lide.shop.domain.goods> goods) {
		super();
		this.id = id;
		this.name = name;
		this.created = created;
		this.goods = goods;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCreated() {
		return created;
	}
	public void setCreated(String created) {
		this.created = created;
	}
	
}
