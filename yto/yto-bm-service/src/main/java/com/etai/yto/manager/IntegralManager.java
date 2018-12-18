package com.etai.yto.manager;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.etai.yto.mapper.integral.IntegralMapper;
import com.etai.yto.model.integral.IntegralDetailModel;
import com.etai.yto.model.integral.IntegralPartyInfoModel;
import com.etai.yto.model.integral.IntegralRuleDefModel;
import com.etai.yto.model.integral.IntegralRuleInfoModel;
import com.etai.yto.model.integral.IntegralRuleModel;
import com.etai.yto.page.integral.IntegralPage;

@Component("integralManager")
public class IntegralManager {

	@Resource
	private IntegralMapper integralMapper;
	
	/**
	 * 查询所有积分规则
	 * @return
	 */
	public List<IntegralRuleModel> queryIntegralAll() {
		return integralMapper.queryIntegralAll();
	}
	/**
	 * 查询所有定义规则
	 * @param ruleCode
	 * @return
	 */
	public List<IntegralRuleDefModel> queryIntegralRuleDef(IntegralPage page) {
		return integralMapper.queryIntegralRuleDef(page);
	}
	/**
	 * 查询所有当事人积分
	 * @param ruleCode
	 * @return
	 */
	public List<IntegralRuleInfoModel> queryIntegralInfo(IntegralPage page) {
		List<IntegralRuleInfoModel> list = integralMapper.queryIntegralInfo(page);
		for (IntegralRuleInfoModel model : list) {
			page.setPartyCode(model.getPartyCode());
			System.out.println("查询当事人条件:"+page);
			IntegralPartyInfoModel partyInfo = integralMapper.queryIntegralPartyInfo(page);
			System.out.println("查询当事人信息:"+partyInfo);
			model.setName(partyInfo.getName());
		}
		return list;
	}
	/**
	 * 查询满足条件的当事人积分总数
	 * @param page
	 * @return
	 */
	public int queryIntegralInfoCount(IntegralPage page) {
		return integralMapper.queryIntegralInfoCount(page);
	}
	
	/**
	 * 查询指定当事人积分明细
	 * @param ruleCode
	 * @return
	 */
	public List<IntegralDetailModel> queryIntegralDetail(IntegralPage page) {
		return integralMapper.queryIntegralDetail(page);
	}
	/**
	 * 查询满足条件的当事人积分明细交易总数
	 * @param page
	 * @return
	 */
	public int queryIntegralDetailCount(IntegralPage page) {
		return integralMapper.queryIntegralDetailCount(page);
	}
	/**
	 * 查询满足条件的当事人信息
	 * @param page
	 * @return
	 */
	public IntegralPartyInfoModel queryIntegralPartyInfo(IntegralPage page) {
		return integralMapper.queryIntegralPartyInfo(page);
	}
	
}
