package com.etai.yto.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.etai.yto.model.companypartner.CompanyPartner;
import com.etai.yto.page.PageResult;
import com.etai.yto.page.RemoteResult;
import com.etai.yto.page.companypartner.CompanyPartnerPage;

public interface CompanyPartnerService {

	@RequestMapping(value = "/companyPartner/queryCompanyPartnerList", method = RequestMethod.POST)
	RemoteResult<PageResult<CompanyPartner>> queryCompanyPartnerPage(CompanyPartnerPage page);

	@GetMapping("/companyPartner/getCompanyPartnerById")
	RemoteResult<CompanyPartner> getCompanyPartnerById(@RequestParam("companyPartnerId") Integer companyPartnerId);

	@PostMapping("/companyPartner/companyPartnerEdit")
	RemoteResult<CompanyPartner> companyPartnerEditById(CompanyPartner companyPartner);

	@PostMapping("/companyPartner/companyPartnerAdd")
	RemoteResult<CompanyPartner> companyPartnerAdd(CompanyPartner companyPartner);

	@PostMapping("/companyPartner/companyPartnerDelete")
	RemoteResult<CompanyPartner> companyPartnerDelete(@RequestParam("companyPartnerId")Integer companyPartnerId);
	
	
}
