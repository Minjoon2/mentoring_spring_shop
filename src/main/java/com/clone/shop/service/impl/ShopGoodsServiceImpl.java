package com.clone.shop.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clone.shop.dao.ShopGoodsRepository;
import com.clone.shop.dto.ShopGoods;
import com.clone.shop.service.ShopGoodsService;

@Service
public class ShopGoodsServiceImpl implements ShopGoodsService{

	@Autowired
	ShopGoodsRepository shopGoodsRepository;
	
	@Override
	public void saveGoods(ShopGoods goods) {
		shopGoodsRepository.save(goods);
	}

	@Override
	public Optional<ShopGoods> getGoods(long goodsCode) {
		return shopGoodsRepository.findById(goodsCode);
	}
	
	@Override
	public List<ShopGoods> getAllGoods(){
		return shopGoodsRepository.findAll();
	}
	

}
