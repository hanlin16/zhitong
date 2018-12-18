package com.etai.yto.service.impl.city;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.etai.yto.api.CityMappingService;
import com.etai.yto.manager.city.CityMappingManager;
import com.etai.yto.model.city.CityMappingModel;
import com.etai.yto.page.PageResult;
import com.etai.yto.page.RemoteResult;
import com.etai.yto.page.city.CityMappingPage;
import com.etai.yto.utils.SendMailUtil;

@RestController
public class CityMappingServiceImpl implements CityMappingService{

private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CityMappingManager cityMappingManager;
	
	@Override
	public RemoteResult<PageResult<CityMappingModel>> queryAreaCityPage(@RequestBody CityMappingPage page) {
		RemoteResult<PageResult<CityMappingModel>> result = new RemoteResult<PageResult<CityMappingModel>>();
		PageResult<CityMappingModel> pageResult = new PageResult<CityMappingModel>();
		try {
			List<CityMappingModel> list = cityMappingManager.queryAreaCityPage(page);	
			
			pageResult.setDataList(list);
			result.setData(pageResult);
			result.setSuccess(true);
			return result;
		} catch (Exception e) {
			logger.error(SendMailUtil.printStackTraceToString(e));
			result.setErrorMsg("城市地区查询失败！");
			result.setSuccess(false);
			return result;
		}
	}

}
