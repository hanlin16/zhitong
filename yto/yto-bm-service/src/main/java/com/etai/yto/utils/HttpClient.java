package com.etai.yto.utils;

import java.nio.charset.Charset;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpClient {
	
	private static Logger logger = LoggerFactory.getLogger(HttpClient.class);
	
	public static boolean httpPostWithJson(String url,String jsonObj){
	    boolean isSuccess = false;
	    HttpPost post = null;
	    try {
	    	CloseableHttpClient httpClient = HttpClientBuilder.create().build();
	        // 设置超时时间
	    	RequestConfig config = RequestConfig.custom()
	    			.setConnectTimeout(90*1000)
	    			.setSocketTimeout(90*1000).build();
	        post = new HttpPost(url);
	        post.setConfig(config);
	        // 构建消息实体
	        StringEntity entity = new StringEntity(jsonObj, Charset.forName("UTF-8"));
	        entity.setContentEncoding("UTF-8");
            entity.setContentType("application/json");
	        post.setEntity(entity);
	            
	        HttpResponse response = httpClient.execute(post);
	            
	        // 检验返回码
	        int statusCode = response.getStatusLine().getStatusCode();
	        if(statusCode != HttpStatus.SC_OK){
	            isSuccess = false;
	        }
	        isSuccess = true;
	    } catch (Exception e) {
	    	logger.error("HttpClient发送json失败", e);
	        isSuccess = false;
	    }finally{
	        if(post != null){
	            try {
	                post.releaseConnection();
	                Thread.sleep(500);
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	    return isSuccess;
	}
}
