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
	//이용자 정보
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator="seq_user_info_no")
	@Column(name="seq_user_info_no")
	private long seqUserInfoNo;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "uno")
	//OneToOne 으로 단방향 매핑 설정
	//JoinColumn으로 내가 fk 걸고싶은 컬럼명 설정
	//@Column(name="uno", unique = true)
	//변수 선언은 해당하는 컬럼의 클래스로 생성할것. -- > 한참해맴
	private SysmUser uno;
	
	@ColumnDefault("0")
	@Column(name="money", nullable=false)
	private int money;
}
