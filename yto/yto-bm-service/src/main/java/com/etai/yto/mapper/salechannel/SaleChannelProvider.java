package com.etai.yto.mapper.salechannel;

import org.apache.commons.lang3.StringUtils;

import com.etai.yto.mapper.BaseProvider;
import com.etai.yto.model.salechannel.SaleChannel;
import com.etai.yto.page.salechannel.SaleChannelPage;

public class SaleChannelProvider extends BaseProvider{

	public String querySaleChannelPage(SaleChannelPage page) {
		StringBuffer sb = new StringBuffer();
		sb.append("select "
				+ " part.ID, part.CODE, part.NAME, PARTNER_CODE, part.STATUS, REMARK, pro.SHORT_NAME as PARTNER_NAME, part.CREATE_TIME, " + 
				" part.CREATE_USER, part.UPDATE_TIME, part.UPDATE_USER "
				+ " from t_sale_channel part left join t_sale_partner pro on pro.CODE=part.PARTNER_CODE where 1=1 ");
		if(StringUtils.isNotEmpty(page.getPartnerCode())&& !"0".equals(page.getPartnerCode())) {
			sb.append(" and part.PARTNER_CODE = #{partnerCode}");
		}
		if(StringUtils.isNotEmpty(page.getStatus()) && !"2".equals(page.getStatus())) {
			sb.append(" and part.STATUS = #{status}");
		}
		if(StringUtils.isNotEmpty(page.getCode())) {
			sb.append(" and part.CODE = #{code}");
		}
		if (page.getPager()!=null && StringUtils.isNotEmpty(page.getPager().getMysqlQueryCondition())) {
			return queryWithPage(sb.toString(), page.getPager().getMysqlQueryCondition());
		}
		return sb.toString();
	}
	
	public String querySaleChannelCount(SaleChannelPage page) {
		StringBuffer sb = new StringBuffer();
		sb.append("select count(1) from t_sale_channel where 1=1 ");
		if(StringUtils.isNotEmpty(page.getPartnerCode())&& !"0".equals(page.getPartnerCode())) {
			sb.append(" and PARTNER_CODE = #{partnerCode}");
		}
		if(StringUtils.isNotEmpty(page.getStatus())&& !"2".equals(page.getStatus())) {
			sb.append(" and STATUS = #{status}");
		}
		if(StringUtils.isNotEmpty(page.getCode())) {
			sb.append(" and CODE = #{code}");
		}
		return sb.toString();
	}
	
	public String getSaleChannelById(Integer saleChannelId) {
		StringBuffer sb = new StringBuffer();
		sb.append("select "
				+ " part.ID, part.CODE, part.NAME, PARTNER_CODE, part.STATUS, REMARK, pro.SHORT_NAME as PARTNER_NAME, part.CREATE_TIME, " + 
				" part.CREATE_USER, part.UPDATE_TIME, part.UPDATE_USER "
				+ " from t_sale_channel part left join t_sale_partner pro on pro.CODE=part.PARTNER_CODE where part.ID=#{id} ");
		return sb.toString();
	}
	
	public String saleChannelEditById(SaleChannel saleChannel) {
		StringBuffer sb = new StringBuffer();
		sb.append(" update t_sale_channel "
				+ " set NAME = #{name}, "
				+ " STATUS=#{status}, REMARK = #{remark}, PARTNER_CODE=#{partnerCode}, "
				+ "  UPDATE_TIME=#{updateTime}, UPDATE_USER=#{updateUser} "
				+ " where id =#{id} ");
		return sb.toString();
	}
	
	public String saleChannelAdd(SaleChannel saleChannel) {
		StringBuffer sb = new StringBuffer();
		sb.append(" insert into t_sale_channel("
				+ " ID, CODE, NAME, PARTNER_CODE, STATUS, REMARK, CREATE_TIME, " + 
				" CREATE_USER) "
				+ " values (#{id}, #{code}, #{name}, #{partnerCode}, "
				+ " #{status}, #{remark}, #{createTime},#{createUser} ) ");
		return sb.toString();
	}
	
	public String getSaleChannelByPartnerCode(String partnerCode) {
		StringBuffer sb = new StringBuffer();
		sb.append("select "
				+ " part.ID, part.CODE, part.NAME, PARTNER_CODE, part.STATUS, REMARK, part.CREATE_TIME, " + 
				" part.CREATE_USER, part.UPDATE_TIME, part.UPDATE_USER "
				+ " from t_sale_channel part where part.PARTNER_CODE=#{partnerCode} ");
		return sb.toString();
	}
	
	public String getSaleChannelByName(String name) {
		StringBuffer sb = new StringBuffer();
		sb.append("select "
				+ " part.ID, part.CODE, part.NAME, PARTNER_CODE, part.STATUS, REMARK, part.CREATE_TIME, " + 
				" part.CREATE_USER, part.UPDATE_TIME, part.UPDATE_USER "
				+ " from t_sale_channel part where part.NAME=#{name} ");
		return sb.toString();
	}
}
