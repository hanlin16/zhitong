package com.etai.yto.utils;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;

public class SendMailUtil {
	private static Logger  logger = LoggerFactory.getLogger(SendMailUtil.class);
	/**
	 * 获取堆栈信息
	 */
	public static String printStackTraceToString(Throwable t) {
	    StringWriter sw = new StringWriter();
	    t.printStackTrace(new PrintWriter(sw, true));
	    return sw.getBuffer().toString();
	}
	public static void sendMail(String title,String context,String message,String messageCode,String messageUrl){
		try {
			if(messageCode==null || "".equals(messageCode) || messageUrl==null || "".equals(messageUrl)){
				logger.error("发送邮件异常...消息code或url为空");
				return ;
			}
			JSONObject jsonStr = new JSONObject();
			jsonStr.put("messageCode", messageCode);
    		jsonStr.put("mailTopic", title);
    		jsonStr.put("mailContent", context);
    		if (!StringUtils.isEmpty(message)) {//短信设置
    			List<String> smsDynContent = new ArrayList<>();
        		smsDynContent.add(message);
        		jsonStr.put("smsDynContent", smsDynContent);
			}
    		//设置邮箱
    		jsonStr.put("produceTime",new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    		HttpClient.httpPostWithJson(messageUrl,jsonStr.toString());
		} catch (Exception e) {
			logger.error("邮件发送失败：", e);
		}
	}
	
	
	public static void sendMail(String title,String context,String message,String messageCode,String messageUrl,Throwable t){
		try {
			if(messageCode==null || "".equals(messageCode) || messageUrl==null || "".equals(messageUrl)){
				logger.error("发送邮件异常...消息code或url为空");
				return ;
			}
			if (t!=null) {
				context+=printStackTraceToString(t);
			}
			JSONObject jsonStr = new JSONObject();
			jsonStr.put("messageCode", messageCode);
    		jsonStr.put("mailTopic", title);
    		jsonStr.put("mailContent", context);
    		if (!StringUtils.isEmpty(message)) {//短信设置
    			List<String> smsDynContent = new ArrayList<>();
        		smsDynContent.add(message);
        		jsonStr.put("smsDynContent", smsDynContent);
			}
    		//设置邮箱
    		jsonStr.put("produceTime",new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    		HttpClient.httpPostWithJson(messageUrl,jsonStr.toString());
		} catch (Exception e) {
			logger.error("邮件发送失败：", e);
		}
	}
	
	public static void sendBuinessInfo(String title,String context,String messageCode,String messageUrl, List<String> mailReceivers){
		try {
			if(messageCode==null || "".equals(messageCode) || messageUrl==null || "".equals(messageUrl)){
				logger.error("发送邮件异常...消息code或url为空");
				return ;
			}
			
			JSONObject jsonStr = new JSONObject();
			jsonStr.put("messageCode", messageCode);
    		jsonStr.put("mailTopic", title);
    		jsonStr.put("mailContent", context);
    		jsonStr.put("mailReceiver", mailReceivers);
    		//设置邮箱
    		jsonStr.put("produceTime",new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    		HttpClient.httpPostWithJson(messageUrl,jsonStr.toString());
		} catch (Exception e) {
			logger.error("邮件发送失败：", e);
		}
	}
}
