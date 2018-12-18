package com.etai.yto.mapper.devicemanage;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;

import com.etai.yto.model.device.DeviceApply;
import com.etai.yto.model.device.DeviceBind;
import com.etai.yto.model.device.DeviceInfo;
import com.etai.yto.page.device.DeviceManage;
import com.etai.yto.page.device.DeviceManagePage;
import com.etai.yto.page.policy.PolicyInfo;


public interface DeviceManageMapper {

	/**
	 * 分页查询活动信息
	 */
	@SelectProvider(method="queryDeviceManagePage", type=DeviceManageProvider.class)
	public List<DeviceManage> queryDeviceManagePage(DeviceManagePage page);

	/**
	 * 查询活动总条数
	 */
	@SelectProvider(method="queryDeviceManageCount", type=DeviceManageProvider.class)
	public int queryDeviceManageCount(DeviceManagePage page);

	/**
	 * 获取活动信息
	 */
	@SelectProvider(method="getDeviceInfoById", type=DeviceManageProvider.class)
	public DeviceInfo getDeviceInfoById(Integer saleActionId);

	/**
	 * 获取设备绑定信息
	 */
	@SelectProvider(method="getDeviceBindByCode", type=DeviceManageProvider.class)
	public List<DeviceBind> getDeviceBindByCode(String deviceCode);

	/**
	 * 获取保单信息
	 */
	@SelectProvider(method="getPolicyInfoByLisenseNo", type=DeviceManageProvider.class)
	public List<PolicyInfo> getPolicyInfoByLisenseNo(@Param("lisenseNoList")ArrayList<String> lisenseNoList);

	/**
	 * 获取设备申请信息
	 */
	@SelectProvider(method="getDeviceApplyById", type=DeviceManageProvider.class)
	public DeviceApply getDeviceApplyById(String deviceApplyId);

}
