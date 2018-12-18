package com.etai.yto.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.etai.yto.page.PageResult;
import com.etai.yto.page.RemoteResult;
import com.etai.yto.page.device.DeviceManage;
import com.etai.yto.page.device.DeviceManageDetail;
import com.etai.yto.page.device.DeviceManagePage;

public interface DeviceManageService {

	@RequestMapping(value = "/deviceManage/queryDeviceManageList", method = RequestMethod.POST)
	RemoteResult<PageResult<DeviceManage>> queryDeviceManagePage(DeviceManagePage page);

	@GetMapping("/deviceManage/getDeviceDetailById")
	RemoteResult<DeviceManageDetail> getDeviceDetailById(@RequestParam("deviceManageId") Integer deviceManageId);

}
