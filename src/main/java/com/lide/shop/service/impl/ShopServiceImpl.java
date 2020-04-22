package com.lide.shop.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lide.shop.dao.ShopDao;
import com.lide.shop.domain.Shop;
import com.lide.shop.domain.ShopVo;
import com.lide.shop.domain.goods;
import com.lide.shop.service.ShopService;

@Service
public class ShopServiceImpl implements ShopService {
	
	@Resource 
	private ShopDao dao;

	@Override
	public List<goods> selectGoods() {
		// TODO Auto-generated method stub
		return dao.selectGoods();
	}

	@Override
	public List<Shop> selectShops(ShopVo vo) {
		// TODO Auto-generated method stub
		return dao.selectShops(vo);
	}

	@Override
	public Shop selectShopById(Integer id) {
		// TODO Auto-generated method stub
		return dao.selectShopById(id);
	}

	@Override
	public List<Integer> selectShopByGids(String gid) {
		// TODO Auto-generated method stub
		return dao.selectShopByGids(gid);
	}

	@Override
	public boolean add(ShopVo vo) {
		try {
			dao.addShop(vo);
			if (null!=vo.getGname()) {
				for (Integer i : vo.getGname()) {
					dao.addCenter(i, vo.getId());
				}
			}
			return true;
		} catch (Exception e) {
			System.err.println("添加错误");
			return false;
		}
	}

	@Override
	public boolean del(String ids) {
		try {
			dao.delCenter(ids);
			dao.delShop(ids);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}
}
