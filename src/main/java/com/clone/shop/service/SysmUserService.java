package com.clone.shop.service;

import com.clone.shop.dto.SysmUser;

public interface SysmUserService {
	public void saveUser(SysmUser user);
	public void deleteUserByEmail(String email);
	public String updateUser(SysmUser name);
	public SysmUser getUser(String email);
}
