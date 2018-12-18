package com.etai.yto.service.impl.saleaction;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.etai.yto.api.SaleActionService;
import com.etai.yto.manager.deviceapply.DeviceApplyManager;
import com.etai.yto.manager.saleaction.SaleActionManager;
import com.etai.yto.model.device.DeviceApply;
import com.etai.yto.model.saleaction.SaleAction;
import com.etai.yto.page.PageResult;
import com.etai.yto.page.RemoteResult;
import com.etai.yto.page.saleaction.SaleActionPage;
import com.etai.yto.utils.SendMailUtil;

@RestController
public class SaleActionServiceImpl implements SaleActionService{

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private SaleActionManager saleActionManager;
	
	@Autowired
	DeviceApplyManager deviceApplyManager;
	
	@Value("${deviceApplyUrlPrefix}")
	String deviceApplyUrl;
	
	/**
	 * 分页查询活动数据
	 */
	@Override
	public RemoteResult<PageResult<SaleAction>> querySaleActionPage(@RequestBody SaleActionPage page) {
		RemoteResult<PageResult<SaleAction>> result = new RemoteResult<PageResult<SaleAction>>();
		PageResult<SaleAction> pageResult = new PageResult<SaleAction>();
		try {
			int count = saleActionManager.querySaleActionCount(page);
			List<SaleAction> list = new ArrayList<>();
			if(count>0) {
				if(page.getLimit()!=null) {
					page.setRows(page.getLimit());
				}
				page.setRowCount(count);
				list = saleActionManager.querySaleActionPage(page);
				pageResult.setPage(page.getPager());
			}
			pageResult.setDataList(list);
			result.setData(pageResult);
			result.setSuccess(true);
			return result;
		} catch (Exception e) {
			logger.error(SendMailUtil.printStackTraceToString(e));
			result.setErrorMsg("活动管理数据请求错误！");
			result.setSuccess(false);
			return result;
		}
	}

	/**
	 * 根据活动Id获取活动数据
	 */
	@Override
	public RemoteResult<SaleAction> getSaleActionById(@RequestParam("saleActionId") Integer saleActionId) {
		RemoteResult<SaleAction> result = new RemoteResult<>();
		try {
			SaleAction saleAction = saleActionManager.getSaleActionById(saleActionId);
			result.setSuccess(true);
			result.setData(saleAction);
			return result;
		} catch (Exception e) {
			logger.error(SendMailUtil.printStackTraceToString(e));
			result.setErrorMsg("活动管理数据请求错误！");
			result.setSuccess(false);
			return result;
		}
	}

	/**
	 * 编辑活动信息
	 */
	@Override
	public RemoteResult<SaleAction> saleActionEditById(@RequestBody SaleAction saleAction) {
		RemoteResult<SaleAction> result = new RemoteResult<>();
		if(saleAction.getId()==null) {
			result.setErrorMsg("活动Id不能为空！");
			result.setSuccess(false);
			return result;
		}
		try {
			String actionCode = saleAction.getCode();
			SaleAction saleActionCheck = saleActionManager.getSaleActionById(saleAction.getId());
			if(saleActionCheck!=null ) {
				List<DeviceApply> deviceApplyList = deviceApplyManager.getDeviceApplyByActionCode(actionCode);
				String channelCode = saleAction.getChannelCode();
				//信息不变可以修改
				if(CollectionUtils.isNotEmpty(deviceApplyList)) {
					result.setErrorMsg("当前已有设备申领信息，不能修改！");
					result.setSuccess(false);
					return result;
				}
				String code = saleAction.getCode();
				String deviceApplyUrlForAction = deviceApplyUrl+"?channelCode="+channelCode+"&actionCode="+code;
				saleAction.setDeviceApplyUrl(URLEncoder.encode(deviceApplyUrlForAction,"utf-8"));
				String endTimeStr = saleAction.getEndTime();
				if(StringUtils.isNoneEmpty(endTimeStr)) {
					endTimeStr +=" 23:59:59";
					saleAction.setEndTime(endTimeStr);
				}
				saleActionManager.saleActionEditById(saleAction);
				result.setSuccess(true);
				return result;
			}else {
				result.setErrorMsg("该活动不存在！");
				result.setSuccess(false);
				return result;
			}
		} catch (Exception e) {
			logger.error(SendMailUtil.printStackTraceToString(e));
			result.setErrorMsg("活动数据更新请求错误！");
			result.setSuccess(false);
			return result;
		}
	}

	/**
	 * 活动添加
	 */
	@Override
	public RemoteResult<SaleAction> saleActionAdd(@RequestBody SaleAction saleAction) {
		RemoteResult<SaleAction> result = new RemoteResult<>();
		String code = saleAction.getCode();
		if(StringUtils.isBlank(code)) {
			result.setErrorMsg("活动编码不能为空！");
			result.setSuccess(false);
			return result;
		}
		try {
			String channelCode = saleAction.getChannelCode();
			String deviceApplyUrlForAction = deviceApplyUrl+"?channelCode="+channelCode+"&actionCode="+code;
			saleAction.setDeviceApplyUrl(URLEncoder.encode(deviceApplyUrlForAction,"utf-8"));
			String endTimeStr = saleAction.getEndTime();
			if(StringUtils.isNoneEmpty(endTimeStr)) {
				endTimeStr +=" 23:59:59";
				saleAction.setEndTime(endTimeStr);
			}
			saleActionManager.saleActionAdd(saleAction);
			result.setSuccess(true);
			return result;
		} catch (Exception e) {
			logger.error(SendMailUtil.printStackTraceToString(e));
			result.setErrorMsg("活动添加错误！");
			result.setSuccess(false);
			return result;
		}
	}

	/**
	 * 活动删除
	 */
	@Override
	public RemoteResult<SaleAction> saleActionDelete(@RequestParam("saleActionId") Integer saleActionId) {
		RemoteResult<SaleAction> result = new RemoteResult<>();
		if(saleActionId==null) {
			result.setErrorMsg("活动Id不能为空！");
			result.setSuccess(false);
			return result;
		}
		try {
			//查询删除活动
			SaleAction saleAction = saleActionManager.getSaleActionById(saleActionId);
			if(saleAction!=null ) {
				saleActionManager.saleActionDelete(saleActionId);
				result.setSuccess(true);
				return result;
			}else {
				result.setErrorMsg("该活动不存在！");
				result.setSuccess(false);
				return result;
			}
		} catch (Exception e) {
			logger.error(SendMailUtil.printStackTraceToString(e));
			result.setErrorMsg("活动删除错误！");
			result.setSuccess(false);
			return result;
		}
	}

	@Override
	public RemoteResult<SaleAction> getSaleActionByCode(@RequestParam("actionCode") String actionCode) {
		RemoteResult<SaleAction> result = new RemoteResult<>();
		try {
			SaleAction saleAction = saleActionManager.getSaleActionByCode(actionCode);
			result.setSuccess(true);
			result.setData(saleAction);
			return result;
		} catch (Exception e) {
			logger.error(SendMailUtil.printStackTraceToString(e));
			result.setErrorMsg("活动管理数据请求错误！");
			result.setSuccess(false);
			return result;
		}
	}	

}
