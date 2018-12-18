package com.etai.okd.api.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.params.CoreProtocolPNames;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;

public class HttpClientUtils {
	
	private static Logger logger = LoggerFactory.getLogger(HttpClientUtils.class);
	/**
	 * 默认编码 utf-8
	 */
	private static final String  DEFAULT_CHARSET = "UTF-8";
	/**
	 * 链接成功后等待响应返回的超时时间
	 */
	private static final int DEFAULT_SOCKET_TIMEOUT = 120;
	/**
	 * 请求链接的超时时间90秒
	 */
	private static final int DEFAULT_CONN_REQUEST_TIMEOUT = 120;
	
	/**
	 * 
	 * @param url
	 * @param jsonParam
	 * @param dataEncoding
	 * @param connRequestTimeout
	 * @param contentType
	 * @param contentEncode
	 * @return
	 * @throws Exception
	 */
	public static String httpPost(
			String url, 
			String jsonParam, 
			String dataEncoding, 
			int connRequestTimeout, 
			String contentType, 
			String contentEncode) throws Exception{
		if(StringUtils.isEmpty(url)){
    		throw new RuntimeException("请求地址为空！");
    	}
		CloseableHttpClient httpClient = HttpClients.createDefault();
		String resultInfo = null;
    	try{
    		//请求配置
    		RequestConfig.Builder builder = RequestConfig.custom();
    		builder.setConnectTimeout(connRequestTimeout*1000);
    		builder.setSocketTimeout(DEFAULT_SOCKET_TIMEOUT*1000);
    		
    		RequestConfig config = builder.build();
    		
    		HttpPost method = new HttpPost(url);
    		method.setConfig(config);
    		
    		if (null != jsonParam) {
    			//报文编码
    			StringEntity entity = new StringEntity(jsonParam.toString(), dataEncoding);
    			entity.setContentEncoding(contentEncode);
    			entity.setContentType(contentType);
    			method.setEntity(entity);
    		}
    		//执行请求
    		CloseableHttpResponse response = httpClient.execute(method);
    		//响应信息
    		resultInfo = getResultInfo(dataEncoding, response);
    	}finally{
    		if(httpClient!=null){
    			httpClient.close();
    		}
    	}
        
        return resultInfo;
    }
	private static String getResultInfo(String dataEncoding,
			HttpResponse response) throws IOException,
			UnsupportedEncodingException {
//		StringBuffer sb = new StringBuffer();
//    	InputStream in = response.getEntity().getContent();
//    	byte[] buff = new byte[1024];
//    	int n;
//    	while((n=in.read(buff)) != -1){
//    		sb.append(new String(buff, 0 ,n , dataEncoding));
//    	}
    	return EntityUtils.toString(response.getEntity(),dataEncoding);
//		return sb.toString();
	}
	
	/**
     * get请求
     * @param url         url地址
     * @param dataEncoding   数据编码（默认 UTF-8）
     * @param connectionTimeOut 连接超时时间 （单位：秒）
     * @return
     */
    public static String httpGet(String url,String dataEncoding,Integer connectionTimeOut){
    	if(StringUtils.isEmpty(dataEncoding)){
    		dataEncoding = DEFAULT_CHARSET;
    	}
    	if(connectionTimeOut==null){
    		connectionTimeOut = DEFAULT_CONN_REQUEST_TIMEOUT;
    	}
        //get请求返回结果
        DefaultHttpClient httpClient = new DefaultHttpClient();
        httpClient.getParams().setParameter(CoreProtocolPNames.HTTP_CONTENT_CHARSET, dataEncoding);  
        //连接超时时间
        if(connectionTimeOut != null && connectionTimeOut.intValue() > 0)
        	httpClient.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT,connectionTimeOut*1000);
        String jsonResult = null;
        HttpGet method = new HttpGet();
       
        try {
        	method.setURI(new URI(url));  
        	method.addHeader("Content-Type", "text/html;charset="+dataEncoding); 
        	method.getParams().setParameter(CoreProtocolPNames.HTTP_CONTENT_CHARSET, dataEncoding); 
            HttpResponse result = httpClient.execute(method);
            /**请求发送成功，并得到响应**/
            if (result.getStatusLine().getStatusCode() == 200) {
				jsonResult = EntityUtils.toString(result.getEntity(),dataEncoding);
            }else{
				JSONObject errInfo = new JSONObject();
				errInfo.put("BusinessStatus",result.getStatusLine().getStatusCode());
				errInfo.put("StatusMessage",EntityUtils.toString(result.getEntity()));
				jsonResult = errInfo.toJSONString();
			}
        } catch (Exception e) {
            logger.error("get请求提交失败:{}，{}" ,  e,jsonResult + url);
        }
        return jsonResult;
    }
	
}
