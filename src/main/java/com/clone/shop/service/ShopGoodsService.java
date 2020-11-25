package com.clone.shop.service;

import java.util.List;
import java.util.Optional;

import com.clone.shop.dto.ShopGoods;

public interface ShopGoodsService {
	/*
		����
		��ü ����
		���� ����
		�̸� ����
		���� ����
	 */
	public void saveGoods(ShopGoods goods);
	//��ȸ
	public Optional<ShopGoods> getGoods(long goodsCode);
	//��� ��ǰ ��ȸ
	public List<ShopGoods> getAllGoods();
	
}
