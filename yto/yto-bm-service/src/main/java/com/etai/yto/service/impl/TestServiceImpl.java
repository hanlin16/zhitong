package com.etai.yto.service.impl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.etai.yto.api.TestService;
import com.etai.yto.manager.TestManager;

@RestController
public class TestServiceImpl implements TestService {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private TestManager testManager;
	@Override
	public List<Map<String, Object>> queryTestData() {
		try {
			return  testManager.queryTestData();
		} catch (Exception e) {
			logger.error(e.getMessage());
			return null;
		}
	}	
}
