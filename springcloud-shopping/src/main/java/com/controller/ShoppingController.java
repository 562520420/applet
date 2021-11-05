package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.service.LogService;
import com.service.UserService;

@RestController
@RequestMapping("/shopping")
public class ShoppingController {
	@Autowired
	private UserService userService;
	@Autowired
	private LogService logService;
	@RequestMapping("/buy")
	public JsonNode buy(int userId,int number){
		JsonNode jsonNode=null;
		try {
			jsonNode=userService.getUserInfo(userId);
			String result=logService.getLog();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonNode;
	}
}
