package com.etai.yto.api;

import org.springframework.cloud.openfeign.FeignClient;

import com.etai.yto.api.ProposalService;

@FeignClient("${service.application.name}")
public interface FeignProposalService extends ProposalService{


}
