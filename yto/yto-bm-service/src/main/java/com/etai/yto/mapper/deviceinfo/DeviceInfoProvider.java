package com.etai.yto.mapper.deviceinfo;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

import com.etai.yto.model.device.DeviceInfo;

public class DeviceInfoProvider {

	public String queryDeviceInfo(@Param("deviceCode")String deviceCode,@Param("status") int status) {
		SQL sql = new SQL();
		sql.SELECT(" ID,DEVICE_APPLY_ID,PROVIDER_CODE," + 
				" DEVICE_CODE,TYPE,NAME," + 
				" STATUS,LO_COMPANY,LO_ORDER_NO");
		sql.FROM(" t_device_info ");
		sql.WHERE(" DEVICE_CODE=#{deviceCode,jdbcType=VARCHAR}");
		sql.WHERE(" STATUS=#{status,jdbcType=VARCHAR}");
		return sql.toString();
	}
	
	public String insertDeviceInfo(DeviceInfo tempDevice) {
		return new SQL(){
			{
				INSERT_INTO("t_device_info");
				VALUES("DEVICE_APPLY_ID", "#{deviceApplyId,jdbcType=VARCHAR}");
				VALUES("STATUS", "#{status,jdbcType=INTEGER}");
				VALUES("PROVIDER_CODE", "#{providerCode,jdbcType=VARCHAR}");
				VALUES("DEVICE_CODE", "#{deviceCode,jdbcType=VARCHAR}");
				VALUES("TYPE", "#{type,jdbcType=VARCHAR}");
				VALUES("NAME", "#{name,jdbcType=VARCHAR}");
				VALUES("LO_COMPANY", "#{loCompany,jdbcType=VARCHAR}");
				VALUES("LO_ORDER_NO", "#{loOrderNo,jdbcType=VARCHAR}");
			}
		}.toString();
	}
}
