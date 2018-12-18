package com.etai.yto.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.etai.yto.page.RemoteResult;

@ControllerAdvice(annotations=RestController.class)
public class AjaxExceptionHandler {
	
	private static final Logger logger = LoggerFactory.getLogger(AjaxExceptionHandler.class);
	 
	@ExceptionHandler(Exception.class)
    @ResponseBody
    public RemoteResult<Object> handle(Exception e) {
		StringWriter sw = new StringWriter();
		e.printStackTrace(new PrintWriter(sw, true));
        logger.error("全局异常Ajax处理: " + sw.getBuffer().toString());
        RemoteResult<Object> result = new RemoteResult<>();
        result.setErrorMsg("系统发生错误，请联系管理员。。。");
        result.setSuccess(false);
        return result;
    }
}

