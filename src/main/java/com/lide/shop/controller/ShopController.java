package com.lide.shop.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lide.shop.domain.Shop;
import com.lide.shop.domain.ShopVo;
import com.lide.shop.domain.goods;
import com.lide.shop.service.ShopService;

@Controller
public class ShopController {
	
	@Resource
	private ShopService service;
	
	@RequestMapping("list")
	private String showShopList(Model model,ShopVo vo,@RequestParam(defaultValue = "1")Integer pageNum) {
		if (null!=vo.getGname()) {
			Integer[] is = vo.getGname();
			String gids = "";
			for (Integer i : is) {
				gids+=","+i;
			}
			gids = gids.substring(1);
			List<Integer> sids = service.selectShopByGids(gids);
			vo.setSids(sids);
		}
		PageHelper.startPage(pageNum,2);
		List<Shop> shops = service.selectShops(vo);
		PageInfo info = new PageInfo(shops);
		List<goods> goods = service.selectGoods();
		model.addAttribute("goods",goods);
		model.addAttribute("shops",shops);
		model.addAttribute("info",info);
		model.addAttribute("vo",vo);
		return "shopList";
	}
	
	@RequestMapping("selectShopById")
	private String selectShopById(Model model,Integer id) {
		Shop shop = service.selectShopById(id);
		model.addAttribute("shop", shop);
		return "shopReadAll";
	}
	
	@RequestMapping("addShop")
	private String addShop(Model model) {
		List<goods> list = service.selectGoods();
		model.addAttribute("list", list);
		return "addShop";
	}
	
	@RequestMapping("add")
	@ResponseBody
	private boolean add(ShopVo vo,Model model) {
		model.addAttribute("vo", vo);
		return service.add(vo);
	}
	
	@RequestMapping("del")
	@ResponseBody
	private boolean del(String ids) {
		return service.del(ids);
	}

}
