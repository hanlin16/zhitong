package com.etai.yto.mapper.integral;

import java.util.List;

import org.apache.ibatis.annotations.SelectProvider;

import com.etai.yto.model.integral.IntegralDetailModel;
import com.etai.yto.model.integral.IntegralPartyInfoModel;
import com.etai.yto.model.integral.IntegralRuleDefModel;
import com.etai.yto.model.integral.IntegralRuleInfoModel;
import com.etai.yto.model.integral.IntegralRuleModel;
import com.etai.yto.page.integral.IntegralPage;

public interface IntegralMapper {

	/**
	 * 查询所有积分规则
	 * @return
	 */
	@SelectProvider(method="queryIntegralAll", type=IntegralProvider.class)
	List<IntegralRuleModel> queryIntegralAll();
	/**
	 * 查询所有定义规则
	 * @param ruleCode
	 * @return
	 */
	@SelectProvider(method="queryIntegralRuleDef", type=IntegralProvider.class)
	List<IntegralRuleDefModel> queryIntegralRuleDef(IntegralPage page);
	/**
	 * 查询所有当事人积分
	 * @param ruleCode
	 * @return
	 */
	@SelectProvider(method="queryIntegralInfo", type=IntegralProvider.class)
	List<IntegralRuleInfoModel> queryIntegralInfo(IntegralPage page);
	/**
	 * 查询满足条件的当事人积分总数
	 * @param page
	 * @return
	 */
	@SelectProvider(method="queryIntegralInfoCount",type=IntegralProvider.class)
	int queryIntegralInfoCount(IntegralPage page);
	
	/**
	 * 查询指定当事人积分明细
	 * @param page
	 * @return
	 */
	@SelectProvider(method="queryIntegralDetail", type=IntegralProvider.class)
	List<IntegralDetailModel> queryIntegralDetail(IntegralPage page);
	/**
	 * 查询满足条件的当事人积分明细交易总数
	 * @param page
	 * @return
	 */
	@SelectProvider(method="queryIntegralDetailCount",type=IntegralProvider.class)
	int queryIntegralDetailCount(IntegralPage page);
	/**
	 * 查询满足条件的当事人信息
	 * @param page
	 * @return
	 */
	@SelectProvider(method="queryIntegralPartyInfo",type=IntegralProvider.class)
	IntegralPartyInfoModel queryIntegralPartyInfo(IntegralPage page);
	
}
