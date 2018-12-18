package com.etai.yto.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.etai.yto.api.IntegralService;
import com.etai.yto.manager.IntegralManager;
import com.etai.yto.model.integral.IntegralDetailModel;
import com.etai.yto.model.integral.IntegralRuleDefModel;
import com.etai.yto.model.integral.IntegralRuleInfoModel;
import com.etai.yto.model.integral.IntegralRuleModel;
import com.etai.yto.page.PageResult;
import com.etai.yto.page.RemoteResult;
import com.etai.yto.page.integral.IntegralPage;
@RestController
public class IntegralServiceImpl implements IntegralService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private IntegralManager manager;
	
	@Override
	public RemoteResult<PageResult<IntegralRuleModel>> queryIntegralAll() {
		RemoteResult<PageResult<IntegralRuleModel>> result = new RemoteResult<>();
		PageResult<IntegralRuleModel> pageResult = new PageResult<>();
		try {
			List<IntegralRuleModel> list = manager.queryIntegralAll();
			System.out.println("查询数据库数据:"+list);
			pageResult.setDataList(list);
			result.setData(pageResult);
			result.setSuccess(true);
		} catch (Exception e) {
			logger.error("查询数据库所有积分异常:",e);
			result.setErrorMsg("数据库查询异常!");
		}
		System.out.println("查询的数据:"+result);
		return result;
	}

	@Override
	public RemoteResult<PageResult<IntegralRuleDefModel>> queryIntegralRuleDef(@RequestBody IntegralPage page) {
		RemoteResult<PageResult<IntegralRuleDefModel>> result = new RemoteResult<>();
		PageResult<IntegralRuleDefModel> pageResult = new PageResult<>();
		try {
			List<IntegralRuleDefModel> list = manager.queryIntegralRuleDef(page);
			System.out.println("查询数据库数据:"+list);
			pageResult.setDataList(list);
			result.setData(pageResult);
			result.setSuccess(true);
			
		} catch (Exception e) {
			logger.error("查询数据库所有积分异常:",e);
			result.setErrorMsg("数据库查询异常!");
		}
		return result;
	}

	@Override
	public RemoteResult<PageResult<IntegralRuleInfoModel>> queryIntegralInfo(@RequestBody IntegralPage page) {
		RemoteResult<PageResult<IntegralRuleInfoModel>> result = new RemoteResult<>();
		PageResult<IntegralRuleInfoModel> pageResult = new PageResult<>();
		try {
			List<IntegralRuleInfoModel> list = manager.queryIntegralInfo(page);
			int count = manager.queryIntegralInfoCount(page);
			if(count>0) {
				if(page.getLimit()!=null) {
					page.setRows(page.getLimit());
				}
				page.setRowCount(count);
			}
			pageResult.setDataList(list);
			pageResult.setPage(page.getPager());
			result.setData(pageResult);
			result.setSuccess(true);
		} catch (Exception e) {
			logger.error("查询数据库所有当事人积分异常:",e);
			result.setErrorMsg("数据库查询异常!");
		}
		return result;
	}

	@Override
	public RemoteResult<PageResult<IntegralDetailModel>> queryIntegralDetail(@RequestBody IntegralPage page) {
		logger.debug("查询定当事人积分明细条件:"+page);
		RemoteResult<PageResult<IntegralDetailModel>> result = new RemoteResult<>();
		PageResult<IntegralDetailModel> pageResult = new PageResult<>();
		try {
			logger.debug("查询定当事人积分明细条件2:"+page);
					List<IntegralDetailModel> list = manager.queryIntegralDetail(page);
					int count = manager.queryIntegralDetailCount(page);
					if(count>0){
						if(page.getLimit()!=null) {
							page.setRows(page.getLimit());
						}
						page.setRowCount(count);
					}
					pageResult.setDataList(list);
					pageResult.setPage(page.getPager());
					result.setData(pageResult);
					result.setSuccess(true);
				} catch (Exception e) {
					logger.error("查询数据库所有积分异常:",e);
					result.setErrorMsg("数据库查询异常!");
				}
		
		return result;
	}

}
