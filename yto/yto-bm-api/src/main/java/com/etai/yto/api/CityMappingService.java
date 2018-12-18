package com.etai.yto.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.etai.yto.model.city.CityMappingModel;
import com.etai.yto.page.PageResult;
import com.etai.yto.page.RemoteResult;
import com.etai.yto.page.city.CityMappingPage;

public interface CityMappingService {

	@RequestMapping(value = "/city/queryAreaCityPage", method = RequestMethod.POST)
	RemoteResult<PageResult<CityMappingModel>> queryAreaCityPage(CityMappingPage page);
}
