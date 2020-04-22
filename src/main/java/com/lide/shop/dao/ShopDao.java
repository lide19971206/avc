package com.lide.shop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lide.shop.domain.Shop;
import com.lide.shop.domain.ShopVo;
import com.lide.shop.domain.goods;

public interface ShopDao {
	/**
	 * 
	 * @Title: selectGoods 
	 * @Description:查询所有商品列表
	 * @return
	 * @return: List<goods>
	 */
	List<goods> selectGoods();
	/**
	 * 
	 * @Title: selectShops 
	 * @Description: 查询所有商店的详细信息
	 * @param vo
	 * @return
	 * @return: List<Shop>
	 */
	List<Shop> selectShops(ShopVo vo);
	/**
	 * 
	 * @Title: selectShopById 
	 * @Description: 查询商店的详细信息
	 * @param id
	 * @return
	 * @return: Shop
	 */
	Shop selectShopById(@Param("id")Integer id);
	/**
	 * 
	 * @Title: selectShopByVo 
	 * @Description: 根据商品列表查询商店id
	 * @param vo
	 * @return
	 * @return: List<Integer>
	 */
	List<Integer> selectShopByGids(@Param("ids")String gid);
	
	/**
	 * 
	 * @Title: addShop 
	 * @Description: 添加商店表
	 * @param vo
	 * @return
	 * @return: int
	 */
	int addShop(ShopVo vo);
	/**
	 * 
	 * @Title: addCenter 
	 * @Description: 添加中间表
	 * @param gid
	 * @param sid
	 * @return
	 * @return: int
	 */
	int addCenter(@Param("gid")Integer gid,@Param("sid")Integer sid);
	
	/**
	 * 
	 * @Title: delCenter 
	 * @Description:先删除中间表
	 * @param ids
	 * @return
	 * @return: int
	 */
	int delCenter(@Param("ids")String ids);
	
	/**
	 * 
	 * @Title: delShop 
	 * @Description: 再删除商店
	 * @param ids
	 * @return
	 * @return: int
	 */
	int delShop(@Param("ids")String ids);
}
