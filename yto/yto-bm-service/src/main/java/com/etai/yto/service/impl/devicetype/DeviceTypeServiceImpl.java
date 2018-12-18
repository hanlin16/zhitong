package com.etai.yto.service.impl.devicetype;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.etai.yto.api.DeviceTypeService;
import com.etai.yto.manager.devicetype.DeviceTypeManager;
import com.etai.yto.model.device.DeviceType;
import com.etai.yto.page.RemoteResult;
import com.etai.yto.utils.SendMailUtil;

@RestController
public class DeviceTypeServiceImpl implements DeviceTypeService{

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	DeviceTypeManager deviceTypeManager;
	
	@Override
	public RemoteResult<List<DeviceType>> getDeviceTypeList(){
		RemoteResult<List<DeviceType>> result = new RemoteResult<>();
		try {
			List<DeviceType> deviceTypeList = deviceTypeManager.getDeviceTypeList();
			result.setData(deviceTypeList);
			result.setSuccess(true);
			return result;
		} catch (Exception e) {
			logger.error(SendMailUtil.printStackTraceToString(e));
			result.setErrorMsg("设备类型数据请求错误！");
			result.setSuccess(false);
			return result;
		}
	}
}
