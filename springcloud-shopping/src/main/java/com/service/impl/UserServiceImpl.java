package com.service.impl;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.service.UserService;

@Component
public class UserServiceImpl implements UserService{

	@Override
	public JsonNode getUserInfo(int userId) throws Exception{
		ObjectMapper objectMapper = new ObjectMapper();
		String json = "{\"messge\":\"请求成功\"}";
		JsonNode jsonNode= objectMapper.readTree(json);
		return jsonNode;
	}

}
