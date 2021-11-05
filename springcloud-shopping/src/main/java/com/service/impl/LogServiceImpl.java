package com.service.impl;


import org.springframework.stereotype.Component;

import com.service.LogService;

@Component
public class LogServiceImpl implements LogService {

	@Override
	public String getLog() {
		return "已请求到service";
	}
	
}
