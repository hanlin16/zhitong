package com.etai.yto.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.etai.yto.model.salechannel.SaleChannel;
import com.etai.yto.page.PageResult;
import com.etai.yto.page.RemoteResult;
import com.etai.yto.page.salechannel.SaleChannelPage;

public interface SaleChannelService {

	@RequestMapping(value = "/saleChannel/querySaleChannelList", method = RequestMethod.POST)
	RemoteResult<PageResult<SaleChannel>> querySaleChannelPage(SaleChannelPage page);

	@GetMapping("/saleChannel/getSaleChannelById")
	RemoteResult<SaleChannel> getSaleChannelById(@RequestParam("saleChannelId") Integer saleChannelId);

	@PostMapping("/saleChannel/saleChannelEdit")
	RemoteResult<SaleChannel> saleChannelEditById(SaleChannel saleChannel);

	@PostMapping("/saleChannel/saleChannelAdd")
	RemoteResult<SaleChannel> saleChannelAdd(SaleChannel saleChannel);

	@PostMapping("/saleChannel/saleChannelDelete")
	RemoteResult<SaleChannel> saleChannelDelete(@RequestParam("saleChannelId")Integer saleChannelId);
	
	
}
