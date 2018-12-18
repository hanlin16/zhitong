package com.etai.yto.mapper.deviceapply;

import java.util.List;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import com.etai.yto.model.device.DeviceApply;
import com.etai.yto.page.device.DeviceApplyModel;
import com.etai.yto.page.device.DeviceApplyPage;

public interface DeviceApplyMapper {

	@SelectProvider(method="queryDevicesCountPage", type=DeviceApplyProvider.class)
	int queryDevicesCountPage(DeviceApplyPage page);

	@SelectProvider(method="queryDevicesListPage", type=DeviceApplyProvider.class)
	List<DeviceApplyModel> queryDevicesListPage(DeviceApplyPage page);
	
	@SelectProvider(method="getDeviceApplyByDeviceCode", type=DeviceApplyProvider.class)
	public DeviceApply getDeviceApplyByDeviceCode(String deviceCode);

	/**
	 * 设备申领修改
	 */
	@UpdateProvider(method="deviceapplyUpdate", type=DeviceApplyProvider.class)
	public void deviceapplyUpdate(DeviceApply device);

	/**
	 * 根据业务号查询申领信息
	 */
	@SelectProvider(method="queryDeviceApplyInfoByBizNo", type=DeviceApplyProvider.class)
	public DeviceApply queryDeviceApplyInfoByBizNo(String bizNo);

	/**
	 * 添加设备申领信息
	 */
	@InsertProvider(method="deviceApplyAdd", type=DeviceApplyProvider.class)
	public void deviceApplyAdd(DeviceApply device);

	@UpdateProvider(method="updateLinkStatus", type=DeviceApplyProvider.class)
	public void updateLinkStatus(DeviceApply device);

	@SelectProvider(method="getRalationDetailInfo", type=DeviceApplyProvider.class)
	DeviceApplyModel getRalationDetailInfo(String applyId);

	@SelectProvider(method="getDeviceApplyByActionCode", type=DeviceApplyProvider.class)
	List<DeviceApply> getDeviceApplyByActionCode(String actionCode);
	@SelectProvider(method="getDeviceApplyByChannelCode", type=DeviceApplyProvider.class)
	List<DeviceApply> getDeviceApplyByChannelCode(String channelCode);

}
