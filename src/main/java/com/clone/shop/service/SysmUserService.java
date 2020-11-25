package com.clone.shop.service;

import com.clone.shop.dto.SysmUser;
import com.clone.shop.dto.SysmUserInfo;

public interface SysmUserService {
	//ȸ������
	public void signUp(SysmUser user);
	//�α��� ����
	public boolean signIn(SysmUser user);
	//ȸ�� Ż��
	public void deleteUserByEmail(SysmUser user);
	//ȸ�� ����
	public String updateUser(SysmUser name);
	//ȸ�� ��ȸ
	public SysmUser getUser(String email);
	
	//ȸ�� �ڻ� ��ȸ
	public int getUserMoney(SysmUser user);
	//ȸ�� �ڻ� �߰�
	public void addUserMoney(SysmUser user, int money);
}
