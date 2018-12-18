package com.etai.yto.service.impl.deviceapply;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.etai.yto.api.DeviceApplyService;
import com.etai.yto.manager.deviceapply.DeviceApplyManager;
import com.etai.yto.model.device.DeviceApply;
import com.etai.yto.page.RemoteResult;
/**
 * 设备申领实现类
 * @author king
 *
 */
@RestController
public class DeviceapplyServiceImpl implements DeviceApplyService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private DeviceApplyManager deviceApplyManager;
	
	@Override
	public RemoteResult<DeviceApply> queryDeviceApplyInfoByBizNo(@RequestParam("bizNo") String bizNo) {
		
		RemoteResult<DeviceApply> remoteResult = new RemoteResult<>();
		try {
			DeviceApply deviceApplyInfo = deviceApplyManager.queryDeviceApplyInfoByBizNo(bizNo);
			if(deviceApplyInfo!=null){
				remoteResult.setData(deviceApplyInfo);
				remoteResult.setSuccess(true);
			}else {
				remoteResult.setSuccess(false);
			}
			return remoteResult;
			
		} catch (Exception e) {
			logger.error("查询设备申领信息失败",e);
			remoteResult.setErrorMsg("查询设备申领信息失败!");
			remoteResult.setSuccess(false);
			return remoteResult;
		}
	}

	@Override
	public RemoteResult<DeviceApply> deviceapplyUpdate(@RequestBody DeviceApply device) {
		RemoteResult<DeviceApply> remoteResult = new RemoteResult<>();
		try {
			deviceApplyManager.deviceapplyUpdate(device);
			remoteResult.setSuccess(true);
			return remoteResult;
		} catch (Exception e) {
			logger.error("更新设备申领信息失败",e);
			remoteResult.setErrorMsg("更新设备申领信息失败!");
			remoteResult.setSuccess(false);
			return remoteResult;
		}
	}

	@Override
	public RemoteResult<DeviceApply> deviceApplyAdd(@RequestBody DeviceApply device) {
		RemoteResult<DeviceApply> remoteResult = new RemoteResult<>();
		try {
			deviceApplyManager.deviceApplyAdd(device);
			remoteResult.setSuccess(true);
			return remoteResult;
		} catch (Exception e) {
			logger.error("添加设备申领信息失败",e);
			remoteResult.setErrorMsg("添加设备申领信息失败!");
			remoteResult.setSuccess(false);
			return remoteResult;
		}
	}

}
