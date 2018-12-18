package com.etai.yto.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.etai.yto.api.FeignDeviceConectService;
import com.etai.yto.api.FeignLoginService;
import com.etai.yto.api.FeignProposalService;
import com.etai.yto.api.companypartner.FeignCompanyPartnerService;
import com.etai.yto.api.devicemanage.FeignDeviceManageService;
import com.etai.yto.api.saleaction.FeignSaleActionService;
import com.etai.yto.api.salechannel.FeignSaleChannelService;
import com.etai.yto.api.syscode.FeginFourCodeService;
import com.etai.yto.api.user.FeignUserService;
import com.etai.yto.model.companypartner.CompanyPartner;
import com.etai.yto.model.proposal.ProposalModel;
import com.etai.yto.model.saleaction.SaleAction;
import com.etai.yto.model.salechannel.SaleChannel;
import com.etai.yto.model.syscode.FourCode;
import com.etai.yto.model.user.User;
import com.etai.yto.page.PageResult;
import com.etai.yto.page.RemoteResult;
import com.etai.yto.page.companypartner.CompanyPartnerPage;
import com.etai.yto.page.device.DeviceApplyModel;
import com.etai.yto.page.device.DeviceManageDetail;
import com.etai.yto.page.salechannel.SaleChannelPage;
import com.etai.yto.page.user.UserPage;

import net.glxn.qrgen.core.image.ImageType;
import net.glxn.qrgen.javase.QRCode;

@Controller
public class PageController {

	@Autowired(required=false)
	FeignDeviceConectService deviceConectService;
	
	@Autowired(required=false)
	FeignProposalService proposalService;
	
	@Autowired(required=false)
	FeignUserService userService;
	
	@Autowired(required=false)
	FeignLoginService loginService;
	
	@Autowired(required=false)
	FeignCompanyPartnerService companyPartnerService;
	
	@Autowired(required=false)
	FeignSaleChannelService saleChannelService;
	
	@Autowired(required=false)
	FeignSaleActionService saleActionService;
	
	@Autowired(required=false)
	FeignDeviceManageService deviceManageService;
	
	@Autowired(required=false)
	FeginFourCodeService fourCodeService;
	
	/**
	 * 页面跳转--保单详情
	 */
	@GetMapping("/deviceConect/proposalInfo")
	public String viewProposalInfoPage(HttpServletRequest request, String bizId){
		RemoteResult<ProposalModel> remoteResult = proposalService.getProposalDetail(bizId);
		if(remoteResult.isSuccess()) {
			ProposalModel proposalDetail = remoteResult.getData();
			request.setAttribute("proposalDetail", proposalDetail);
			return "views/deviceConect/proposalInfo";
		}else {
			return "redirect:/500";
		}
	}
	
	/**
	 * 页面跳转--设备详情
	 */
	@GetMapping("/deviceManage/deviceDetailInfo")
	public String viewDeviceDetailInfoPage(HttpServletRequest request, Integer id){
		RemoteResult<DeviceManageDetail> remoteResult = deviceManageService.getDeviceDetailById(id);
		request.setAttribute("showMenu", "deviceManage");
		if(remoteResult.isSuccess()) {
			DeviceManageDetail detail = remoteResult.getData();
			request.setAttribute("deviceDetail", detail);
			return "views/deviceManage/deviceInfo";
		}else {
			return "redirect:/500";
		}
	}
	
	/**
	 * 页面跳转--绑定设备页面
	 */
	@GetMapping("deviceConect/relationDeviceInfo")
	public String viewRelationDeviceInfo(HttpServletRequest request, String applyId){
		RemoteResult<DeviceApplyModel> remoteResult = deviceConectService.getRelationDeviceInfo(applyId);
		if(remoteResult.isSuccess()) {
			DeviceApplyModel bindDetail = remoteResult.getData();
			request.setAttribute("bindDetail", bindDetail);
			return "views/deviceConect/bindDevice";
		}else {
			return "/views/error/500Mini";
		}
	}	
	
	/**
	 * 页面跳转--设备关联
	 */
	@GetMapping("/deviceConect/deviceConectPage")
	public String deviceConectPage(HttpServletRequest request){
		request.setAttribute("showMenu", "deviceConect");
		return "views/deviceConect/deviceConects";
	}
	
	@GetMapping("viewLogin")
	public String viewLoginPage() {
		return "views/login";
	}
	
	@GetMapping("/")
	public String viewIndexPage(HttpServletRequest request) {
		return "redirect:/deviceConect/deviceConectPage";
	}
	
	/**
	 * 页面跳转--评分管理页面
	 */
	@GetMapping("/score/scorePage")
	public String viewScorePage(HttpServletRequest request){
		request.setAttribute("showMenu", "scoreQuery");
		return "views/score/scores";
	}
	
	/**
	 * 页面跳转--用户管理页面
	 */
	@GetMapping("/user/userPage")
	public String viewUserPage(HttpServletRequest request){
		request.setAttribute("showMenu", "userManage");
		return "views/user/users";
	}
	
	@GetMapping("/saleAction/generateQrCode")
	public void generateQrCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String qrtext = request.getParameter("deviceApplyUrl");
		ByteArrayOutputStream out = QRCode.from(qrtext).to(ImageType.PNG).withSize(200, 200).stream();
        response.setContentType("image/png");
        response.setContentLength(out.size());
        OutputStream outStream = response.getOutputStream();
        outStream.write(out.toByteArray());
        //兼容IE浏览器下载文件，防止文件名乱码
        if (request.getHeader("User-Agent").toUpperCase().contains("MSIE")) {  
        	response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode("img.gif", "UTF-8"));
        } else {
        	response.setHeader("Content-Disposition", "attachment;filename=" + new String(("img.gif").getBytes(), "iso-8859-1"));
        }
        outStream.flush();
	}

	/**
	 * 页面跳转--设备详情页面
	 */
	@GetMapping("/device/deviceInfoPage")
	public String viewDeviceInfoPage(HttpServletRequest request){
		return "views/deviceManage/deviceInfo";
	}
	
	/**
	 * 页面跳转--设备管理页面
	 */
	@GetMapping("/deviceManage/deviceManagePage")
	public String viewDevicePage(HttpServletRequest request){
		request.setAttribute("showMenu", "deviceManage");
		return "views/deviceManage/devices";
	}
	
	/**
	 * 页面跳转--活动管理页面
	 */
	@GetMapping("/saleAction/saleActionPage")
	public String viewSaleActionPage(HttpServletRequest request){
		request.setAttribute("showMenu", "saleAction");
		SaleChannelPage channelPage = new SaleChannelPage();
		channelPage.setLimit(65536);
		channelPage.setPartnerCode("0");
		channelPage.setStatus("2");
		RemoteResult<PageResult<SaleChannel>> channelResult = saleChannelService.querySaleChannelPage(channelPage);
		PageResult<SaleChannel> channelData = channelResult.getData();
		request.setAttribute("channelList", channelData.getDataList());
		CompanyPartnerPage partnerPage = new CompanyPartnerPage();
		partnerPage.setLimit(65536);
		RemoteResult<PageResult<CompanyPartner>> partnerResult = companyPartnerService.queryCompanyPartnerPage(partnerPage);
		PageResult<CompanyPartner> partnerData = partnerResult.getData();
		request.setAttribute("partnerList", partnerData.getDataList());
		return "views/saleAction/saleActions";
	}
	
	/**
	 * 页面跳转--活动管理页面
	 */
	@GetMapping("/saleAction/deviceApplyUrlPage")
	public String viewDeviceApplyUrlPage(HttpServletRequest request,String actionCode) throws UnsupportedEncodingException{
		RemoteResult<SaleAction> remoteResult = saleActionService.getSaleActionByCode(actionCode);
		if(remoteResult.isSuccess()) {
			SaleAction saleAction = remoteResult.getData();
			request.setAttribute("actionCode", saleAction.getCode());
			String deviceApplyUrl = saleAction.getDeviceApplyUrl();
			String deviceApplyUrlView = URLDecoder.decode(deviceApplyUrl, "utf-8");
			request.setAttribute("deviceApplyUrl", deviceApplyUrl);
			request.setAttribute("deviceApplyUrlView", deviceApplyUrlView);
			return "views/saleAction/deviceApplyUrl";
		}else {
			return "/views/error/500Mini";
		}		
	}
	
	/**
	 * 页面跳转--活动添加页面
	 */
	@GetMapping("/saleAction/saleActionAdd")
	public String saleActionAdd(Model model){
		RemoteResult<FourCode> remoteResult = fourCodeService.queryFourCode();
		if(remoteResult.isSuccess()) {
			FourCode fourCode = remoteResult.getData();
			model.addAttribute("fourCode", fourCode);
			SaleChannelPage channelPage = new SaleChannelPage();
			channelPage.setLimit(65536);
			channelPage.setPartnerCode("0");
			channelPage.setStatus("1");
			RemoteResult<PageResult<SaleChannel>> channelResult = saleChannelService.querySaleChannelPage(channelPage);
			PageResult<SaleChannel> channelData = channelResult.getData();
			model.addAttribute("channelList", channelData.getDataList());
			return "views/saleAction/saleActionAdd";
		}else {
			return "/views/error/500Mini";
		}	
		
	}
	
	/**
	 * 页面跳转--活动编辑页面
	 */
	@GetMapping("/saleAction/saleActionEdit")
	public String viewSaleActionEdit(Integer saleActionId, Model model){
		RemoteResult<SaleAction> remoteResult = saleActionService.getSaleActionById(saleActionId);
		if(remoteResult.isSuccess()) {
			SaleAction saleAction = remoteResult.getData();
			
			model.addAttribute("saleAction", saleAction);
			SaleChannelPage channelPage = new SaleChannelPage();
			channelPage.setLimit(65536);
			channelPage.setPartnerCode("0");
			channelPage.setStatus("1");
			RemoteResult<PageResult<SaleChannel>> channelResult = saleChannelService.querySaleChannelPage(channelPage);
			PageResult<SaleChannel> channelData = channelResult.getData();
			model.addAttribute("channelList", channelData.getDataList());
			return "views/saleAction/saleActionEdit";
		}else {
			return "/views/error/500Mini";
		}
	}
	
	/**
	 * 页面跳转--渠道管理页面
	 */
	@GetMapping("/saleChannel/saleChannelPage")
	public String viewSaleChannelPage(HttpServletRequest request){
		request.setAttribute("showMenu", "saleChannel");
		return "views/saleChannel/channels";
	}
	
	/**
	 * 页面跳转--渠道添加页面
	 */
	@GetMapping("/saleChannel/saleChannelAdd")
	public String saleChannelAdd(HttpServletRequest request){
		CompanyPartnerPage partnerPage = new CompanyPartnerPage();
		partnerPage.setLimit(65536);
		RemoteResult<PageResult<CompanyPartner>> partnerResult = companyPartnerService.queryCompanyPartnerPage(partnerPage);
		PageResult<CompanyPartner> partnerData = partnerResult.getData();
		request.setAttribute("partnerList", partnerData.getDataList());
		return "views/saleChannel/channelAdd";
	}
	
	/**
	 * 页面跳转--渠道编辑页面
	 */
	@GetMapping("/saleChannel/saleChannelEdit")
	public String viewSaleChannelEdit(Integer saleChannelId, Model model){
		RemoteResult<SaleChannel> remoteResult = saleChannelService.getSaleChannelById(saleChannelId);
		if(remoteResult.isSuccess()) {
			SaleChannel saleChannel = remoteResult.getData();
			model.addAttribute("saleChannel", saleChannel);
			CompanyPartnerPage partnerPage = new CompanyPartnerPage();
			partnerPage.setLimit(65536);
			RemoteResult<PageResult<CompanyPartner>> partnerResult = companyPartnerService.queryCompanyPartnerPage(partnerPage);
			PageResult<CompanyPartner> partnerData = partnerResult.getData();
			model.addAttribute("partnerList", partnerData.getDataList());
			return "views/saleChannel/channelEdit";
		}else {
			return "/views/error/500Mini";
		}
	}
	
	/**
	 * 页面跳转--合作伙伴管理页面
	 */
	@GetMapping("/companyPartner/companyPartnerPage")
	public String viewCompanyPartnerPage(HttpServletRequest request){
		request.setAttribute("showMenu", "companyPartner");
		return "views/companyPartner/companyPartners";
	}
	
	/**
	 * 页面跳转--合作伙伴添加页面
	 */
	@GetMapping("/companyPartner/companyPartnerAdd")
	public String companyPartnerAdd(){
		return "views/companyPartner/companyPartnerAdd";
	}
	
	/**
	 * 页面跳转--合作伙伴编辑页面
	 */
	@GetMapping("/companyPartner/companyPartnerEdit")
	public String viewCompanyPartnerEdit(Integer companyPartnerId, Model model){
		RemoteResult<CompanyPartner> remoteResult = companyPartnerService.getCompanyPartnerById(companyPartnerId);
		if(remoteResult.isSuccess()) {
			CompanyPartner companyPartner = remoteResult.getData();
			model.addAttribute("companyPartner", companyPartner);
			return "views/companyPartner/companyPartnerEdit";
		}else {
			return "/views/error/500Mini";
		}
	}
	
	/**
	 * 页面跳转--用户添加页面
	 */
	@GetMapping("/user/userAdd")
	public String userAdd(UserPage page){
		return "views/user/userAdd";
	}
	
	/**
	 * 页面跳转--用户编辑页面
	 */
	@GetMapping("/user/userEdit")
	public String viewUserEdit(Integer userId, Model model){
		RemoteResult<User> remoteResult = userService.getUserById(userId);
		if(remoteResult.isSuccess()) {
			User user = remoteResult.getData();
			model.addAttribute("user", user);
			return "views/user/userEdit";
		}else {
			return "/views/error/500Mini";
		}
	}
	
	@GetMapping("userUpPwd")
	public String updatePasswd() {
		return "views/user/updatePasswd";
	}
	
	@GetMapping("500")
	public String systemError(HttpSession session) {
		return "views/error/500";
	}
	
	@RequestMapping("logout")
	public String logout(HttpSession session) {
		User user = (User) session.getAttribute("currentUser");
		session.removeAttribute("currentUser");
		session.invalidate();
		if(user!=null) {
			loginService.updateLoginTime(user);
		}
		return "redirect:/viewLogin";
	}
	
	/**
	 * 页面跳转--积分规则页面
	 */
	@GetMapping("/integral/integralPage")
	public String viewintegralPage(HttpServletRequest request){
		request.setAttribute("showMenu", "integral");
		return "views/integral/integral";
	}
	/**
	 * 页面跳转--规则内容页面
	 */
	@GetMapping("/integral/integralDetailPage")
	public String viewintegralDetailPage(HttpServletRequest request){
//		request.setAttribute("showMenu", "integralDetail");
		System.out.println("规则编号"+request.getParameter("code"));
		return "views/integral/integralDetail";
	}
	/**
	 * 页面跳转--积分查询页面
	 */
	@GetMapping("/integral/integralQueryPage")
	public String viewintegralQueryPage(HttpServletRequest request){
		request.setAttribute("showMenu", "integralQuery");
		return "views/integral/integralQuery";
	}
	/**
	 * 页面跳转--积分明细页面
	 */
	@GetMapping("/integral/integralQueryDetailPage")
	public String viewintegralQueryDetailPage(HttpServletRequest request){
//		request.setAttribute("showMenu", "integralQueryDetail");
		return "views/integral/integralQueryDetail";
	}
	/**
	 * 页面跳转--保单查询页面
	 */
	@GetMapping("/proposal/proposalQueryPage")
	public String viewProposalQueryPage(HttpServletRequest request){
		request.setAttribute("showMenu", "proposalQuery");
		return "views/proposal/proposalQuery";
	}
}
