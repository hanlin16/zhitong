package com.etai.yto.manager.city;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.etai.yto.mapper.city.CityMappingMapper;
import com.etai.yto.model.city.CityMappingModel;
import com.etai.yto.page.city.CityMappingPage;

@Component
public class CityMappingManager {
	
	@Resource
	CityMappingMapper cityMappingMapper;

	public List<CityMappingModel> queryAreaCityPage(CityMappingPage page) {
		List<CityMappingModel> list = cityMappingMapper.queryAreaCityPage(page);
		return list;
	}
}
