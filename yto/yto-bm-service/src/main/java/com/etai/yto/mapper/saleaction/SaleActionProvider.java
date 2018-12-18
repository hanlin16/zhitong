package com.etai.yto.mapper.saleaction;

import org.apache.commons.lang3.StringUtils;

import com.etai.yto.mapper.BaseProvider;
import com.etai.yto.model.saleaction.SaleAction;
import com.etai.yto.page.saleaction.SaleActionPage;

public class SaleActionProvider extends BaseProvider{

	public String querySaleActionPage(SaleActionPage page) {
		StringBuffer sb = new StringBuffer();
		sb.append("select action.ID, action.CODE, CHANNEL_CODE, chann.name CHANNEL_NAME,pro.SHORT_NAME as PARTNER_NAME, START_TIME," + 
				" END_TIME, DEVICE_APPLY_URL," + 
				" action.REMARK, action.CREATE_TIME, action.CREATE_USER, action.UPDATE_TIME, action.UPDATE_USER " + 
				" from t_sale_action action "
				+ " left join t_sale_channel chann on action.CHANNEL_CODE=chann.CODE "
				+ " left join t_sale_partner pro on pro.CODE=chann.PARTNER_CODE where 1=1 ");
		if(StringUtils.isNotEmpty(page.getPartnerCode()) && !"2".equals(page.getPartnerCode())) {
			sb.append(" and pro.code = #{partnerCode}");
		}
		if(StringUtils.isNotEmpty(page.getChannelCode())  && !"2".equals(page.getChannelCode())) {
			sb.append(" and chann.code = #{channelCode}");
		}
		if(StringUtils.isNotEmpty(page.getCode())) {
			sb.append(" and action.CODE = #{code}");
		}
		if(StringUtils.isNotEmpty(page.getStartEffectTime())) {
			sb.append(" and action.START_TIME >=#{startEffectTime}");
		}
		if(StringUtils.isNotEmpty(page.getEndEffectTime())) {
			sb.append(" and action.START_TIME <=#{endEffectTime}");
		}
		if(StringUtils.isNotEmpty(page.getStartInvalidTime())) {
			sb.append(" and action.END_TIME >=#{startInvalidTime}");
		}
		if(StringUtils.isNotEmpty(page.getEndInvalidTime())) {
			sb.append(" and action.END_TIME <=#{endInvalidTime}");
		}
		sb.append("order by action.CREATE_TIME desc ");
		if (page.getPager()!=null && StringUtils.isNotEmpty(page.getPager().getMysqlQueryCondition())) {
			return queryWithPage(sb.toString(), page.getPager().getMysqlQueryCondition());
		}
		return sb.toString();
	}
	
	public String querySaleActionCount(SaleActionPage page) {
		StringBuffer sb = new StringBuffer();
		sb.append("select count(1) from t_sale_action action "
				+ " left join t_sale_channel chann on action.CHANNEL_CODE=chann.CODE " + 
				" left join t_sale_partner pro on pro.CODE=chann.PARTNER_CODE where 1=1 ");
		if(StringUtils.isNotEmpty(page.getPartnerCode()) && !"2".equals(page.getPartnerCode())) {
			sb.append(" and pro.code = #{partnerCode}");
		}
		if(StringUtils.isNotEmpty(page.getChannelCode())&& !"2".equals(page.getChannelCode())) {
			sb.append(" and chann.code = #{channelCode}");
		}
		if(StringUtils.isNotEmpty(page.getCode())) {
			sb.append(" and action.CODE = #{code}");
		}
		if(StringUtils.isNotEmpty(page.getStartEffectTime())) {
			sb.append(" and action.START_TIME >=#{startEffectTime}");
		}
		if(StringUtils.isNotEmpty(page.getEndEffectTime())) {
			sb.append(" and action.START_TIME <=#{endEffectTime}");
		}
		if(StringUtils.isNotEmpty(page.getStartInvalidTime())) {
			sb.append(" and action.END_TIME >=#{startInvalidTime}");
		}
		if(StringUtils.isNotEmpty(page.getEndInvalidTime())) {
			sb.append(" and action.END_TIME <=#{endInvalidTime}");
		}
		return sb.toString();
	}
	
	public String getSaleActionById(Integer saleActionId) {
		StringBuffer sb = new StringBuffer();
		sb.append("select "
				+ " action.ID, action.CODE, action.CHANNEL_CODE, chann.NAME as CHANNEL_NAME, action.DEVICE_TYPE, action.START_TIME, " + 
				" action.END_TIME, action.DEVICE_APPLY_URL, " + 
				" action.REMARK, action.CREATE_TIME, action.CREATE_USER, action.UPDATE_TIME, action.UPDATE_USER "
				+ " from t_sale_action action left join t_sale_channel chann on action.CHANNEL_CODE=chann.CODE " + 
				" left join t_sale_partner pro on pro.CODE=chann.PARTNER_CODE where action.ID=#{id} ");
		return sb.toString();
	}
	
	public String saleActionEditById(SaleAction saleAction) {
		StringBuffer sb = new StringBuffer();
		sb.append(" update t_sale_action "
				+ " set DEVICE_TYPE=#{deviceType}, CHANNEL_CODE=#{channelCode}, REMARK = #{remark}, "
				+ "  UPDATE_TIME=#{updateTime}, UPDATE_USER=#{updateUser},DEVICE_APPLY_URL=#{deviceApplyUrl}, START_TIME=#{startTime}  "
				+ "  ,END_TIME=#{endTime} where id =#{id}  ");
		return sb.toString();
	}
	
	public String saleActionAdd(SaleAction saleAction) {
		StringBuffer sb = new StringBuffer();
		sb.append(" insert into t_sale_action("
				+ " ID, CODE, CHANNEL_CODE, DEVICE_TYPE, START_TIME, END_TIME, DEVICE_APPLY_URL, REMARK, CREATE_TIME, " + 
				" CREATE_USER) "
				+ " values (#{id}, #{code}, #{channelCode}, #{deviceType}, #{startTime}, "
				+ " #{endTime},#{deviceApplyUrl}, #{remark}, #{createTime},#{createUser} ) ");
		return sb.toString();
	}
	
	public String getSaleActionByCode(String actionCode) {
		StringBuffer sb = new StringBuffer();
		sb.append("select "
				+ " action.ID, action.CODE, action.CHANNEL_CODE, action.START_TIME, " + 
				" action.END_TIME, action.DEVICE_APPLY_URL, " + 
				" action.REMARK, action.CREATE_TIME, action.CREATE_USER, action.UPDATE_TIME, action.UPDATE_USER "
				+ " from t_sale_action action left join t_sale_channel chann on action.CHANNEL_CODE=chann.CODE " + 
				" left join t_sale_partner pro on pro.CODE=chann.PARTNER_CODE where action.CODE=#{actionCode} ");
		return sb.toString();
	}
	
	public String getSaleActionByChannlCode(String channelCode) {
		StringBuffer sb = new StringBuffer();
		sb.append("select "
				+ " action.ID, action.CODE, action.CHANNEL_CODE, action.START_TIME, " + 
				" action.END_TIME, action.DEVICE_APPLY_URL, " + 
				" action.REMARK, action.CREATE_TIME, action.CREATE_USER, action.UPDATE_TIME, action.UPDATE_USER "
				+ " from t_sale_action action  where action.CHANNEL_CODE=#{channelCode} ");
		return sb.toString();
	}
}
