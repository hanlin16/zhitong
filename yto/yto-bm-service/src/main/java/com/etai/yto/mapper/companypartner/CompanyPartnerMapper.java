package com.etai.yto.mapper.companypartner;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import com.etai.yto.model.companypartner.CompanyPartner;
import com.etai.yto.page.companypartner.CompanyPartnerPage;

public interface CompanyPartnerMapper {

	/**
	 * 分页查询合作伙伴信息
	 */
	@SelectProvider(method="queryCompanyPartnerPage", type=CompanyPartnerProvider.class)
	public List<CompanyPartner> queryCompanyPartnerPage(CompanyPartnerPage page);

	/**
	 * 查询合作伙伴总条数
	 */
	@SelectProvider(method="queryCompanyPartnerCount", type=CompanyPartnerProvider.class)
	public int queryCompanyPartnerCount(CompanyPartnerPage page);

	/**
	 * 获取合作伙伴信息
	 */
	@SelectProvider(method="getCompanyPartnerById", type=CompanyPartnerProvider.class)
	public CompanyPartner getCompanyPartnerById(Integer companyPartnerId);

	/**
	 * 合作伙伴编辑
	 */
	@UpdateProvider(method="companyPartnerEditById", type=CompanyPartnerProvider.class)
	public void companyPartnerEditById(CompanyPartner companyPartner);

	/**
	 * 添加合作伙伴
	 */
	@InsertProvider(method="companyPartnerAdd", type=CompanyPartnerProvider.class)
	public void companyPartnerAdd(CompanyPartner companyPartner);

	/**
	 * 删除合作伙伴
	 */
	@Delete(" delete from t_sale_partner where id=#{companyPartnerId}")
	public void companyPartnerDelete(@Param("companyPartnerId") Integer companyPartnerId);

	/**
	 * 获取合作伙伴根据全名
	 */
	@SelectProvider(method="getCompanyPartnerByFullName", type=CompanyPartnerProvider.class)
	public CompanyPartner getCompanyPartnerByFullName(String fullName);

	/**
	 * 获取合作伙伴根据简称
	 */
	@SelectProvider(method="getCompanyPartnerByShortName", type=CompanyPartnerProvider.class)
	public CompanyPartner getCompanyPartnerByShortName(String shortName);


}
