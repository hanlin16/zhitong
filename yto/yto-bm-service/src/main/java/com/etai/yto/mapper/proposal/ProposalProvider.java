package com.etai.yto.mapper.proposal;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;

import com.etai.yto.mapper.BaseProvider;
import com.etai.yto.page.proposal.ProposalPage;

public class ProposalProvider extends BaseProvider {
	
	public String getProposalDetail(@Param("bizId") String bizId) {
		StringBuffer sb = new StringBuffer();
		sb.append(" SELECT zt_biz_id as bizId,total_credits,\n" + 
				" bi_premium,ci_premium,city_name, province_name,ins.NAME as insurer_name, " + 
				" vehicle_tax_premium,sum_premium,\n" + 
				" bi_start_date, bi_end_date,\n" + 
				" ci_start_date, ci_end_date,\n" + 
				" balance_ci_integral,balance_bi_integral,\n" + 
				" balance_ci_cost, balance_bi_cost,\n" + 
				" pay_time, pay_money,\n" + 
				" insurer_code, bi_proposal_no,\n" + 
				" bi_policy_no, ci_proposal_no,\n" + 
				" ci_policy_no " + 
				" FROM t_policy_info left join t_base_insurer ins on ins.CODE = insurer_code where zt_biz_id =#{bizId} ");
		return sb.toString();
	}
	
	public String getKindDetail(@Param("bizId") String bizId) {
		StringBuffer sb = new StringBuffer();
		sb.append(" SELECT zt_biz_id,risk_code,\n" + 
				" kind_code,kind_name,\n" + 
				" amount, premium,\n" + 
				" flag, deductible_flag\n" + 
				" FROM  t_policy_kind where zt_biz_id =#{bizId} ");
		return sb.toString();
	}
	
	public String updateProposalStatus(@Param("bizId") String bizId, @Param("isrelating") String isrelating, @Param("isbind") String isbind) {
		StringBuffer sb = new StringBuffer();
		sb.append(" update t_policy_info set relation_status = #{isrelating},"
				+ " bind_status=#{isbind} where zt_biz_id =#{bizId}");
		return sb.toString();
	}
	/**
	 * 查询保单信息
	 * @param page
	 * @return
	 * select p.zt_biz_id as bizId,p.bi_start_date,p.bi_end_date,p.bi_premium,p.accept_time,p.bi_policy_no,person.applicant_name AS applicant_name ,car.license_no AS license_no
from t_policy_info as p,t_policy_person AS person,t_policy_carinfo AS car where 1=1  and bi_policy_no = '1265105282016000004' 
AND person.applicant_name='测试' AND car.license_no='粤S52342'  and bi_start_date >='2015-07-12' AND p.zt_biz_id=person.zt_biz_id AND person.zt_biz_id=car.zt_biz_id
	 */
	
	public String queryProposalList(ProposalPage page){
		StringBuffer sb = new StringBuffer();
//		sb.append("select zt_biz_id as bizId,bi_start_date,bi_end_date,bi_premium,accept_time,bi_policy_no "
//				+ "from t_policy_info where 1=1 ");
		sb.append("select p.zt_biz_id as bizId,p.bi_start_date,p.bi_end_date,p.bi_premium,p.accept_time,"
				+ "p.bi_policy_no,person.applicant_name AS applicantName ,car.license_no AS licenseNo "
				+ "from t_policy_info as p,t_policy_person AS person,t_policy_carinfo AS car where 1=1 "
				+ "AND p.zt_biz_id=person.zt_biz_id AND person.zt_biz_id=car.zt_biz_id ");
		if(StringUtils.isNotBlank(page.getBiPolicyNo())){
			sb.append(" and bi_policy_no = #{biPolicyNo}");
		}
		if(StringUtils.isNotBlank(page.getStartTime())){
			sb.append(" and bi_start_date >= #{startTime}");
		}
		if(StringUtils.isNotBlank(page.getEndTime())){
			sb.append(" and bi_start_date < #{endTime}");
		}
		if(StringUtils.isNotBlank(page.getApplicantName())){
			sb.append(" and person.applicant_name = #{applicantName}");
		}
		if(StringUtils.isNotBlank(page.getLicenseNo())){
			sb.append(" and car.license_no = #{licenseNo}");
		}
		if (page.getPager()!=null && StringUtils.isNotEmpty(page.getPager().getMysqlQueryCondition())) {
			return queryWithPage(sb.toString(), page.getPager().getMysqlQueryCondition());
		}
		return sb.toString();
		
	}
	public String queryProposalCount(ProposalPage page){
		StringBuffer sb = new StringBuffer();
		sb.append("select count(*) "
				+ "from t_policy_info as p,t_policy_person AS person,t_policy_carinfo AS car where 1=1 "
				+ "AND p.zt_biz_id=person.zt_biz_id AND person.zt_biz_id=car.zt_biz_id ");
		if(StringUtils.isNotBlank(page.getBiPolicyNo())){
			sb.append(" and bi_policy_no = #{biPolicyNo}");
		}
		if(StringUtils.isNotBlank(page.getStartTime())){
			sb.append(" and bi_start_date >= #{startTime}");
		}
		if(StringUtils.isNotBlank(page.getEndTime())){
			sb.append(" and bi_start_date < #{endTime}");
		}
		if(StringUtils.isNotBlank(page.getApplicantName())){
			sb.append(" and person.applicant_name = #{applicantName}");
		}
		if(StringUtils.isNotBlank(page.getLicenseNo())){
			sb.append(" and car.license_no = #{licenseNo}");
		}
		return sb.toString();
		
	}
}
