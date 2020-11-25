package com.clone.shop.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="shop_goods")
@SequenceGenerator(name="seq_goods_code", sequenceName = "seq_goods_code", initialValue = 1, allocationSize = 1)
@Getter
@Setter
@ToString
public class ShopGoods {
	//상품
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "seq_goods_code")
	@Column(name="seq_goods_code")
	private long seq_goods_code;
	
	@Column(name="name", nullable = false)
	private String name;
	
	@Column(name="price", nullable = false)
	private long price;
	
	@Column(name="quantity")
	@ColumnDefault("1")
	private int quantity;
}
