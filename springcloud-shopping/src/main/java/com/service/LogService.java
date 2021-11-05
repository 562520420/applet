package com.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import com.service.impl.LogServiceImpl;

@FeignClient(value="spring-cloud-log",fallback=LogServiceImpl.class)
public interface LogService {
	@RequestMapping("/log/getLog")
	public String getLog();
}
