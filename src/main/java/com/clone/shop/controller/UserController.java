package com.clone.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.clone.shop.dto.SysmUser;
import com.clone.shop.service.SysmUserService;

@RestController // 응답을 자동으로 json 형태로 변환
@RequestMapping(value = "user")
public class UserController {
	@Autowired
	SysmUserService sysmUserService;
	/*
	 	@PathVariable : 중괄호에 명시된 값을 변수로 받는다.
			- @RequestMapping("/user/{id}")
			- public String userInfo(@PathVariable("id") String id)
		@RequestParam : http 요청 파라미터를 변수로 받는다.
			- @RequestParam(value = "page", required = false, defaultValue = "1") Integer page
			- required 와 defaultValue 사용가능, required = true 인데 요청 필드가없으면 400 에러
			- 원시타입일 경우 어노테이션안붙여도 자동으로 알아먹음
		@ModelAttribute : http 요청 파라미터를 VO로 받는다.
			- public ModelAndView search(@ModelAttribute User user)
			- 레퍼런스타입일 경우 어노테이션안붙여도 자동으로 알아먹음. 즉 원시타입은 RequestParam으로, 객체타입은 ModelAttribute 로
			- 요청 파라미터가 많을경우 VO로 받는게 가독성이나 코드효율 상 좋다.
			- 이걸 커맨드 객체라고도 한다.
			- 메소드 레벨에서 annotation을 선언하면 ModelMap.addAttribute 와 같은 기능을 한다.
				ex. @ModelAttribute("users") 이면 ModelMap.addAttribute("users", 메소드의 리턴값)
		@RequestBody : HTTP 요청의 body 부분을 그대로 변수에 넣는다. XML, JSON 일떄 이것을 주로 사용한다.
			public String message(@RequestBody KakaobotRequest request)
			예를들어 json 구조처럼 KakaobotRequest.java 를 맞춘다면 파싱해서 잘 들어갈 것이다.
		@CookieValue : 요청의 쿠키정보를 가져온다
		@RequestHeader : 요청헤더 정보를 가져온다
		@RequestHeader("host") String host
	 */

	
	// TODO : REPOSITORY에서 일어나는 ERROR EXCEPTION 처리 어떻게 ?
	//	- 중복, 레코드 없음(NULL) 등등..
	
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
