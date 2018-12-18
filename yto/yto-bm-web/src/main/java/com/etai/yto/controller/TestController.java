package com.etai.yto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 测试类
 * @author liushengli
 * @date 2018年07月11日
 */
@Controller
@RequestMapping(value="/test")
public class TestController {
	
	/**
	 * 返回一个测试页面
	 * @return
	 * 2017年12月21日
	 * String
	 */
	@RequestMapping(value="/testPage")
	public String testPage() {
	    return "404";
	}
	
	@RequestMapping(value="/pageinfo")
	public String pageinfo() {
		return "index";
	}
	
	
}
