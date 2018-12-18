package com.etai.yto.api.syscode;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.etai.yto.model.syscode.EightCode;

public interface EightCodeService {

	/**
	 * 保存随机码
	 * @param eightCode
	 * 2018年9月13日
	 * void
	 */
	@RequestMapping(value = "/syscode/insertEightCode", method = RequestMethod.POST)
	public void insertEightCode(EightCode eightCode);
	
	/**
	 * 获取一个未使用的随机码
	 * @return
	 * 2018年9月13日
	 * Integer
	 */
	@RequestMapping(value = "/syscode/queryEightCode", method = RequestMethod.GET)
	public EightCode queryEightCode();
	
	/**
	 * 更新随机码状态
	 * @param eightCode
	 * 2018年9月13日
	 * void
	 */
	@RequestMapping(value = "/syscode/UpdateEightCode", method = RequestMethod.POST)
	public void UpdateEightCode(EightCode eightCode);

	@RequestMapping(value = "/syscode/generateEightCode", method = RequestMethod.GET)
	void generateEightCode();
}
