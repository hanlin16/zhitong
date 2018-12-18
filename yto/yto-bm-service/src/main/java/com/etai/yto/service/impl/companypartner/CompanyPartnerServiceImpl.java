package com.etai.yto.service.impl.companypartner;

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

import com.etai.yto.api.CompanyPartnerService;
import com.etai.yto.manager.companypartner.CompanyPartnerManager;
import com.etai.yto.manager.salechannel.SaleChannelManager;
import com.etai.yto.manager.syscode.EightCodeManager;
import com.etai.yto.model.companypartner.CompanyPartner;
import com.etai.yto.model.salechannel.SaleChannel;
import com.etai.yto.model.syscode.EightCode;
import com.etai.yto.page.PageResult;
import com.etai.yto.page.RemoteResult;
import com.etai.yto.page.companypartner.CompanyPartnerPage;
import com.etai.yto.utils.SendMailUtil;

@RestController
public class CompanyPartnerServiceImpl implements CompanyPartnerService{

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CompanyPartnerManager companyPartnerManager;
	
	@Autowired
	private SaleChannelManager saleChannelManager;
	
	@Autowired
	private EightCodeManager eightCodeManager;
	
	/**
	 * 分页查询合作伙伴数据
	 */
	@Override
	public RemoteResult<PageResult<CompanyPartner>> queryCompanyPartnerPage(@RequestBody CompanyPartnerPage page) {
		RemoteResult<PageResult<CompanyPartner>> result = new RemoteResult<PageResult<CompanyPartner>>();
		PageResult<CompanyPartner> pageResult = new PageResult<CompanyPartner>();
		try {
			if(StringUtils.isNotBlank(page.getFullName())) {
				page.setFullName("%"+page.getFullName()+"%");
			}
			if(StringUtils.isNotBlank(page.getShortName())) {
				page.setShortName("%"+page.getShortName()+"%");
			}
			int count = companyPartnerManager.queryCompanyPartnerCount(page);
			List<CompanyPartner> list = new ArrayList<>();
			if(count>0) {
				if(page.getLimit()!=null) {
					page.setRows(page.getLimit());
				}
				page.setRowCount(count);
				list = companyPartnerManager.queryCompanyPartnerPage(page);
				pageResult.setPage(page.getPager());
			}
			pageResult.setDataList(list);
			result.setData(pageResult);
			result.setSuccess(true);
			return result;
		} catch (Exception e) {
			logger.error(SendMailUtil.printStackTraceToString(e));
			result.setErrorMsg("合作伙伴管理数据请求错误！");
			result.setSuccess(false);
			return result;
		}
	}

	/**
	 * 根据合作伙伴Id获取合作伙伴数据
	 */
	@Override
	public RemoteResult<CompanyPartner> getCompanyPartnerById(@RequestParam("companyPartnerId") Integer companyPartnerId) {
		RemoteResult<CompanyPartner> result = new RemoteResult<>();
		try {
			CompanyPartner companyPartner = companyPartnerManager.getCompanyPartnerById(companyPartnerId);
			result.setSuccess(true);
			result.setData(companyPartner);
			return result;
		} catch (Exception e) {
			logger.error(SendMailUtil.printStackTraceToString(e));
			result.setErrorMsg("合作伙伴管理数据请求错误！");
			result.setSuccess(false);
			return result;
		}
	}

	/**
	 * 编辑合作伙伴信息
	 */
	@Override
	public RemoteResult<CompanyPartner> companyPartnerEditById(@RequestBody CompanyPartner companyPartner) {
		RemoteResult<CompanyPartner> result = new RemoteResult<>();
		if(companyPartner.getId()==null) {
			result.setErrorMsg("合作伙伴Id不能为空！");
			result.setSuccess(false);
			return result;
		}
		String fullName = companyPartner.getFullName();
		String shortName = companyPartner.getShortName();
		if(StringUtils.isBlank(fullName) || StringUtils.isBlank(shortName)) {
			result.setErrorMsg("合作伙伴名称不能为空！");
			result.setSuccess(false);
			return result;
		}
		try {
			CompanyPartner companyPartnerCheck = companyPartnerManager.getCompanyPartnerById(companyPartner.getId());
			if(companyPartnerCheck!=null ) {
				CompanyPartner companyPartnerDb = companyPartnerManager.getCompanyPartnerByFullName(fullName);
				if(companyPartnerDb!=null) {
					Integer idDb = companyPartnerDb.getId();
					if(!idDb.equals(companyPartner.getId())) {
						result.setErrorMsg("当前全称已经被使用！");
						result.setSuccess(false);
						return result;
					}
				}
				companyPartnerDb = companyPartnerManager.getCompanyPartnerByShortName(shortName);
				if(companyPartnerDb!=null) {
					Integer idDb = companyPartnerDb.getId();
					if(!idDb.equals(companyPartner.getId())) {
						result.setErrorMsg("当前简称已经被使用！");
						result.setSuccess(false);
						return result;
					}
				}
				companyPartnerManager.companyPartnerEditById(companyPartner);
				result.setSuccess(true);
				return result;
			}else {
				result.setErrorMsg("该合作伙伴不存在！");
				result.setSuccess(false);
				return result;
			}
		} catch (Exception e) {
			logger.error(SendMailUtil.printStackTraceToString(e));
			result.setErrorMsg("合作伙伴数据更新请求错误！");
			result.setSuccess(false);
			return result;
		}
	}

	/**
	 * 合作伙伴添加
	 */
	@Override
	public RemoteResult<CompanyPartner> companyPartnerAdd(@RequestBody CompanyPartner companyPartner) {
		RemoteResult<CompanyPartner> result = new RemoteResult<>();
		String fullName = companyPartner.getFullName();
		String shortName = companyPartner.getShortName();
		String areaCode = companyPartner.getAreaCode();
		if(StringUtils.isBlank(fullName) || StringUtils.isBlank(shortName)) {
			result.setErrorMsg("合作伙伴名称不能为空！");
			result.setSuccess(false);
			return result;
		}
		if(StringUtils.isBlank(areaCode)) {
			result.setErrorMsg("地区不能为空！");
			result.setSuccess(false);
			return result;
		}
		CompanyPartner companyPartnerDb = companyPartnerManager.getCompanyPartnerByFullName(fullName);
		if(companyPartnerDb!=null) {
			result.setErrorMsg("当前全称已经被使用！");
			result.setSuccess(false);
			return result;
		}
		companyPartnerDb = companyPartnerManager.getCompanyPartnerByShortName(shortName);
		if(companyPartnerDb!=null) {
			result.setErrorMsg("当前简称已经被使用！");
			result.setSuccess(false);
			return result;
		}
		EightCode eightCode = eightCodeManager.queryEightCode();
		if(eightCode!=null) {
			companyPartner.setCode(eightCode.getCode());
		}else {
			result.setErrorMsg("系统分配编码已经用完，添加错误！");
			result.setSuccess(false);
			return result;
		}
		try {
			companyPartnerManager.companyPartnerAdd(companyPartner);
			result.setSuccess(true);
			return result;
		} catch (Exception e) {
			logger.error(SendMailUtil.printStackTraceToString(e));
			result.setErrorMsg("合作伙伴添加错误！");
			result.setSuccess(false);
			return result;
		}
	}

	/**
	 * 合作伙伴删除
	 */
	@Override
	public RemoteResult<CompanyPartner> companyPartnerDelete(@RequestParam("companyPartnerId") Integer companyPartnerId) {
		RemoteResult<CompanyPartner> result = new RemoteResult<>();
		if(companyPartnerId==null) {
			result.setErrorMsg("合作伙伴Id不能为空！");
			result.setSuccess(false);
			return result;
		}
		try {
			CompanyPartner companyPartner = companyPartnerManager.getCompanyPartnerById(companyPartnerId);
			if(companyPartner!=null ) {
				List<SaleChannel> saleChannels = saleChannelManager.getSaleChannelByPartnerCode(companyPartner.getCode());
				if(CollectionUtils.isEmpty(saleChannels)) {
					companyPartnerManager.companyPartnerDelete(companyPartnerId);
					result.setSuccess(true);
					return result;
				}else {
					result.setErrorMsg("该合作伙伴已经被使用！不能删除");
					result.setSuccess(false);
					return result;
				}				
			}else {
				result.setErrorMsg("该合作伙伴不存在！");
				result.setSuccess(false);
				return result;
			}
		} catch (Exception e) {
			logger.error(SendMailUtil.printStackTraceToString(e));
			result.setErrorMsg("合作伙伴删除错误！");
			result.setSuccess(false);
			return result;
		}
	}	

}
