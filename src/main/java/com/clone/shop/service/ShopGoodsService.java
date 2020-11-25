package com.clone.shop.service;

import java.util.List;
import java.util.Optional;

import com.clone.shop.dto.ShopGoods;

public interface ShopGoodsService {
	/*
		저장
		전체 변경
		수량 변경
		이름 변경
		가격 변경
	 */
	public void saveGoods(ShopGoods goods);
	//조회
	public Optional<ShopGoods> getGoods(long goodsCode);
	//모든 물품 조회
	public List<ShopGoods> getAllGoods();
	
}
