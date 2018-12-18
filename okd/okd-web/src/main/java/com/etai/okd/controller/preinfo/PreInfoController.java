package com.etai.okd.controller.preinfo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.etai.okd.api.service.FeignPreInfoService;
import com.etai.okd.api.service.FeignSaleActionService;
import com.etai.yto.model.preinfo.PreInfoModel;
import com.etai.yto.model.saleaction.SaleAction;
import com.etai.yto.page.RemoteResult;
@Controller
@RequestMapping(value="/preInfo")
public class PreInfoController {

	@Autowired
	private FeignSaleActionService saleActionService;
	@Autowired
	private FeignPreInfoService preInfoService;
	
	@Value("${business.url.zt_quote_price_url}")
	private String url;
	
	@RequestMapping(value="/preInfoPage")
	public String drivingReportPage() {
//		System.out.println("跳转开始");
	    return "preinfo/preInfo";
	}
	
	@RequestMapping(value="/queryActionCode")
	@ResponseBody
	public String queryActionCode(HttpServletRequest request) {
		String actionCode = request.getParameter("actionCode");
		String licenceNo = request.getParameter("licenceNo");
//		System.out.println("活动码:"+actionCode);
//		System.out.println("车牌号:"+licenceNo);
		RemoteResult<SaleAction> result = saleActionService.getSaleActionByCode(actionCode);
//		System.out.println("查询结果:"+result);
		if(result.getData()==null){
			return "error";
		}
		//判断活动码是否失效
		String endTime = result.getData().getEndTime();
		String startTime = result.getData().getStartTime();
		System.out.println("startTime:"+startTime+";endTime:"+endTime);
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date startDate = null;
		Date endDate = null;
		try {
			startDate = dateFormat.parse(startTime);
			endDate = dateFormat.parse(endTime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		System.out.println("startDate:"+startDate.getTime()+";endDate:"+endDate.getTime()+";now:"+date.getTime());
		if(date.getTime()<startDate.getTime() || date.getTime()>endDate.getTime()){
			return "expired";
		}
//		System.out.println("查询结果:"+result.getData().getCode());
		if(StringUtils.isNotBlank(result.getData().getCode())){
//			System.out.println("开始添加活动码...");
			PreInfoModel model = new PreInfoModel();
			model.setActionCode(actionCode);
			model.setLicenceNo(licenceNo);
//			System.out.println("添加活动信息:"+model);
			RemoteResult<PreInfoModel> result2 = preInfoService.preInfoAdd(model);
//			System.out.println("添加结果:"+result2);
			if(result2.isSuccess()){
				return url+",0#wechat_redirect";
			}
		}
		return "success";
	}
	@RequestMapping(value="/preInfoAdd")
	@ResponseBody
	public String preInfoAdd(@RequestBody PreInfoModel preInfoModel){
//		System.out.println("信息:"+preInfoModel);
		try {
			preInfoService.preInfoAdd(preInfoModel);
			return "success";
		} catch (Exception e) {
			
			return "error";
		}
	}
	
	
}
