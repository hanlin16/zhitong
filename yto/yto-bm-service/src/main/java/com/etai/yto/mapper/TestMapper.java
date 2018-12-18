package com.etai.yto.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;
public interface TestMapper {
	@Select("select '1' as id,'张三' as test_name from dual")
	public List<Map<String, Object>> queryTestData();
}
