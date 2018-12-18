package com.etai.yto.service.impl.province;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.etai.yto.api.ProvinceService;
import com.etai.yto.manager.province.ProvinceManager;
import com.etai.yto.model.province.Province;
import com.etai.yto.page.PageResult;
import com.etai.yto.page.RemoteResult;
import com.etai.yto.page.province.ProvincePage;
import com.etai.yto.utils.SendMailUtil;

@RestController
public class ProvinceServiceImpl implements ProvinceService{

private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	ProvinceManager provinceManager;
	
	@Override
	public RemoteResult<PageResult<Province>> queryProvincePage(@RequestBody ProvincePage page) {
		RemoteResult<PageResult<Province>> result = new RemoteResult<PageResult<Province>>();
		PageResult<Province> pageResult = new PageResult<Province>();
		try {
			if(StringUtils.isNotBlank(page.getProvince())) {
				page.setProvince("%"+page.getProvince()+"%");
			}
			if(StringUtils.isNotBlank(page.getSpelling())) {
				page.setSpelling("%"+page.getSpelling()+"%");
			}
			int count = provinceManager.queryProvinceCount(page);
			List<Province> list = new ArrayList<>();
			if(count>0) {
				page.setRowCount(count);
				list = provinceManager.queryProvincePage(page);
				pageResult.setPage(page.getPager());
			}
			pageResult.setDataList(list);
			result.setData(pageResult);
			result.setSuccess(true);
			return result;
		} catch (Exception e) {
			logger.error(SendMailUtil.printStackTraceToString(e));
			result.setErrorMsg("省份数据请求错误！");
			result.setSuccess(false);
			return result;
		}
	}

}
