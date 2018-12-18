package com.etai.yto.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.etai.yto.api.DeviceConectService;
import com.etai.yto.manager.DeviceConectManager;
import com.etai.yto.manager.deviceinfo.DeviceInfoManager;
import com.etai.yto.model.device.DeviceApply;
import com.etai.yto.model.device.DeviceInfo;
import com.etai.yto.page.PageResult;
import com.etai.yto.page.RemoteResult;
import com.etai.yto.page.device.BindDeviceInfo;
import com.etai.yto.page.device.DeviceApplyModel;
import com.etai.yto.page.device.DeviceApplyPage;
import com.etai.yto.page.device.RalationDevicePage;
import com.etai.yto.utils.SendMailUtil;

@RestController
public class DeviceConectServiceImpl implements DeviceConectService{

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private DeviceConectManager deviceConectManager;
	
	@Autowired
	private DeviceInfoManager deviceInfoManager;
	
	/**
	 * 分页查询设备数据
	 */
	@Override
	public RemoteResult<PageResult<DeviceApplyModel>> queryDevicesListPage(@RequestBody DeviceApplyPage page) {
		RemoteResult<PageResult<DeviceApplyModel>> result = new RemoteResult<PageResult<DeviceApplyModel>>();
		PageResult<DeviceApplyModel> pageResult = new PageResult<DeviceApplyModel>();
		try {
			int count = deviceConectManager.queryDevicesCountPage(page);
			List<DeviceApplyModel> list = new ArrayList<>();
			if(count>0) {
				if(StringUtils.isNotBlank(page.getLimit())) {
					page.setRows(Integer.parseInt(page.getLimit()));
				}
				page.setRowCount(count);
				list = deviceConectManager.queryDevicesListPage(page);
				pageResult.setPage(page.getPager());
			}
			pageResult.setDataList(list);
			result.setData(pageResult);
			result.setSuccess(true);
			return result;
		} catch (Exception e) {
			logger.error(SendMailUtil.printStackTraceToString(e));
			result.setErrorMsg("关联设备数据请求错误！");
			result.setSuccess(false);
			return result;
		}
	}

	@Override
	public RemoteResult<DeviceApplyModel> getRelationDeviceInfo(@RequestParam("applyId")String applyId) {
		RemoteResult<DeviceApplyModel> result = new RemoteResult<DeviceApplyModel>();
		try {
			DeviceApplyModel data = deviceConectManager.getRalationDetailInfo(applyId);
			result.setData(data);
			result.setSuccess(true);
			return result;
		} catch (Exception e) {
			logger.error(SendMailUtil.printStackTraceToString(e));
			result.setErrorMsg("设备信息数据请求错误！");
			result.setSuccess(false);
			return result;
		}
	}

	/**
	 * 设备关联中
	 */
	@Override
	public RemoteResult<BindDeviceInfo> connectingDevice(@RequestBody RalationDevicePage param) {
		RemoteResult<BindDeviceInfo> result = new RemoteResult<BindDeviceInfo>();
		//对接运营商接口发起关联请求（或者线下发起），并将设备信息记录到设备表中（状态为不可用），更新保单状态（待绑定，关联中）
		try {
			DeviceApply device = new DeviceApply();
			device.setLinkStatus("2");
			device.setId(param.getApplyId());
			deviceConectManager.updateLinkStatus(device);
			result.setSuccess(true);
			return result;
		} catch (Exception e) {
			logger.error("关联中数据请求错误！", e);
			result.setErrorMsg("关联中数据请求错误！");
			result.setSuccess(false);
			return result;
		}
	}
	
	/**
	 * 关联设备物流信息
	 */
	@Override
	public RemoteResult<String> relationDevice(@RequestParam("applyId")String applyId,@RequestParam("deviceCode") String deviceCode,@RequestParam("logisticsCompany") String logisticsCompany,
			@RequestParam("logisticsNo") String logisticsNo) {
		RemoteResult<String> result = new RemoteResult<String>();
		try {
		    DeviceInfo device = deviceConectManager.queryDeviceInfo(deviceCode, 1);
		    if (device!=null) {
		    	result.setSuccess(false);
		    	result.setErrorMsg("当前设备号已经被使用");
		    	return result;
			}
		    DeviceInfo deviceInfo = new DeviceInfo();
		    deviceInfo.setLoCompany(logisticsCompany);
		    deviceInfo.setLoOrderNo(logisticsNo);
		    deviceInfo.setStatus("1");
		    deviceInfo.setName("test");
		    deviceInfo.setProviderCode("1234");
		    deviceInfo.setType("B");
		    deviceInfo.setDeviceCode(deviceCode);
		    deviceInfo.setDeviceApplyId(applyId);
		    DeviceApply deviceApply = new DeviceApply();
		    deviceApply.setLinkStatus("3");
		    deviceApply.setId(applyId);
			deviceConectManager.updateLinkStatus(deviceApply);
			deviceInfoManager.insertDeviceInfo(deviceInfo);
			result.setSuccess(true);
		} catch (Exception e) {
			result.setSuccess(false);
			result.setErrorMsg("设备关联数据请求错误！");
			logger.error("设备关联数据请求错误！", e);
		}
		return result;
	}

	@Override
	public RemoteResult<String> unrelationInfo(String applyId) {
		RemoteResult<String> result = new RemoteResult<String>();
		try {
			DeviceApply device = new DeviceApply();
			device.setLinkStatus("4");
			device.setId(applyId);
			deviceConectManager.updateLinkStatus(device);
			result.setSuccess(true);
		} catch (Exception e) {
			result.setSuccess(false);
			result.setErrorMsg("设备关联数据请求错误！");
			logger.error(SendMailUtil.printStackTraceToString(e));
		}
		return result;
	}
}
