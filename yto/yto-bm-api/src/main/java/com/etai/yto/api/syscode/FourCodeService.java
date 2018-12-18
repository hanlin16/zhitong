package com.etai.yto.api.syscode;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.etai.yto.model.syscode.FourCode;
import com.etai.yto.page.RemoteResult;

public interface FourCodeService {

	/**
	 * 保存随机码
	 * @param FourCode
	 * 2018年9月13日
	 * void
	 */
	@RequestMapping(value = "/syscode/insertFourCode", method = RequestMethod.POST)
	public void insertFourCode(FourCode FourCode);
	
	/**
	 * 获取一个未使用的随机码
	 * @return
	 * 2018年9月13日
	 * Integer
	 */
	@RequestMapping(value = "/syscode/queryFourCode", method = RequestMethod.GET)
	public RemoteResult<FourCode> queryFourCode();
	
	/**
	 * 更新随机码状态
	 * @param FourCode
	 * 2018年9月13日
	 * void
	 */
	@RequestMapping(value = "/syscode/UpdateFourCode", method = RequestMethod.POST)
	public void UpdateFourCode(FourCode FourCode);

	@RequestMapping(value = "/syscode/generateFourCode", method = RequestMethod.GET)
	void generateFourCode();
	
	
}
