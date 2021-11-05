package com.controller;

import java.util.List;

import org.jboss.logging.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.entity.UserInfo;
import com.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private DiscoveryClient discoveryClient;
	@RequestMapping("/getUserInfo")
	public UserInfo getUserInfo(@RequestParam(required=true) int userId){
		//获取注册到eureka的服务
		List<ServiceInstance> instances=discoveryClient.getInstances("spring-cloud-user-1");
		ServiceInstance serviceInstance=instances.get(0);
		//获取该服务的ip
		String host=serviceInstance.getHost();
		//获取该服务的端口
		int port=serviceInstance.getPort();
	System.out.println(host+"////"+port);
		UserInfo userInfo=userService.getUserInfo(userId);
		if(userInfo==null){
			userInfo=new UserInfo();
			userInfo.setId(userId);
			userInfo.setPassword("123456");
			userInfo.setUsername("查无此人");
		}
		return userInfo;
	}
}
