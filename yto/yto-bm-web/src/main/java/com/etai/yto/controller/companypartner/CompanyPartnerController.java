package com.etai.yto.controller.companypartner;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.etai.yto.api.companypartner.FeignCompanyPartnerService;
import com.etai.yto.model.companypartner.CompanyPartner;
import com.etai.yto.model.user.User;
import com.etai.yto.page.PageResult;
import com.etai.yto.page.RemoteResult;
import com.etai.yto.page.companypartner.CompanyPartnerPage;

@RestController
@RequestMapping("/companyPartner")
public class CompanyPartnerController {
	
	@Autowired
	FeignCompanyPartnerService companyPartnerService;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	/**
	 * 合作伙伴查询功能
	 */
	@PostMapping("/queryCompanyPartnerList")
	public PageResult<CompanyPartner> queryCompanyPartnerList(CompanyPartnerPage page) {
		PageResult<CompanyPartner> data = new PageResult<>();
		try {
			RemoteResult<PageResult<CompanyPartner>> remoteResult = companyPartnerService.queryCompanyPartnerPage(page);
			if(remoteResult.isSuccess()) {
				data = remoteResult.getData();
				data.setState(true);
				return data;
			}else {
				data = remoteResult.getData();
				data.setState(false);
				data.setErrorMsg(remoteResult.getErrorMsg());
				return data;
			}
		} catch (Exception e) {
			logger.error("合作伙伴查询功能报错 ",e);
			data.setState(false);
			data.setErrorMsg("合作伙伴查询功能报错");
			return data;
		}
	}
	
	/**
	 * 合作伙伴添加
	 */
	@PostMapping("/companyPartnerAdd")
	public RemoteResult<CompanyPartner> companyPartnerAdd(CompanyPartner companyPartner, HttpSession session){
		User user = (User) session.getAttribute("currentUser");
		Integer userId = user.getId();
		companyPartner.setCreateTime(new Date());
		companyPartner.setCreateUser(Integer.toString(userId));
		RemoteResult<CompanyPartner> remoteResult = companyPartnerService.companyPartnerAdd(companyPartner);
		return remoteResult;
	}
	
	/**
	 * 合作伙伴编辑
	 */
	@PostMapping("/companyPartnerEdit")
	public RemoteResult<CompanyPartner> companyPartnerEdit(CompanyPartner companyPartner,HttpSession session){
		User user = (User) session.getAttribute("currentUser");
		Integer userId = user.getId();
		companyPartner.setUpdateTime(new Date());
		companyPartner.setUpdateUser(Integer.toString(userId));
		RemoteResult<CompanyPartner> remoteResult = companyPartnerService.companyPartnerEditById(companyPartner);
		return remoteResult;
	}
	/**
	 * 合作伙伴删除
	 */
	@PostMapping("/companyPartnerDelete")
	public RemoteResult<CompanyPartner> companyPartnerDelete(Integer companyPartnerId, HttpSession session){
		if(companyPartnerId==null) {
			RemoteResult<CompanyPartner> remoteResult = new RemoteResult<CompanyPartner>();
			remoteResult.setErrorMsg("合作伙伴Id不能为空");
			remoteResult.setSuccess(false);
			return remoteResult;
		}
		RemoteResult<CompanyPartner> remoteResult = companyPartnerService.companyPartnerDelete(companyPartnerId);
		return remoteResult;
	}
	
}
