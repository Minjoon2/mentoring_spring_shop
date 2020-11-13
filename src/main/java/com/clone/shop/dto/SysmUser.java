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
	 * GeneratedValue : �ڵ� ���� ���� ������̼�
	  
	1. ��� �̻����� �������� ���°� ?
	 ex)���� 1000�̻���� 1����
	 	- @SequenceGenerator
	2. ����Ŭ�� �ִ� �������� ��� ������� ?
	 - �ɼ��� GenerationType.SEQUENCE �� ���� ��밡��
	
	GenerationType
		AUTO(default) 	: �ڵ� ���� ���� ����
		IDENTITY 		: �⺻Ű ������ �����ͺ��̽��� �����Ѵ�. ���� ��� MySQL�� ��� AUTO_INCREMENT�� ����Ͽ� �⺻Ű�� �����Ѵ�.
		SEQUENCE 		: �����ͺ��̽��� Ư���� ������Ʈ �������� ����Ͽ� �⺻Ű�� �����Ѵ�.
		TABLE 			: �����ͺ��̽��� Ű ���� ���� ���̺��� �ϳ� ����� �̸� ����Ͽ� �⺻Ű�� �����Ѵ�.
		
	TODO : AUTO �� IDENTITY �� ���̴� �Ȱ��� �ʳ�?
	AUTO �� ������ ������ �ڵ����� �����Ѵٴµ�.. �˾ƺ��� 
		
		
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
