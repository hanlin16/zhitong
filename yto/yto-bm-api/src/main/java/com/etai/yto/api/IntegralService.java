package com.etai.yto.api;

import org.springframework.web.bind.annotation.PostMapping;

import com.etai.yto.model.integral.IntegralDetailModel;
import com.etai.yto.model.integral.IntegralRuleDefModel;
import com.etai.yto.model.integral.IntegralRuleInfoModel;
import com.etai.yto.model.integral.IntegralRuleModel;
import com.etai.yto.page.PageResult;
import com.etai.yto.page.RemoteResult;
import com.etai.yto.page.integral.IntegralPage;

public interface IntegralService {

	/**
	 * 查询所有积分规则
	 * @return
	 */
	@PostMapping("/integral/queryIntegralAll")
	public RemoteResult<PageResult<IntegralRuleModel>> queryIntegralAll();
	/**
	 * 查询所有定义规则
	 * @param ruleCode
	 * @return
	 */
	@PostMapping("/integral/queryIntegralRuleDef")
	public RemoteResult<PageResult<IntegralRuleDefModel>> queryIntegralRuleDef(IntegralPage page);
	/**
	 * 查询所有当事人积分
	 * @param ruleCode
	 * @return
	 */
	@PostMapping("/integral/queryIntegralInfo")
	public RemoteResult<PageResult<IntegralRuleInfoModel>> queryIntegralInfo(IntegralPage page);
	
	/**
	 * 查询指定当事人积分明细
	 * @param ruleCode
	 * @return
	 */
	@PostMapping("/integral/queryIntegralDetail")
	public RemoteResult<PageResult<IntegralDetailModel>>queryIntegralDetail(IntegralPage page);
	
}
