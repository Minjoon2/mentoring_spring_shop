package com.clone.shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clone.shop.dao.SysmUserRepository;
import com.clone.shop.dto.SysmUser;

@Service
public class SysmUserServiceImpl implements SysmUserService{
	@Autowired
	SysmUserRepository sysmUserRepository;
	
	public void saveUser(SysmUser user) {
		sysmUserRepository.save(user);
	}
	public void deleteUserByEmail(String email) {
		sysmUserRepository.deleteByEmail(email);
	}
	public String updateUser(SysmUser user) {
		SysmUser obj = sysmUserRepository.findByEmail(user.getEmail());
		if(obj.getPassword().equals(user.getPassword()))
		{
			obj.setName(user.getName());
			sysmUserRepository.save(obj);
			return obj.getName();
		}
		return "none";
	}
	public SysmUser getUser(String email) {
		return sysmUserRepository.findByEmail(email);
	}
	
}
