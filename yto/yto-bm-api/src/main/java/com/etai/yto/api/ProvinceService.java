package com.etai.yto.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.etai.yto.model.province.Province;
import com.etai.yto.page.PageResult;
import com.etai.yto.page.RemoteResult;
import com.etai.yto.page.province.ProvincePage;

public interface ProvinceService {

	@RequestMapping(value = "/province/queryProvinceList", method = RequestMethod.POST)
	RemoteResult<PageResult<Province>> queryProvincePage(ProvincePage page);
	
	
}
