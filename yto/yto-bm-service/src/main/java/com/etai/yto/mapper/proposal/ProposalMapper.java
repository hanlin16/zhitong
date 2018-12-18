package com.etai.yto.mapper.proposal;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import com.etai.yto.model.proposal.ProposalModel;
import com.etai.yto.model.underwriting.Kinds;
import com.etai.yto.page.proposal.ProposalPage;

public interface ProposalMapper {

	@SelectProvider(method="getProposalDetail", type=ProposalProvider.class)
	ProposalModel getProposalDetail(@Param("bizId") String bizId);

	@SelectProvider(method="getKindDetail", type=ProposalProvider.class)
	List<Kinds> getKindDetail(@Param("bizId") String bizId);

	@UpdateProvider(method="updateProposalStatus", type=ProposalProvider.class)
	void updateProposalStatus(@Param("bizId") String bizId, @Param("isrelating") String isrelating, @Param("isbind") String isbind);
	@SelectProvider(method="queryProposalList",type=ProposalProvider.class)
	List<ProposalModel> queryProposalList(ProposalPage proposalPage);
	@SelectProvider(method="queryProposalCount", type=ProposalProvider.class)
	public int queryProposalCount(ProposalPage page);
	
}
