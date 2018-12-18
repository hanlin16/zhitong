package com.etai.okd.controller.myEquipment;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.etai.okd.api.util.HttpClient;


@Controller
public class SmsController {
	
	private static Logger logger = LoggerFactory.getLogger(SmsController.class);
	
	@Value("${business.messageurl}")
	String messageurl;

	@RequestMapping("/sendSms")
	@ResponseBody
	public void sendSms(HttpSession session, String smsReceiver) {
		try {
			CloseableHttpClient httpClient = HttpClientBuilder.create().build();
			// 设置超时时间
			RequestConfig config = RequestConfig.custom()
					.setConnectTimeout(90*1000)
					.setSocketTimeout(90*1000).build();
			HttpPost post = new HttpPost(messageurl);
			post.setConfig(config);
			// 构建消息实体
			StringEntity entity = new StringEntity(smsReceiver, Charset.forName("UTF-8"));
			entity.setContentEncoding("UTF-8");
			entity.setContentType("application/json");
			post.setEntity(entity);
			HttpResponse response = httpClient.execute(post);
			InputStream content = response.getEntity().getContent();
			int available = content.available();
			byte[] bt = new byte[4096];
			content.read(bt, 0 , available);
			String smsCode = new String(bt);
			session.setAttribute("smsCode", smsCode.trim());
			logger.error("发送短信验证码："+smsReceiver+"内容："+smsCode);
		} catch (Exception e) {
			logger.error("短信发送失败", e);
		}
	}
}
