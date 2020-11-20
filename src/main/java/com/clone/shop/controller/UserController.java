package com.clone.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.clone.shop.dto.SysmUser;
import com.clone.shop.service.SysmUserService;

@RestController // ������ �ڵ����� json ���·� ��ȯ
@RequestMapping(value = "user")
public class UserController {
	@Autowired
	SysmUserService sysmUserService;
	/*
	 	@PathVariable : �߰�ȣ�� ��õ� ���� ������ �޴´�.
			- @RequestMapping("/user/{id}")
			- public String userInfo(@PathVariable("id") String id)
		@RequestParam : http ��û �Ķ���͸� ������ �޴´�.
			- @RequestParam(value = "page", required = false, defaultValue = "1") Integer page
			- required �� defaultValue ��밡��, required = true �ε� ��û �ʵ尡������ 400 ����
			- ����Ÿ���� ��� ������̼ǾȺٿ��� �ڵ����� �˾Ƹ���
		@ModelAttribute : http ��û �Ķ���͸� VO�� �޴´�.
			- public ModelAndView search(@ModelAttribute User user)
			- ���۷���Ÿ���� ��� ������̼ǾȺٿ��� �ڵ����� �˾Ƹ���. �� ����Ÿ���� RequestParam����, ��üŸ���� ModelAttribute ��
			- ��û �Ķ���Ͱ� ������� VO�� �޴°� �������̳� �ڵ�ȿ�� �� ����.
			- �̰� Ŀ�ǵ� ��ü��� �Ѵ�.
			- �޼ҵ� �������� annotation�� �����ϸ� ModelMap.addAttribute �� ���� ����� �Ѵ�.
				ex. @ModelAttribute("users") �̸� ModelMap.addAttribute("users", �޼ҵ��� ���ϰ�)
		@RequestBody : HTTP ��û�� body �κ��� �״�� ������ �ִ´�. XML, JSON �ϋ� �̰��� �ַ� ����Ѵ�.
			public String message(@RequestBody KakaobotRequest request)
			������� json ����ó�� KakaobotRequest.java �� ����ٸ� �Ľ��ؼ� �� �� ���̴�.
		@CookieValue : ��û�� ��Ű������ �����´�
		@RequestHeader : ��û��� ������ �����´�
		@RequestHeader("host") String host
	 */

	
	// TODO : REPOSITORY���� �Ͼ�� ERROR EXCEPTION ó�� ��� ?
	//	- �ߺ�, ���ڵ� ����(NULL) ���..
	
	@PostMapping(value = "save")
	public String saveUser(@ModelAttribute SysmUser user) {
		System.out.println(user.toString());
		sysmUserService.saveUser(user);
		return "save success!";
	}
	
	@PostMapping(value = "delete")
	public String deleteUser(@ModelAttribute SysmUser user) {
		System.out.println(user.getEmail());
		sysmUserService.deleteUserByEmail(user.getEmail());
		return "delete success!";
	}
	
	@PostMapping(value = "update")
	public String updateUser(@ModelAttribute SysmUser user) {
		System.out.println(user.toString());
		return sysmUserService.updateUser(user);
	}
	
	@PostMapping(value ="get")
	public SysmUser getUser(String email) {
		System.out.println(email);
		return sysmUserService.getUser(email);
	}
}
