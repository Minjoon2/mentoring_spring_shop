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
@Table(name="sysm_user")
@SequenceGenerator(name="seq_user_no", sequenceName = "seq_user_no", initialValue=1000, allocationSize = 1 )
@Getter
@Setter
@ToString
public class SysmUser{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "seq_user_no")
	@Column(name="uno")
	/*
	 * GeneratedValue : 자동 생성 전략 어노테이션
	  
	1. 몇번 이상으로 넣을수는 없는가 ?
	 ex)숫자 1000이상부터 1증가
	 	- @SequenceGenerator
	2. 오라클에 있는 시퀀스는 어떻게 사용하지 ?
	 - 옵션중 GenerationType.SEQUENCE 를 통해 사용가능
	
	GenerationType
		AUTO(default) 	: 자동 생성 전략 결정
		IDENTITY 		: 기본키 생성을 데이터베이스에 위임한다. 예를 들어 MySQL의 경우 AUTO_INCREMENT를 사용하여 기본키를 생성한다.
		SEQUENCE 		: 데이터베이스의 특별한 오브젝트 시퀀스를 사용하여 기본키를 생성한다.
		TABLE 			: 데이터베이스에 키 생성 전용 테이블을 하나 만들고 이를 사용하여 기본키를 생성한다.
		
	TODO : AUTO 와 IDENTITY 의 차이는 똑같지 않나?
	AUTO 는 세가지 전략을 자동으로 지정한다는데.. 알아볼것 
		
		
	 */
	private long userNo;
	
	@Column(name="email", nullable = false, unique = true)
	private String email;
	
	@Column(name="password", nullable=false)
	private String password;
	
	@Column(name="role")
	@ColumnDefault("'ROLE_USER'")
	private String role;
	
	@Column(name="name")
	private String name;
}
