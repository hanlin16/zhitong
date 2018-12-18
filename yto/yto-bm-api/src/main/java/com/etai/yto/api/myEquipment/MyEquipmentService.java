package com.etai.yto.api.myEquipment;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.etai.yto.model.device.DeviceApply;
import com.etai.yto.page.RemoteResult;
import com.etai.yto.page.myequipment.MyEquipmentBindPage;

public interface MyEquipmentService {

	@RequestMapping(value = "/myEquipment/getUserInfoByDeviceCode", method = RequestMethod.POST)
	public RemoteResult<DeviceApply> getUserInfoByDeviceCode(@RequestParam("deviceCode")String deviceCode);
	
	@RequestMapping(value = "/myEquipment/bindDeviceUser", method = RequestMethod.POST)
	RemoteResult<String> bindDeviceUser(MyEquipmentBindPage myEquipmentBind);
}
