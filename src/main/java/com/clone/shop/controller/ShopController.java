package com.clone.shop.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.clone.shop.dto.ShopGoods;
import com.clone.shop.service.ShopGoodsService;
import com.clone.shop.util.URL;

@RestController
@RequestMapping(value=URL.shop)
public class ShopController {
	@Autowired
	ShopGoodsService shopGoodsService;
	
	@RequestMapping(value=URL.shop_save)
	public String saveGoods(@ModelAttribute ShopGoods goods) {
		System.out.println(goods.toString());
		shopGoodsService.saveGoods(goods);
		return "goods save success";
	}
	
	@RequestMapping(value=URL.shop_get)
	public Optional<ShopGoods> getGoods(@RequestParam(name = "code") long goodsCode) {
		return shopGoodsService.getGoods(goodsCode);
	}
	
	@RequestMapping(value=URL.shop_getAll)
	public List<ShopGoods> getAllGoods() {
		return shopGoodsService.getAllGoods();
	}
	
	
}
