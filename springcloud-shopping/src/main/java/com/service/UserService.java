package com.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.databind.JsonNode;
import com.service.impl.UserServiceImpl;

@FeignClient(value="spring-cloud-user",fallback=UserServiceImpl.class)
public interface UserService {
	@RequestMapping("/user/getUserInfo")
	public JsonNode getUserInfo(@RequestParam("userId") int userId) throws Exception;
}
