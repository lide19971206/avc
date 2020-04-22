package com.lide.shop.domain;

import java.util.List;

public class ShopVo extends Shop {
	private Integer[] gname;
	private List<Integer> sids;
	
	
	public List<Integer> getSids() {
		return sids;
	}

	public void setSids(List<Integer> sids) {
		this.sids = sids;
	}

	public Integer[] getGname() {
		return gname;
	}

	public void setGname(Integer[] gname) {
		this.gname = gname;
	}
	
}
