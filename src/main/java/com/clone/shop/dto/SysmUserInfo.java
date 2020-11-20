package com.clone.shop.dto;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;
import org.springframework.boot.context.properties.bind.DefaultValue;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="sysm_user_info")
@SequenceGenerator(name="seq_user_info_no", sequenceName = "seq_user_info_no", initialValue = 1, allocationSize = 1)
@Setter
@Getter
public class SysmUserInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator="seq_user_info_no")
	@Column(name="seq_user_info_no")
	private long seqUserInfoNo;
	
	@Column(name="uno", unique = true)
	private long uno;
	
	@ColumnDefault("0")
	@Column(name="money", nullable=false)
	private int money;
}
