package com.etai.yto.controller.integral;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.etai.yto.api.FeignIntegralService;
import com.etai.yto.model.integral.IntegralDetailModel;
import com.etai.yto.model.integral.IntegralRuleDefModel;
import com.etai.yto.model.integral.IntegralRuleInfoModel;
import com.etai.yto.model.integral.IntegralRuleModel;
import com.etai.yto.page.PageResult;
import com.etai.yto.page.RemoteResult;
import com.etai.yto.page.integral.IntegralPage;

@RestController
@RequestMapping("/integral")
public class IntegralController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private FeignIntegralService integralService;
	
	/**
	 * 查询所有积分规则
	 * @return
	 */
	@PostMapping("/queryIntegralAll")
	public PageResult<IntegralRuleModel> queryIntegralAll() {
		RemoteResult<PageResult<IntegralRuleModel>> remoteResult = integralService.queryIntegralAll();
		PageResult<IntegralRuleModel> result = remoteResult.getData();
		return result;
	}
	/**
	 * 查询所有定义规则
	 * @param ruleCode
	 * @return
	 */
	@RequestMapping("/queryIntegralRuleDef")
	public PageResult<IntegralRuleDefModel> queryIntegralRuleDef(IntegralPage page) {
		logger.debug("查询条件"+page);
//		System.out.println("查询条件"+request.getParameter("ruleCode"));
		RemoteResult<PageResult<IntegralRuleDefModel>> remoteResult = integralService.queryIntegralRuleDef(page);
		logger.debug("返回数据:"+remoteResult);
		return remoteResult.getData();
	}
	/**
	 * 查询所有当事人积分
	 * @param ruleCode
	 * @return
	 */
	@RequestMapping("/queryIntegralInfo")
	public PageResult<IntegralRuleInfoModel> queryIntegralInfo(IntegralPage page) {
		PageResult<IntegralRuleInfoModel> result = integralService.queryIntegralInfo(page).getData();
		if(result!=null)
		logger.debug("返回数据:"+result.getDataList());
		return result;
	}
	
	/**
	 * 查询指定当事人积分明细
	 * @param ruleCode
	 * @return
	 */
	@PostMapping("/queryIntegralDetail")
	public PageResult<IntegralDetailModel> queryIntegralDetail(IntegralPage page) {
		logger.debug("查询定当事人积分明细条件:"+page);
		String startTime = page.getStartTime();
		String endTime = page.getEndTime();
		if(StringUtils.isNotBlank(startTime)){
			page.setStartTime(startTime+" 00:00:00");
		}
		if(StringUtils.isNotBlank(endTime)){
			page.setEndTime(endTime+" 23:59:59");
		}
		PageResult<IntegralDetailModel> result = integralService.queryIntegralDetail(page).getData();
		logger.debug("返回数据:"+result.getDataList());
		return result;
	}
	
}
