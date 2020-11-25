package com.clone.shop.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="shop_purchase_log")
@SequenceGenerator(name = "seq_purchase", sequenceName = "seq_purchase", initialValue = 1, allocationSize = 1)
@Getter
@Setter
@ToString
public class ShopPurchaseLog {
	// 구매내역 로그
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "seq_purchase")
	@Column(name="seq_purchase")
	private long seq_purchase;
	
	
	@ManyToOne
	//왜 one to many가 아니라 many to one 이되는걸까?
	//uno 가 여기서 여러개가 될수있으니 one-> many 아닌가 ?
	@JoinColumn(name="uno")
	private SysmUser uno;
	
	@ManyToOne
	@JoinColumn(name="goods_code")
	private ShopGoods goods_code;
	
	@Column(name = "quantity", nullable = false)
	private int quantity;
	
}
