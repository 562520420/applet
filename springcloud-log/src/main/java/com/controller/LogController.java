package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/log")
public class LogController {
	@Autowired
	private DiscoveryClient discoveryClient;
	@RequestMapping("/getLog")
	public String getLog(){
		//获取注册到eureka的服务
			List<ServiceInstance> instances=discoveryClient.getInstances("spring-cloud-log");
			ServiceInstance serviceInstance=instances.get(0);
			//获取该服务的ip
			String host=serviceInstance.getHost();
			//获取该服务的端口
			int port=serviceInstance.getPort();
			System.out.println(host+"////"+port);
			return host+"////"+port;
	}
}
