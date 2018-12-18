package com.etai.yto.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.etai.yto.mapper.proposal.ProposalMapper;
import com.etai.yto.model.proposal.ProposalModel;
import com.etai.yto.model.underwriting.Kinds;
import com.etai.yto.page.proposal.ProposalPage;

@Component
public class ProposalManager {

	@Autowired
	ProposalMapper proposalMapper;

	public ProposalModel getProposalDetail(String bizId) {
		return proposalMapper.getProposalDetail(bizId);
	}

	public List<Kinds> getKindDetail(String bizId) {
		return proposalMapper.getKindDetail(bizId);
	}

	public void updateProposalStatus(String bizId, String isrelating, String isbind) {
		proposalMapper.updateProposalStatus(bizId, isrelating, isbind);
	}
	
	public List<ProposalModel> queryProposal(ProposalPage page){
		return proposalMapper.queryProposalList(page);
		
	}
	public int queryProposalCount(ProposalPage page) {
		return proposalMapper.queryProposalCount(page);
	}

}
