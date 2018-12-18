package com.etai.okd.controller.open;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.etai.okd.api.open.OkdWriteBackService;
import com.etai.yto.model.underwriting.WritingSend;
import com.etai.yto.model.utils.UbiConstant;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/**
 * 外部访问接口
 * @author liushengli
 * @date 2018年7月17日
 */
@Controller
@RequestMapping(value="/open")
public class OkdWriteBackController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private OkdWriteBackService writeBackService;
	/**
	 * 承保回写
	 * @param request
	 * @param response
	 * @param paramstr
	 * 2018年7月17日
	 * void
	 * @throws IOException 
	 */
	@RequestMapping("/underwriting")
//	@HystrixCommand(fallbackMethod = "failMethod")
	public void saveUnderwriting(HttpServletRequest request,HttpServletResponse response,@RequestBody String paramstr) throws IOException {
		WritingSend sendResult = new WritingSend();
		try {
			response.getWriter().println(JSON.toJSONString(writeBackService.saveUnderwriting(paramstr)));
		} catch (Exception e) {
			logger.error("承保回写:",e);
			sendResult.setState(UbiConstant.FAIL_CODE);
			sendResult.setMessage(UbiConstant.SYSTEM_ERROR);
			response.getWriter().println(JSON.toJSONString(sendResult));
		}
	}
	@RequestMapping("/test")
	public  void testMethod(HttpServletRequest request,HttpServletResponse response){
		try {
			response.getWriter().println("hello will");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 熔断返回
	 * @return
	 * 2018年8月17日
	 * WritingSend
	 * @throws IOException 
	 */
	public void failMethod(HttpServletRequest request,HttpServletResponse response,String paramstr) throws IOException{
		WritingSend sendResult = new WritingSend();
		sendResult.setState(UbiConstant.FAIL_CODE);
		sendResult.setMessage(UbiConstant.SYSTEM_ERROR);
		response.getWriter().println(JSON.toJSONString(sendResult));
	}
}
