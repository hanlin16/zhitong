package com.etai.yto.controller.saleaction;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.etai.yto.api.saleaction.FeignSaleActionService;
import com.etai.yto.model.saleaction.SaleAction;
import com.etai.yto.model.user.User;
import com.etai.yto.page.PageResult;
import com.etai.yto.page.RemoteResult;
import com.etai.yto.page.saleaction.SaleActionPage;

@RestController
@RequestMapping("/saleAction")
public class SaleActionController {
	
	@Autowired
	FeignSaleActionService saleActionService;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	/**
	 * 活动管理查询功能
	 */
	@PostMapping("/querySaleActionList")
	public PageResult<SaleAction> querySaleActionList(SaleActionPage page) {
		PageResult<SaleAction> data = new PageResult<>();
		try {
			RemoteResult<PageResult<SaleAction>> remoteResult = saleActionService.querySaleActionPage(page);
			if(remoteResult.isSuccess()) {
				data = remoteResult.getData();
				data.getDataList().forEach(saleAction ->{
					String endTime = saleAction.getEndTime();
					endTime = endTime.replace(" 23:59:59", "");
					endTime = endTime.replace(" 00:00:00", "");
					saleAction.setEndTime(endTime);
				});
				data.setState(true);
				return data;
			}else {
				data = remoteResult.getData()==null?data:remoteResult.getData();
				data.setState(false);
				data.setErrorMsg(remoteResult.getErrorMsg());
				return data;
			}
		} catch (Exception e) {
			logger.error("活动管理查询功能报错:",e);
			data.setState(false);
			data.setErrorMsg("活动管理查询功能报错");
			return data;
		}
	}
	
	/**
	 * 活动管理添加
	 */
	@PostMapping("/saleActionAdd")
	public RemoteResult<SaleAction> saleActionAdd(SaleAction saleAction, HttpSession session){
		User user = (User) session.getAttribute("currentUser");
		Integer userId = user.getId();
		DateTime now = DateTime.now();
		saleAction.setCreateTime(now.toString("yyyy-MM-dd"));
		saleAction.setCreateUser(Integer.toString(userId));
		RemoteResult<SaleAction> remoteResult = saleActionService.saleActionAdd(saleAction);
		return remoteResult;
	}
	
	/**
	 * 活动管理编辑
	 */
	@PostMapping("/saleActionEdit")
	public RemoteResult<SaleAction> saleActionEdit(SaleAction saleAction, HttpSession session){
		User user = (User) session.getAttribute("currentUser");
		Integer userId = user.getId();
		DateTime now = DateTime.now();
		saleAction.setUpdateTime(now.toString("yyyy-MM-dd"));
		saleAction.setUpdateUser(Integer.toString(userId));
		RemoteResult<SaleAction> remoteResult = saleActionService.saleActionEditById(saleAction);
		return remoteResult;
	}
	
	/**
	 * 活动管理删除
	 */
	@PostMapping("/saleActionDelete")
	public RemoteResult<SaleAction> saleActionDelete(Integer saleActionId, HttpSession session){
		if(saleActionId==null) {
			RemoteResult<SaleAction> remoteResult = new RemoteResult<SaleAction>();
			remoteResult.setErrorMsg("id不能为空");
			remoteResult.setSuccess(false);
			return remoteResult;
		}
		RemoteResult<SaleAction> remoteResult = saleActionService.saleActionDelete(saleActionId);
		return remoteResult;
	}
	
	@InitBinder  
	public void initBinder(WebDataBinder binder) {  
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
	    dateFormat.setLenient(false);  
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));  
	}
	
}
