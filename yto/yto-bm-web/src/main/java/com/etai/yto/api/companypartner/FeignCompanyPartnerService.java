package com.etai.yto.api.companypartner;

import org.springframework.cloud.openfeign.FeignClient;

import com.etai.yto.api.CompanyPartnerService;

@FeignClient("${service.application.name}")
public interface FeignCompanyPartnerService extends CompanyPartnerService{
	
}
