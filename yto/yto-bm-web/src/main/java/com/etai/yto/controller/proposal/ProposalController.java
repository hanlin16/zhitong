package com.etai.yto.controller.proposal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.etai.yto.api.FeignProposalService;
import com.etai.yto.model.proposal.ProposalModel;
import com.etai.yto.page.PageResult;
import com.etai.yto.page.RemoteResult;
import com.etai.yto.page.proposal.ProposalPage;

@RestController
@RequestMapping("/proposal")
public class ProposalController {

private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private FeignProposalService proposalService;
	
	/**
	 * 查询保单
	 * @return
	 */
	@PostMapping("/queryProposalLit")
	public PageResult<ProposalModel> queryProposalLit(ProposalPage proposalPage) {
		logger.debug("查询保单开始");
		RemoteResult<PageResult<ProposalModel>> remoteResult = proposalService.getProposalList(proposalPage);
		logger.debug("查询保单结束:"+remoteResult);
		PageResult<ProposalModel> result = remoteResult.getData();
		logger.debug("查询保单结束:"+result.getDataList());
		return result;
	}
	
}
