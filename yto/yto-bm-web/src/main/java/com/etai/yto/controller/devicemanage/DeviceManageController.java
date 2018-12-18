package com.etai.yto.controller.devicemanage;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.etai.yto.api.devicemanage.FeignDeviceManageService;
import com.etai.yto.page.PageResult;
import com.etai.yto.page.RemoteResult;
import com.etai.yto.page.device.DeviceManage;
import com.etai.yto.page.device.DeviceManagePage;

@RestController
@RequestMapping("/deviceManage")
public class DeviceManageController {
	
	@Autowired
	FeignDeviceManageService deviceManageService;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	/**
	 * 设备管理查询功能
	 */
	@PostMapping("/queryDeviceManageList")
	public PageResult<DeviceManage> queryDeviceManageList(DeviceManagePage page) {
		PageResult<DeviceManage> data = new PageResult<>();
		try {
			RemoteResult<PageResult<DeviceManage>> remoteResult = deviceManageService.queryDeviceManagePage(page);
			if(remoteResult.isSuccess()) {
				data = remoteResult.getData();
				data.setState(true);
				return data;
			}else {
				data = remoteResult.getData()==null?data:remoteResult.getData();
				data.setState(false);
				data.setErrorMsg(remoteResult.getErrorMsg());
				return data;
			}
		} catch (Exception e) {
			logger.error("设备管理查询功能报错:",e);
			data.setState(false);
			data.setErrorMsg("设备管理查询功能报错");
			return data;
		}
	}	
	
	
	@InitBinder  
	public void initBinder(WebDataBinder binder) {  
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
	    dateFormat.setLenient(false);  
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));  
	}
	
}
