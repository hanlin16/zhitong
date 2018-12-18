package com.etai.yto.api;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.etai.yto.model.device.DeviceType;
import com.etai.yto.page.RemoteResult;

public interface DeviceTypeService {

	@RequestMapping(value = "/deviceType/getDeviceTypeList", method = RequestMethod.POST)
	RemoteResult<List<DeviceType>> getDeviceTypeList();

}
