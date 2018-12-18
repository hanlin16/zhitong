package com.etai.yto.controller.province;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.etai.yto.api.province.FeginProvinceService;
import com.etai.yto.interceptor.Auth;
import com.etai.yto.model.province.Province;
import com.etai.yto.page.PageResult;
import com.etai.yto.page.RemoteResult;
import com.etai.yto.page.province.ProvincePage;

@RestController
@RequestMapping("/province")
public class ProvinceController {

	@Autowired
	FeginProvinceService provinceService;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	/**
	 * 合作伙伴查询功能
	 */
	@PostMapping("/queryProvinceList")
	@Auth(verifyLogin=false)
	public PageResult<Province> queryProvinceList(ProvincePage page) {
		PageResult<Province> data = new PageResult<>();
		try {
			RemoteResult<PageResult<Province>> remoteResult = provinceService.queryProvincePage(page);
			if(remoteResult.isSuccess()) {
				data = remoteResult.getData();
				data.setState(true);
				return data;
			}else {
				data = remoteResult.getData();
				data.setState(false);
				data.setErrorMsg(remoteResult.getErrorMsg());
				return data;
			}
		} catch (Exception e) {
			logger.error("城市查询报错:",e);
			data.setState(false);
			data.setErrorMsg("城市查询报错");
			return data;
		}		
	}
}
