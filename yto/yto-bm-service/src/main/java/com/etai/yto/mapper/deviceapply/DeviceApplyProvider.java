package com.etai.yto.mapper.deviceapply;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.SQL;

import com.etai.yto.mapper.BaseProvider;
import com.etai.yto.model.device.DeviceApply;
import com.etai.yto.page.device.DeviceApplyPage;

public class DeviceApplyProvider extends BaseProvider{

	public String getDeviceApplyByDeviceCode(String deviceCode) {
		StringBuffer sb = new StringBuffer();
		sb.append(" SELECT apply.RECEIVER_PHONE_NO, " + 
				" apply.RECEIVER,apply.ID, apply.LINK_STATUS " + 
				" from t_device_apply apply\n" + 
				" INNER JOIN t_device_info info on info.DEVICE_APPLY_ID=apply.id and info.status=1 " + 
				" where info.DEVICE_CODE=#{deviceCode} ");
		return sb.toString();
	}
	
	public String deviceapplyUpdate(DeviceApply device) {
		StringBuffer sb = new StringBuffer();
		sb.append(" update t_device_apply set "
				+ " pay_status = #{payStatus} "
				+ "  where biz_no=#{bizNo} ");
		return sb.toString();
	}

	public String updateLinkStatus(DeviceApply device) {
		StringBuffer sb = new StringBuffer();
		sb.append(" update t_device_apply set "
				+ " LINK_STATUS = #{linkStatus} "
				+ "  where id=#{id} ");
		return sb.toString();
		
	}

	/**
	 * 根据业务号查询申领信息
	 */
	public String queryDeviceApplyInfoByBizNo(String bizNo) {
		StringBuffer sb = new StringBuffer();
		sb.append("select "
				+ " id, biz_no,receiver,address,receiver_phone_no,channel_code,"
				+ "action_code,apply_time,apply_type,link_status,pay_status "
				+ " from t_device_apply where biz_no=#{bizNo} ");
		return sb.toString();
	}

	/**
	 * 添加设备申领信息
	 */
	public String deviceApplyAdd(DeviceApply device) {
		System.out.println("设备信息:"+device);
		StringBuffer sb = new StringBuffer();
		sb.append(" insert into t_device_apply("
				+ " biz_no,receiver,address,receiver_phone_no,channel_code,"
				+ "action_code,apply_time,apply_type,link_status,pay_status ) "
				+ " values (#{bizNo}, #{receiver}, #{address}, #{receiverPhoneNo},#{channelCode}, "
				+ " #{actionCode}, now(), #{applyType}, #{linkStatus},#{payStatus})");
		return sb.toString();
	}
	
	public String queryDevicesCountPage(final DeviceApplyPage page) {
		
		return new SQL(){
			{
				SELECT("count(*) as total ");
				FROM("t_device_apply");
				if (StringUtils.isNotBlank(page.getReceiver())) {
					WHERE("receiver=#{receiver,jdbcType=VARCHAR}");
				}
				if (StringUtils.isNotBlank(page.getApplyType())) {
					WHERE("apply_type=#{applyType,jdbcType=VARCHAR}");
				}
				if (StringUtils.isNotBlank(page.getChannelCode())) {
					WHERE("channel_code=#{channelCode,jdbcType=VARCHAR}");
				}
				if (StringUtils.isNotBlank(page.getBizNo())) {
					WHERE("biz_no=#{bizNo,jdbcType=VARCHAR}");
				}
				if (page.getLinkStatus()!=null) {
					WHERE("link_status=#{linkStatus,jdbcType=VARCHAR}");
				}
				if (StringUtils.isNotBlank(page.getActionCode())) {
					WHERE("action_code=#{actionCode,jdbcType=VARCHAR}");
				}
				WHERE("pay_status = 2");
			}
		}.toString();
	}
	
	public String queryDevicesListPage(final DeviceApplyPage page) {
		String sqlString = new SQL(){
			{
				SELECT("a.id as applyId,biz_no as bizNo,receiver,address,receiver_phone_no as receiverPhoneNo,"
						+ "channel_code as channelCode,channel.name as channelName,action_code as actionCode,apply_time as applyTime,"
						+ "apply_type as applyType,link_status as linkStatus,c.bind_status bindStatus, b.DEVICE_CODE as deviceCode,b.id as deviceId ");
				FROM("t_device_apply a ");
				LEFT_OUTER_JOIN(" t_device_info b on a.id=b.DEVICE_APPLY_ID and b.STATUS = 1 ");
				LEFT_OUTER_JOIN(" t_device_bind c on b.DEVICE_CODE=c.DEVICE_CODE ");
				LEFT_OUTER_JOIN(" t_sale_channel channel on a.channel_code=channel.code ");
				if (StringUtils.isNotBlank(page.getReceiver())) {
					WHERE("receiver=#{receiver,jdbcType=VARCHAR}");
				}
				if (StringUtils.isNotBlank(page.getApplyType())) {
					WHERE("apply_type=#{applyType,jdbcType=VARCHAR}");
				}
				if (StringUtils.isNotBlank(page.getChannelCode())) {
					WHERE("channel_code=#{channelCode,jdbcType=VARCHAR}");
				}
				if (StringUtils.isNotBlank(page.getBizNo())) {
					WHERE("biz_no=#{bizNo,jdbcType=VARCHAR}");
				}
				if (page.getLinkStatus()!=null) {
					WHERE("link_status=#{linkStatus,jdbcType=VARCHAR}");
				}
				if (StringUtils.isNotBlank(page.getActionCode())) {
					WHERE("action_code=#{actionCode,jdbcType=VARCHAR}");
				}
				WHERE("pay_status = 2");
			}
		}.toString();
		sqlString += " order by applyTime desc ";
		if (page.getPager()!=null && StringUtils.isNotEmpty(page.getPager().getMysqlQueryCondition())) {
			return queryWithPage(sqlString, page.getPager().getMysqlQueryCondition());
		}
		return sqlString;
	}	
	
	public String getRalationDetailInfo(String applyId) {
		return new SQL(){
			{
				SELECT("a.id as applyId,receiver,address,receiver_phone_no as receiverPhoneNo,link_status as linkStatus,"
						+ "b.DEVICE_CODE as deviceCode,b.LO_COMPANY as companyName,b.LO_ORDER_NO as orderNo ");
				FROM("t_device_apply a "
						+ " left join t_device_info b on  a.id=b.DEVICE_APPLY_ID and b.status=1   ");
				WHERE("a.id=#{applyId,jdbcType=VARCHAR}");
			}
		}.toString();
	}
	
	public String getDeviceApplyByActionCode(String actionCode) {
		StringBuffer sb = new StringBuffer();
		sb.append("select "
				+ " id, biz_no,receiver,address,receiver_phone_no,channel_code,"
				+ " action_code,apply_time,apply_type,link_status,pay_status "
				+ " from t_device_apply where ACTION_CODE=#{actionCode} ");
		return sb.toString();
	}
	public String getDeviceApplyByChannelCode(String channelCode) {
		StringBuffer sb = new StringBuffer();
		sb.append("select "
				+ " id, biz_no,receiver,address,receiver_phone_no,channel_code,"
				+ " action_code,apply_time,apply_type,link_status,pay_status "
				+ " from t_device_apply where channel_code=#{channelCode} ");
		return sb.toString();
	}
}
