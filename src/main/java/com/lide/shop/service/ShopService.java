package com.lide.shop.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lide.shop.domain.Shop;
import com.lide.shop.domain.ShopVo;
import com.lide.shop.domain.goods;

public interface ShopService {
	List<goods> selectGoods();
	List<Shop> selectShops(ShopVo vo);
	Shop selectShopById(Integer id);
	List<Integer> selectShopByGids(String gid);
	boolean add(ShopVo vo);
	boolean del(String ids);
}
