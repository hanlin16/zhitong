package com.etai.yto.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.etai.yto.model.saleaction.SaleAction;
import com.etai.yto.page.PageResult;
import com.etai.yto.page.RemoteResult;
import com.etai.yto.page.saleaction.SaleActionPage;

public interface SaleActionService {

	@RequestMapping(value = "/saleAction/querySaleActionList", method = RequestMethod.POST)
	RemoteResult<PageResult<SaleAction>> querySaleActionPage(SaleActionPage page);

	@GetMapping("/saleAction/getSaleActionById")
	RemoteResult<SaleAction> getSaleActionById(@RequestParam("saleActionId") Integer saleActionId);

	@PostMapping("/saleAction/saleActionEdit")
	RemoteResult<SaleAction> saleActionEditById(SaleAction saleAction);

	@PostMapping("/saleAction/saleActionAdd")
	RemoteResult<SaleAction> saleActionAdd(SaleAction saleAction);

	@PostMapping("/saleAction/saleActionDelete")
	RemoteResult<SaleAction> saleActionDelete(@RequestParam("saleActionId")Integer saleActionId);
	
	@PostMapping("/saleAction/getSaleActionByCode")
	RemoteResult<SaleAction> getSaleActionByCode(@RequestParam("actionCode") String actionCode);
	
}
