package com.etai.yto.manager;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.etai.yto.mapper.TestMapper;

@Component("testManager")
public class TestManager {

	@Resource
	private TestMapper testMapper;
	
	public List<Map<String, Object>> queryTestData(){
		List<Map<String, Object>>  list = testMapper.queryTestData();
		return  list;
	}

}
