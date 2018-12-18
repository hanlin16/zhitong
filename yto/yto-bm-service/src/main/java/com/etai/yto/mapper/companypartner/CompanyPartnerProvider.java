package com.etai.yto.mapper.companypartner;

import org.apache.commons.lang3.StringUtils;

import com.etai.yto.mapper.BaseProvider;
import com.etai.yto.model.companypartner.CompanyPartner;
import com.etai.yto.page.companypartner.CompanyPartnerPage;

public class CompanyPartnerProvider extends BaseProvider{

	public String queryCompanyPartnerPage(CompanyPartnerPage page) {
		StringBuffer sb = new StringBuffer();
		sb.append("select "
				+ " ID, CODE, FULL_NAME, SHORT_NAME, LINKMAN, LINKMAN_PHONE_NO, LINKMAN_EMAIL, AREA_CODE, pro.province as AREA_NAME, CREATE_TIME, " + 
				" CREATE_USER, UPDATE_TIME, UPDATE_USER "
				+ " from t_sale_partner part left join t_base_province pro on pro.pro_id_gb=part.AREA_CODE where 1=1 ");
		if(StringUtils.isNotEmpty(page.getFullName())) {
			sb.append(" and FULL_NAME like #{fullName}");
		}
		if(StringUtils.isNotEmpty(page.getShortName())) {
			sb.append(" and SHORT_NAME like #{shortName}");
		}
		if(StringUtils.isNotEmpty(page.getCode())) {
			sb.append(" and CODE = #{code}");
		}
		if (page.getPager()!=null && StringUtils.isNotEmpty(page.getPager().getMysqlQueryCondition())) {
			return queryWithPage(sb.toString(), page.getPager().getMysqlQueryCondition());
		}
		return sb.toString();
	}
	
	public String queryCompanyPartnerCount(CompanyPartnerPage page) {
		StringBuffer sb = new StringBuffer();
		sb.append("select count(1) from t_sale_partner where 1=1 ");
		if(StringUtils.isNotEmpty(page.getFullName())) {
			sb.append(" and FULL_NAME like #{fullName}");
		}
		if(StringUtils.isNotEmpty(page.getShortName())) {
			sb.append(" and SHORT_NAME like #{shortName}");
		}
		if(StringUtils.isNotEmpty(page.getCode())) {
			sb.append(" and CODE = #{code}");
		}
		return sb.toString();
	}
	
	public String getCompanyPartnerById(Integer companyPartnerId) {
		StringBuffer sb = new StringBuffer();
		sb.append("select "
				+ " ID, CODE, FULL_NAME, SHORT_NAME, LINKMAN, LINKMAN_PHONE_NO, LINKMAN_EMAIL, AREA_CODE, pro.province as AREA_NAME, CREATE_TIME, " + 
				" CREATE_USER, UPDATE_TIME, UPDATE_USER "
				+ " from t_sale_partner part left join t_base_province pro on pro.pro_id_gb=part.AREA_CODE where ID=#{id} ");
		return sb.toString();
	}
	
	public String companyPartnerEditById(CompanyPartner companyPartner) {
		StringBuffer sb = new StringBuffer();
		sb.append(" update t_sale_partner "
				+ " set FULL_NAME = #{fullName}, "
				+ " SHORT_NAME = #{shortName}, LINKMAN=#{linkman}, LINKMAN_PHONE_NO = #{linkmanPhoneNo}, "
				+ " LINKMAN_EMAIL=#{linkmanEmail}, AREA_CODE=#{areaCode}, UPDATE_TIME=#{updateTime}, UPDATE_USER=#{updateUser} "
				+ "  where id =#{id}  ");
		return sb.toString();
	}
	
	public String companyPartnerAdd(CompanyPartner companyPartner) {
		StringBuffer sb = new StringBuffer();
		sb.append(" insert into t_sale_partner("
				+ " ID, CODE, FULL_NAME, SHORT_NAME, LINKMAN, LINKMAN_PHONE_NO, LINKMAN_EMAIL, AREA_CODE, CREATE_TIME, " + 
				" CREATE_USER) "
				+ " values (#{id}, #{code}, #{fullName}, #{shortName}, "
				+ " #{linkman}, #{linkmanPhoneNo}, #{linkmanEmail}, #{areaCode}, "
				+ " #{createTime},#{createUser} ) ");
		return sb.toString();
	}
	
	public String getCompanyPartnerByFullName(String fullName) {
		StringBuffer sb = new StringBuffer();
		sb.append("select "
				+ " ID, CODE, FULL_NAME, SHORT_NAME, LINKMAN, LINKMAN_PHONE_NO, LINKMAN_EMAIL, AREA_CODE, CREATE_TIME, " + 
				" CREATE_USER, UPDATE_TIME, UPDATE_USER "
				+ " from t_sale_partner part where FULL_NAME=#{fullName} ");
		return sb.toString();
	}
	
	public String getCompanyPartnerByShortName(String shortName) {
		StringBuffer sb = new StringBuffer();
		sb.append("select "
				+ " ID, CODE, FULL_NAME, SHORT_NAME, LINKMAN, LINKMAN_PHONE_NO, LINKMAN_EMAIL, AREA_CODE, CREATE_TIME, " + 
				" CREATE_USER, UPDATE_TIME, UPDATE_USER "
				+ " from t_sale_partner part  where SHORT_NAME=#{shortName} ");
		return sb.toString();
	}
}
