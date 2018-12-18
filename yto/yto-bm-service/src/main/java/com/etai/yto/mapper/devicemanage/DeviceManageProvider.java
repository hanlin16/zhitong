package com.etai.yto.mapper.devicemanage;

import java.util.ArrayList;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;

import com.etai.yto.mapper.BaseProvider;
import com.etai.yto.page.device.DeviceManagePage;

public class DeviceManageProvider extends BaseProvider{

	public String queryDeviceManagePage(DeviceManagePage page) {
		StringBuffer sb = new StringBuffer();
		sb.append(" SELECT info.ID,info.DEVICE_CODE,info.PROVIDER_CODE,\n" + 
				" provi.SHORT_NAME as PROVIDER_NAME,bind.BIND_TIME, " + 
				" bind.license_no,bind.party_phone_no,\n" + 
				" info.LO_COMPANY,info.LO_ORDER_NO,\n" + 
				" info.STATUS from t_device_info info " + 
				" LEFT JOIN t_device_provider provi on provi.CODE = info.PROVIDER_CODE\n" + 
				" LEFT JOIN t_device_bind bind on bind.DEVICE_CODE = info.DEVICE_CODE  where 1=1 ");
		if(StringUtils.isNotEmpty(page.getProviderCode()) && !"2".equals(page.getProviderCode())) {
			sb.append(" and pro.PROVIDER_CODE = #{providerCode}");
		}
		if(StringUtils.isNotEmpty(page.getDeviceCode())  && !"2".equals(page.getDeviceCode())) {
			sb.append(" and chann.device_code = #{deviceCode}");
		}
		if(StringUtils.isNotEmpty(page.getLicenseNo())) {
			sb.append(" and bind.LICENSE_NO = #{licenseNo}");
		}
		if(StringUtils.isNotEmpty(page.getPartyPhoneNo())) {
			sb.append(" and bind.party_phone_no >=#{partyPhoneNo}");
		}
		if(StringUtils.isNotEmpty(page.getBindBegintime())) {
			sb.append(" and bind.BIND_TIME >=#{bindBegintime}");
		}
		if(StringUtils.isNotEmpty(page.getBindEndtime())) {
			sb.append(" and bind.BIND_TIME <=#{bindEndtime}");
		}
		if (page.getPager()!=null && StringUtils.isNotEmpty(page.getPager().getMysqlQueryCondition())) {
			return queryWithPage(sb.toString(), page.getPager().getMysqlQueryCondition());
		}
		return sb.toString();
	}
	
	public String queryDeviceManageCount(DeviceManagePage page) {
		StringBuffer sb = new StringBuffer();
		sb.append(" SELECT count(1) from t_device_info info "
				+ "LEFT JOIN t_device_provider provi on provi.CODE = info.PROVIDER_CODE " + 
				" LEFT JOIN t_device_bind bind on bind.DEVICE_CODE = info.DEVICE_CODE where 1=1 ");
		if(StringUtils.isNotEmpty(page.getProviderCode()) && !"2".equals(page.getProviderCode())) {
			sb.append(" and info.PROVIDER_CODE = #{providerCode} ");
		}
		if(StringUtils.isNotEmpty(page.getDeviceCode())  && !"2".equals(page.getDeviceCode())) {
			sb.append(" and info.device_code = #{deviceCode}");
		}
		if(StringUtils.isNotEmpty(page.getLicenseNo())) {
			sb.append(" and bind.LICENSE_NO = #{licenseNo}");
		}
		if(StringUtils.isNotEmpty(page.getPartyPhoneNo())) {
			sb.append(" and bind.party_phone_no >=#{partyPhoneNo}");
		}
		if(StringUtils.isNotEmpty(page.getBindBegintime())) {
			sb.append(" and bind.BIND_TIME >=#{bindBegintime}");
		}
		if(StringUtils.isNotEmpty(page.getBindEndtime())) {
			sb.append(" and bind.BIND_TIME <=#{bindEndtime}");
		}
		return sb.toString();
	}
	
	public String getDeviceInfoById(Integer deviceManageId) {
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT info.ID,\n" + 
				"info.DEVICE_APPLY_ID,info.PROVIDER_CODE,\n" + 
				"info.DEVICE_CODE,info.TYPE,\n" + 
				"info.NAME,info.STATUS,\n" + 
				"info.LO_COMPANY,info.LO_ORDER_NO " + 
				" from t_device_info info  where info.ID=#{deviceManageId} ");
		return sb.toString();
	}
	
	public String getDeviceBindByCode(String deviceCode) {
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT bind.ID,\n" + 
				"bind.PARTY_CODE, bind.PARTY_PHONE_NO,\n" + 
				"bind.DEVICE_CODE, bind.LICENSE_NO,\n" + 
				"bind.BIND_STATUS, bind.BIND_TIME,\n" + 
				"bind.UNBIND_TIME\n" + 
				" from t_device_bind bind  where bind.device_code=#{deviceCode} ");
		return sb.toString();
	}
	
	public String getPolicyInfoByLisenseNo(@Param("lisenseNoList") ArrayList<String> lisenseNoList) {
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT info.zt_biz_id," + 
				"info.bi_policy_no,car.license_no,\n" + 
				"info.sum_premium,info.bi_start_date,\n" + 
				"info.bi_end_date,person.insured_name\n" + 
				" from t_policy_info info  " + 
				" LEFT JOIN t_policy_carinfo car on car.zt_biz_id = info.zt_biz_id " + 
				" LEFT JOIN t_policy_person person ON person.zt_biz_id = info.zt_biz_id "
				+ " where car.license_no in ( ");
		if(lisenseNoList!=null && !lisenseNoList.isEmpty()) {
			for (int i=0; i<lisenseNoList.size(); i++) {
				sb.append("'"+lisenseNoList.get(i)+"'");
				if(i!=lisenseNoList.size()-1) {
					sb.append(", ");
				}
			}
		}
		sb.append(" ) ");
		return sb.toString();
	}
	
	public String getDeviceApplyById(String applyId) {
		StringBuffer sb = new StringBuffer();
		sb.append(" SELECT  " + 
				"apply.ID,BIZ_NO,\n" + 
				"RECEIVER,ADDRESS,\n" + 
				"RECEIVER_PHONE_NO,CHANNEL_CODE, chann.NAME as channel_name," + 
				"ACTION_CODE,APPLY_TIME, " + 
				"APPLY_TYPE,LINK_STATUS " + 
				"from t_device_apply apply"
				+ " left join t_sale_channel chann on chann.code=apply.CHANNEL_CODE " + 
				" where apply.id = #{applyId}");
		return sb.toString();
	}	
	
}
