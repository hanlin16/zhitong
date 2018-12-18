package com.etai.yto.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.etai.yto.model.proposal.ProposalModel;
import com.etai.yto.page.PageResult;
import com.etai.yto.page.RemoteResult;
import com.etai.yto.page.proposal.ProposalPage;

public interface ProposalService {

	@PostMapping("/deviceConect/proposalInfo")
	RemoteResult<ProposalModel> getProposalDetail(@RequestParam("bizId") String bizId);
	@PostMapping("/deviceConect/proposalList")
	RemoteResult<PageResult<ProposalModel>> getProposalList(ProposalPage proposalPage);


}
