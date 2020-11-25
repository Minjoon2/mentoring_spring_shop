package com.clone.shop.service;

import com.clone.shop.dto.SysmUser;
import com.clone.shop.dto.SysmUserInfo;

public interface SysmUserService {
	//회원가입
	public void signUp(SysmUser user);
	//로그인 검증
	public boolean signIn(SysmUser user);
	//회원 탈퇴
	public void deleteUserByEmail(SysmUser user);
	//회원 수정
	public String updateUser(SysmUser name);
	//회원 조회
	public SysmUser getUser(String email);
	
	//회원 자산 조회
	public int getUserMoney(SysmUser user);
	//회원 자산 추가
	public void addUserMoney(SysmUser user, int money);
}
