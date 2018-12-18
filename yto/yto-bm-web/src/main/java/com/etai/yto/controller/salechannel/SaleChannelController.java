package com.etai.yto.controller.salechannel;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.etai.yto.api.salechannel.FeignSaleChannelService;
import com.etai.yto.model.salechannel.SaleChannel;
import com.etai.yto.model.user.User;
import com.etai.yto.page.PageResult;
import com.etai.yto.page.RemoteResult;
import com.etai.yto.page.salechannel.SaleChannelPage;

@RestController
@RequestMapping("/saleChannel")
public class SaleChannelController {
	
	@Autowired
	FeignSaleChannelService saleChannelService;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	/**
	 * 渠道管理查询功能
	 */
	@PostMapping("/querySaleChannelList")
	public PageResult<SaleChannel> querySaleChannelList(SaleChannelPage page) {
		PageResult<SaleChannel> data = new PageResult<>();
		try {
			RemoteResult<PageResult<SaleChannel>> remoteResult = saleChannelService.querySaleChannelPage(page);
			if(remoteResult.isSuccess()) {
				data = remoteResult.getData();
				data.setState(true);
				return data;
			}else {
				data = remoteResult.getData()==null?data:remoteResult.getData();
				data.setState(false);
				data.setErrorMsg(remoteResult.getErrorMsg());
				return data;
			}
		} catch (Exception e) {
			logger.error("渠道管理查询功能报错:",e);
			data.setState(false);
			data.setErrorMsg("渠道管理查询功能报错");
			return data;
		}
	}
	
	/**
	 * 渠道管理添加
	 */
	@PostMapping("/saleChannelAdd")
	public RemoteResult<SaleChannel> saleChannelAdd(SaleChannel saleChannel, HttpSession session){
		User user = (User) session.getAttribute("currentUser");
		Integer userId = user.getId();
		saleChannel.setCreateTime(new Date());
		saleChannel.setCreateUser(Integer.toString(userId));
		saleChannel.setStatus("1");
		RemoteResult<SaleChannel> remoteResult = saleChannelService.saleChannelAdd(saleChannel);
		return remoteResult;
	}
	
	/**
	 * 渠道管理编辑
	 */
	@PostMapping("/saleChannelEdit")
	public RemoteResult<SaleChannel> saleChannelEdit(SaleChannel saleChannel, HttpSession session){
		User user = (User) session.getAttribute("currentUser");
		Integer userId = user.getId();
		saleChannel.setUpdateTime(new Date());
		saleChannel.setUpdateUser(Integer.toString(userId));
		RemoteResult<SaleChannel> remoteResult = saleChannelService.saleChannelEditById(saleChannel);
		return remoteResult;
	}
	
	/**
	 * 渠道管理删除
	 */
	@PostMapping("/saleChannelDelete")
	public RemoteResult<SaleChannel> saleChannelDelete(Integer saleChannelId, HttpSession session){
		if(saleChannelId==null) {
			RemoteResult<SaleChannel> remoteResult = new RemoteResult<SaleChannel>();
			remoteResult.setErrorMsg("id不能为空");
			remoteResult.setSuccess(false);
			return remoteResult;
		}
		RemoteResult<SaleChannel> remoteResult = saleChannelService.saleChannelDelete(saleChannelId);
		return remoteResult;
	}
	
}
