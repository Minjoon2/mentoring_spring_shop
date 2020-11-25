package com.clone.shop.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clone.shop.dto.ShopGoods;

@Transactional
@Repository
public interface ShopGoodsRepository extends JpaRepository<ShopGoods, Long>{
	
}
