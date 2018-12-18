package com.etai.yto.manager.province;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.etai.yto.mapper.province.ProvinceMapper;
import com.etai.yto.model.province.Province;
import com.etai.yto.page.province.ProvincePage;

@Component
public class ProvinceManager {
	
	@Resource
	ProvinceMapper provinceMapper;

	public int queryProvinceCount(ProvincePage page) {
		return provinceMapper.queryProvinceCount(page);
	}

	public List<Province> queryProvincePage(ProvincePage page) {
		List<Province> list = provinceMapper.queryProvincesPage(page);
		return list;
	}
}
