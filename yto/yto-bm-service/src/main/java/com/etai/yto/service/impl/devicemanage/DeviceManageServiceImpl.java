package com.etai.yto.service.impl.devicemanage;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.etai.yto.api.DeviceManageService;
import com.etai.yto.manager.devicemanage.DeviceManageManager;
import com.etai.yto.model.device.DeviceApply;
import com.etai.yto.model.device.DeviceBind;
import com.etai.yto.model.device.DeviceInfo;
import com.etai.yto.page.PageResult;
import com.etai.yto.page.RemoteResult;
import com.etai.yto.page.device.DeviceManage;
import com.etai.yto.page.device.DeviceManageDetail;
import com.etai.yto.page.device.DeviceManagePage;
import com.etai.yto.page.policy.PolicyInfo;
import com.etai.yto.utils.SendMailUtil;

@RestController
public class DeviceManageServiceImpl implements DeviceManageService{

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private DeviceManageManager deviceManageManager;
	
	/**
	 * 分页查询设备数据
	 */
	@Override
	public RemoteResult<PageResult<DeviceManage>> queryDeviceManagePage(@RequestBody DeviceManagePage page) {
		RemoteResult<PageResult<DeviceManage>> result = new RemoteResult<PageResult<DeviceManage>>();
		PageResult<DeviceManage> pageResult = new PageResult<DeviceManage>();
		try {
			int count = deviceManageManager.queryDeviceManageCount(page);
			List<DeviceManage> list = new ArrayList<>();
			if(count>0) {
				if(page.getLimit()!=null) {
					page.setRows(page.getLimit());
				}
				page.setRowCount(count);
				list = deviceManageManager.queryDeviceManagePage(page);
				pageResult.setPage(page.getPager());
			}
			pageResult.setDataList(list);
			result.setData(pageResult);
			result.setSuccess(true);
			return result;
		} catch (Exception e) {
			logger.error(SendMailUtil.printStackTraceToString(e));
			result.setErrorMsg("设备管理数据请求错误！");
			result.setSuccess(false);
			return result;
		}
	}

	/**
	 * 根据设备Id获取设备数据
	 */
	@Override
	public RemoteResult<DeviceManageDetail> getDeviceDetailById(@RequestParam("deviceManageId") Integer deviceManageId) {
		RemoteResult<DeviceManageDetail> result = new RemoteResult<>();
		try {
			DeviceManageDetail detail = new DeviceManageDetail();
			DeviceInfo deviceInfo = deviceManageManager.getDeviceInfoById(deviceManageId);
			if(deviceInfo!=null) {
				detail.setDeviceInfo(deviceInfo);
				String deviceApplyId = deviceInfo.getDeviceApplyId();
				String deviceCode = deviceInfo.getDeviceCode();
				if(StringUtils.isNotBlank(deviceApplyId)) {
					DeviceApply deviceApply = deviceManageManager.getDeviceApplyById(deviceApplyId);
					if(deviceApply!=null) {
						detail.setDeviceApply(deviceApply);
					}
				}
				if(StringUtils.isNotBlank(deviceCode)) {
					List<DeviceBind> deviceBindList = deviceManageManager.getDeviceBindByCode(deviceCode);
					if(CollectionUtils.isNotEmpty(deviceBindList)) {
						detail.setDeviceBindList(deviceBindList);
						ArrayList<String> lisenseNoList = new ArrayList<>();
						for (DeviceBind deviceBind : deviceBindList) {
							String licenseNo = deviceBind.getLicenseNo();
							if(StringUtils.isNotBlank(licenseNo)) {
								lisenseNoList.add(licenseNo);
							}
						}
						if(lisenseNoList.size()>0) {
							List<PolicyInfo> policyInfoList = deviceManageManager.getPolicyInfoByLisenseNo(lisenseNoList);
							if(CollectionUtils.isNotEmpty(policyInfoList)) {
								detail.setPolicyList(policyInfoList);
							}
						}
					}
				}
			}
			result.setSuccess(true);
			result.setData(detail);
			return result;
		} catch (Exception e) {
			logger.error(SendMailUtil.printStackTraceToString(e));
			result.setErrorMsg("设备管理数据请求错误！");
			result.setSuccess(false);
			return result;
		}
	}
}
