package com.etai.yto.service.impl.salechannel;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.etai.yto.api.SaleChannelService;
import com.etai.yto.manager.deviceapply.DeviceApplyManager;
import com.etai.yto.manager.saleaction.SaleActionManager;
import com.etai.yto.manager.salechannel.SaleChannelManager;
import com.etai.yto.manager.syscode.EightCodeManager;
import com.etai.yto.model.device.DeviceApply;
import com.etai.yto.model.saleaction.SaleAction;
import com.etai.yto.model.salechannel.SaleChannel;
import com.etai.yto.model.syscode.EightCode;
import com.etai.yto.page.PageResult;
import com.etai.yto.page.RemoteResult;
import com.etai.yto.page.salechannel.SaleChannelPage;
import com.etai.yto.utils.SendMailUtil;

@RestController
public class SaleChannelServiceImpl implements SaleChannelService{

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private SaleChannelManager saleChannelManager;
	
	@Autowired
	private SaleActionManager saleActionManager;
	
	@Autowired
	private EightCodeManager eightCodeManager;
	@Autowired
	private DeviceApplyManager deviceApplyManager;
	
	/**
	 * 分页查询渠道数据
	 */
	@Override
	public RemoteResult<PageResult<SaleChannel>> querySaleChannelPage(@RequestBody SaleChannelPage page) {
		RemoteResult<PageResult<SaleChannel>> result = new RemoteResult<PageResult<SaleChannel>>();
		PageResult<SaleChannel> pageResult = new PageResult<SaleChannel>();
		try {
			int count = saleChannelManager.querySaleChannelCount(page);
			List<SaleChannel> list = new ArrayList<>();
			if(count>0) {
				if(page.getLimit()!=null) {
					page.setRows(page.getLimit());
				}
				page.setRowCount(count);
				list = saleChannelManager.querySaleChannelPage(page);
				pageResult.setPage(page.getPager());
			}
			pageResult.setDataList(list);
			result.setData(pageResult);
			result.setSuccess(true);
			return result;
		} catch (Exception e) {
			logger.error(SendMailUtil.printStackTraceToString(e));
			result.setErrorMsg("渠道管理数据请求错误！");
			result.setSuccess(false);
			return result;
		}
	}

	/**
	 * 根据渠道Id获取渠道数据
	 */
	@Override
	public RemoteResult<SaleChannel> getSaleChannelById(@RequestParam("saleChannelId") Integer saleChannelId) {
		RemoteResult<SaleChannel> result = new RemoteResult<>();
		try {
			SaleChannel saleChannel = saleChannelManager.getSaleChannelById(saleChannelId);
			result.setSuccess(true);
			result.setData(saleChannel);
			return result;
		} catch (Exception e) {
			logger.error(SendMailUtil.printStackTraceToString(e));
			result.setErrorMsg("渠道管理数据请求错误！");
			result.setSuccess(false);
			return result;
		}
	}

	/**
	 * 编辑渠道信息
	 */
	@Override
	public RemoteResult<SaleChannel> saleChannelEditById(@RequestBody SaleChannel saleChannel) {
		RemoteResult<SaleChannel> result = new RemoteResult<>();
		if(saleChannel.getId()==null) {
			result.setErrorMsg("渠道Id不能为空！");
			result.setSuccess(false);
			return result;
		}
		String name = saleChannel.getName();
		if(StringUtils.isBlank(name)) {
			result.setErrorMsg("渠道名称不能为空！");
			result.setSuccess(false);
			return result;
		}
		try {
			String code = saleChannel.getCode();
			SaleChannel saleChannelCheck = saleChannelManager.getSaleChannelById(saleChannel.getId());
			if(saleChannelCheck!=null) {
				List<DeviceApply> deviceApplyList = deviceApplyManager.getDeviceApplyByChannelCode(code);
				if(!CollectionUtils.isEmpty(deviceApplyList)) {
					result.setErrorMsg("当前已有设备申领信息，不能修改！");
					result.setSuccess(false);
					return result;
				}
				SaleChannel saleChannelDb = saleChannelManager.getSaleChannelByName(name);
				if(saleChannelDb!=null) {
					Integer idDb = saleChannelDb.getId();
					if(!idDb.equals(saleChannel.getId())) {
						result.setErrorMsg("该名称已经被使用！");
						result.setSuccess(false);
						return result;
					}
				}
				saleChannelManager.saleChannelEditById(saleChannel);
				result.setSuccess(true);
				return result;
			}else {
				result.setErrorMsg("该渠道不存在！");
				result.setSuccess(false);
				return result;
			}
		} catch (Exception e) {
			logger.error(SendMailUtil.printStackTraceToString(e));
			result.setErrorMsg("渠道数据更新请求错误！");
			result.setSuccess(false);
			return result;
		}
	}

	/**
	 * 渠道添加
	 */
	@Override
	public RemoteResult<SaleChannel> saleChannelAdd(@RequestBody SaleChannel saleChannel) {
		RemoteResult<SaleChannel> result = new RemoteResult<>();
		String name = saleChannel.getName();
		if(StringUtils.isBlank(name)) {
			result.setErrorMsg("渠道名称不能为空！");
			result.setSuccess(false);
			return result;
		}
		SaleChannel saleChannelDb = saleChannelManager.getSaleChannelByName(name);
		if(saleChannelDb!=null) {
			Integer idDb = saleChannelDb.getId();
			if(!idDb.equals(saleChannel.getId())) {
				result.setErrorMsg("该名称已经被使用！");
				result.setSuccess(false);
				return result;
			}
		}
		EightCode eightCode = eightCodeManager.queryEightCode();
		if(eightCode!=null) {
			saleChannel.setCode(eightCode.getCode());
		}else {
			result.setErrorMsg("系统分配编码已经用完，添加错误！");
			result.setSuccess(false);
			return result;
		}
		try {
			saleChannelManager.saleChannelAdd(saleChannel);
			result.setSuccess(true);
			return result;
		} catch (Exception e) {
			logger.error(SendMailUtil.printStackTraceToString(e));
			result.setErrorMsg("渠道添加错误！");
			result.setSuccess(false);
			return result;
		}
	}

	/**
	 * 渠道删除
	 */
	@Override
	public RemoteResult<SaleChannel> saleChannelDelete(@RequestParam("saleChannelId") Integer saleChannelId) {
		RemoteResult<SaleChannel> result = new RemoteResult<>();
		if(saleChannelId==null) {
			result.setErrorMsg("渠道Id不能为空！");
			result.setSuccess(false);
			return result;
		}
		try {
			SaleChannel saleChannel = saleChannelManager.getSaleChannelById(saleChannelId);
			if(saleChannel!=null ) {
				List<SaleAction> saleActions = saleActionManager.getSaleActionByChannlCode(saleChannel.getCode());
				if(CollectionUtils.isEmpty(saleActions)) {
					saleChannelManager.saleChannelDelete(saleChannelId);
					result.setSuccess(true);
					return result;
				}else {
					result.setErrorMsg("该渠道已经被使用！不能删除");
					result.setSuccess(false);
					return result;
				}			
			}else {
				result.setErrorMsg("该渠道不存在！");
				result.setSuccess(false);
				return result;
			}
		} catch (Exception e) {
			logger.error(SendMailUtil.printStackTraceToString(e));
			result.setErrorMsg("渠道删除错误！");
			result.setSuccess(false);
			return result;
		}
	}	

}
