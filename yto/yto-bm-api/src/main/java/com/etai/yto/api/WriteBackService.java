package com.etai.yto.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.etai.yto.model.underwriting.WritingSend;

public interface WriteBackService {

	/**
	 * 易通承保回写
	 * @param paramstr
	 * @return
	 * 2018年7月18日
	 * WritingSend
	 */
    @RequestMapping(value = "/open/underwriting", method = RequestMethod.POST)
	public  WritingSend saveUnderwriting(String paramstr);
}
