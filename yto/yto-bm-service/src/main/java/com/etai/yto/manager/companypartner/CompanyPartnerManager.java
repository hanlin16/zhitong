package com.etai.yto.manager.companypartner;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.etai.yto.mapper.companypartner.CompanyPartnerMapper;
import com.etai.yto.model.companypartner.CompanyPartner;
import com.etai.yto.page.companypartner.CompanyPartnerPage;


@Component("companyPartnerManager")
public class CompanyPartnerManager {

	@Resource
	private CompanyPartnerMapper companyPartnerMapper;
	
	public List<CompanyPartner> queryCompanyPartnerPage(CompanyPartnerPage page){
		List<CompanyPartner>  list = companyPartnerMapper.queryCompanyPartnerPage(page);
		return list;
	}
	
	/**
	 * 查询合作伙伴总条数
	 */
	public int queryCompanyPartnerCount(CompanyPartnerPage page) {
		return companyPartnerMapper.queryCompanyPartnerCount(page);
	}

	/**
	 * 根据合作伙伴Id获取合作伙伴信息
	 */
	public CompanyPartner getCompanyPartnerById(Integer companyPartnerId) {
		return companyPartnerMapper.getCompanyPartnerById(companyPartnerId);
	}

	/**
	 * 根据合作伙伴Id编辑合作伙伴
	 */
	@Transactional(rollbackFor=Exception.class)
	public void companyPartnerEditById(CompanyPartner companyPartner) {
		companyPartnerMapper.companyPartnerEditById(companyPartner);
	}

	/**
	 * 合作伙伴添加
	 */
	@Transactional(rollbackFor=Exception.class)
	public void companyPartnerAdd(CompanyPartner companyPartner) {
		companyPartnerMapper.companyPartnerAdd(companyPartner);
	}

	/**
	 * 合作伙伴删除
	 */
	@Transactional(rollbackFor=Exception.class)
	public void companyPartnerDelete(Integer companyPartnerId) {
		companyPartnerMapper.companyPartnerDelete(companyPartnerId);
	}

	public CompanyPartner getCompanyPartnerByFullName(String fullName) {
		return companyPartnerMapper.getCompanyPartnerByFullName(fullName);
	}

	public CompanyPartner getCompanyPartnerByShortName(String fullName) {
		return companyPartnerMapper.getCompanyPartnerByShortName(fullName);
	}

}
