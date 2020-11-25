package com.clone.shop.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clone.shop.dao.SysmUserInfoRepository;
import com.clone.shop.dao.SysmUserRepository;
import com.clone.shop.dto.SysmUser;
import com.clone.shop.dto.SysmUserInfo;
import com.clone.shop.service.SysmUserService;

@Service
public class SysmUserServiceImpl implements SysmUserService{
	@Autowired
	SysmUserRepository sysmUserRepository;
	@Autowired
	SysmUserInfoRepository sysmUserInfoRepository;
	
	public void signUp(SysmUser user) {
		sysmUserRepository.save(user);
	}
	
	public boolean signIn(SysmUser user) {
		SysmUser obj = sysmUserRepository.findByEmail(user.getEmail());
		if(obj.getPassword().equals(user.getPassword()))
			return true;
		return false;
	}
	
	public void deleteUserByEmail(SysmUser user) {
		if(signIn(user))
			sysmUserRepository.deleteByEmail(user.getEmail());
	}
	
	public String updateUser(SysmUser user) {
		if(signIn(user)) {
			user.setName(user.getName());
			sysmUserRepository.save(user);
			return user.getName()+" 변경 성공";
		}
		return "none";
	}
	
	public SysmUser getUser(String email) {
		return sysmUserRepository.findByEmail(email);
	}
	
	public int getUserMoney(SysmUser user) {
		user = getUser(user.getEmail());
		Optional<SysmUserInfo> obj = sysmUserInfoRepository.findById(user.getUserNo());
		if(obj.isPresent()) {
			SysmUserInfo userInfo = obj.get();
			return userInfo.getMoney();			
		}
		else return 0;
	}
	public void addUserMoney(SysmUser user, int money) {
		user = getUser(user.getEmail());
		Optional<SysmUserInfo> obj = sysmUserInfoRepository.findById(user.getUserNo());
		System.out.println("@@@ obj "+obj.toString());
		SysmUserInfo userInfo;
		if(obj.isPresent()) {
			userInfo = obj.get();
			userInfo.setMoney(userInfo.getMoney()+money);
		}
		else {
			System.out.println("user xx");
			userInfo = new SysmUserInfo();
			userInfo.setUno(user);
			userInfo.setMoney(money);
		}
		sysmUserInfoRepository.save(userInfo);
	}
	
}
