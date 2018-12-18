package com.etai.yto.mapper.integral;

import org.apache.commons.lang3.StringUtils;

import com.etai.yto.mapper.BaseProvider;
import com.etai.yto.page.integral.IntegralPage;

public class IntegralProvider extends BaseProvider {

	/**
	 * integral_id,transaction_time,transaction_item,item_type,order_no,amount,balance,remark
	 */
	/**
	 * 查询所有积分规则
	 * @return
	 */
	public String queryIntegralAll() {
		StringBuffer sb = new StringBuffer();
		sb.append("select "
				+ " rule_code,start_date,end_date,version_no,version_status,create_user,"
				+ "create_time,update_user,update_time"
				+ " from t_integral_rule");
		return sb.toString();
	}
	/**
	 * 查询所有定义规则
	 * @param ruleCode
	 * @return
	 */
	public String queryIntegralRuleDef(IntegralPage page) {
		StringBuffer sb = new StringBuffer();
		sb.append("select "
				+ "rule_code,serial_no,grade_from,grade_end,integral "
				+ "from t_integral_rule_def where 1=1 ");
		if(StringUtils.isNotBlank(page.getRuleCode())){
			sb.append(" and rule_code = #{ruleCode}");
		}
		if (page.getPager()!=null && StringUtils.isNotEmpty(page.getPager().getMysqlQueryCondition())) {
			return queryWithPage(sb.toString(), page.getPager().getMysqlQueryCondition());
		}
		return sb.toString();
	}
	/**
	 * 查询所有当事人积分
	 * @param ruleCode
	 * @return
	 */
	public String queryIntegralInfo(IntegralPage page) {
		StringBuffer sb = new StringBuffer();
		sb.append("select "
				+ "id,party_code,party_phone_no,integral_income,integral_usable,"
				+ "integral_payout,integral_lock "
				+ "from t_integral_info where 1=1 ");
		if(StringUtils.isNotBlank(page.getPartyCode())){
			sb.append(" and party_code = #{partyCode}");
		}
		if(StringUtils.isNotBlank(page.getPartyPhoneNo())){
			sb.append(" and party_phone_no = #{partyPhoneNo}");
		}
		if (page.getPager()!=null && StringUtils.isNotEmpty(page.getPager().getMysqlQueryCondition())) {
			return queryWithPage(sb.toString(), page.getPager().getMysqlQueryCondition());
		}
		return sb.toString();
	}
	/**
	 * 查询满足条件的当事人积分总数
	 * @param page
	 * @return
	 */
	public String queryIntegralInfoCount(IntegralPage page) {
		StringBuffer sb = new StringBuffer();
		sb.append("select count(*) "
				+ "from t_integral_info where 1=1 ");
		if(StringUtils.isNotBlank(page.getPartyCode())){
			sb.append(" and party_code = #{partyCode}");
		}
		if(StringUtils.isNotBlank(page.getPartyPhoneNo())){
			sb.append(" and party_phone_no = #{partyPhoneNo}");
		}
		if (page.getPager()!=null && StringUtils.isNotEmpty(page.getPager().getMysqlQueryCondition())) {
			return queryWithPage(sb.toString(), page.getPager().getMysqlQueryCondition());
		}
		return sb.toString();
	}
	
	/**
	 * 查询指定当事人积分明细
	 * @param ruleCode
	 * @return
	 */
	public String queryIntegralDetail(IntegralPage page) {
		StringBuffer sb = new StringBuffer();
		sb.append("select integral_id,transaction_time,transaction_item,"
				+ "item_type,order_no,amount,balance,remark "
				+ "from t_integral_detail where 1=1 ");
		if(StringUtils.isNotBlank(page.getTransactionItem())){
			sb.append(" and transaction_item = #{transactionItem}");
		}
		if(StringUtils.isNotBlank(page.getStartTime())){
			sb.append(" and transaction_time >= #{startTime}");
		}
		if(StringUtils.isNotBlank(page.getEndTime())){
			sb.append(" and transaction_time < #{endTime}");
		}
		if(StringUtils.isNotBlank(page.getRuleCode())){
			sb.append(" and integral_id = #{ruleCode}");
		}
		if (page.getPager()!=null && StringUtils.isNotEmpty(page.getPager().getMysqlQueryCondition())) {
			return queryWithPage(sb.toString(), page.getPager().getMysqlQueryCondition());
		}
		return sb.toString();
	}
	/**
	 * 查询满足条件的当事人积分明细交易总数
	 * @param page
	 * @return
	 */
	public String queryIntegralDetailCount(IntegralPage page) {
		StringBuffer sb = new StringBuffer();
		sb.append("select count(*) "
				+ "from t_integral_detail where 1=1 ");
		if(StringUtils.isNotBlank(page.getTransactionItem())){
			sb.append(" and transaction_item = #{transactionItem}");
		}
		if(StringUtils.isNotBlank(page.getStartTime())){
			sb.append(" and transaction_time >= #{startTime}");
		}
		if(StringUtils.isNotBlank(page.getStartTime())){
			sb.append(" and transaction_time < #{endTime}");
		}
		if(StringUtils.isNotBlank(page.getRuleCode())){
			sb.append(" and integral_id = #{ruleCode}");
		}
		if (page.getPager()!=null && StringUtils.isNotEmpty(page.getPager().getMysqlQueryCondition())) {
			return queryWithPage(sb.toString(), page.getPager().getMysqlQueryCondition());
		}
		return sb.toString();
	}
	/**
	 * 查询满足条件的当事人信息
	 * @param page
	 * @return
	 */
	public String queryIntegralPartyInfo(IntegralPage page) {
		StringBuffer sb = new StringBuffer();
		sb.append("select code,phone_no,name,email,create_time "
				+ "from t_party_info where 1=1 ");
		if(StringUtils.isNotBlank(page.getPartyCode())){
			sb.append(" and code = #{partyCode}");
		}
		return sb.toString();
	}
	
}
