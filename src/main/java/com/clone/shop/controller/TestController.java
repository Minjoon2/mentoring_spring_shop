package com.clone.shop.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/test", method = RequestMethod.GET)
public class TestController {
	@RequestMapping("isTest")
	public String isTest() {
		System.out.println("isTest api 호출");
		return "api호출 테스트입니다.";
	}
}
