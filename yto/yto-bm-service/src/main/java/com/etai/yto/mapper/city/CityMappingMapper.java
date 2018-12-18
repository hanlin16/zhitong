package com.etai.yto.mapper.city;

import java.util.List;

import org.apache.ibatis.annotations.SelectProvider;

import com.etai.yto.model.city.CityMappingModel;
import com.etai.yto.page.city.CityMappingPage;

public interface CityMappingMapper {

	/**
	 * 分页查询城市信息
	 */
	@SelectProvider(method="queryAreaCityPage", type=CityMappingProvider.class)
	public List<CityMappingModel> queryAreaCityPage(CityMappingPage page);

}
