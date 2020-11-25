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
	// ���ų��� �α�
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "seq_purchase")
	@Column(name="seq_purchase")
	private long seq_purchase;
	
	
	@ManyToOne
	//�� one to many�� �ƴ϶� many to one �̵Ǵ°ɱ�?
	//uno �� ���⼭ �������� �ɼ������� one-> many �ƴѰ� ?
	@JoinColumn(name="uno")
	private SysmUser uno;
	
	@ManyToOne
	@JoinColumn(name="goods_code")
	private ShopGoods goods_code;
	
	@Column(name = "quantity", nullable = false)
	private int quantity;
	
}
