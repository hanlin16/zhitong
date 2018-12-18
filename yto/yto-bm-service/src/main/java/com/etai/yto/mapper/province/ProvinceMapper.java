package com.etai.yto.mapper.province;

import java.util.List;

import org.apache.ibatis.annotations.SelectProvider;

import com.etai.yto.model.province.Province;
import com.etai.yto.page.province.ProvincePage;


public interface ProvinceMapper {

	/**
	 * 分页查询省份信息
	 */
	@SelectProvider(method="queryProvincesPage", type=ProvinceProvider.class)
	public List<Province> queryProvincesPage(ProvincePage page);

	/**
	 * 获取省份总条数信息
	 */
	@SelectProvider(method="queryProvinceCount", type=ProvinceProvider.class)
	public int queryProvinceCount(ProvincePage page);
	
}
