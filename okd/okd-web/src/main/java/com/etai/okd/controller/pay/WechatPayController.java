package com.etai.okd.controller.pay;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBException;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.etai.okd.api.model.OrderInfoModel;
import com.etai.okd.api.model.PayResultResponse;
import com.etai.okd.api.model.UnifiedOrderRequestModel;
import com.etai.okd.api.model.UnifiedOrderResponseModel;
import com.etai.okd.api.service.FeignDeviceApplyService;
import com.etai.okd.api.util.HttpClientUtils;
import com.etai.okd.api.util.JAXBUtils;
import com.etai.okd.api.util.MD5Util;
import com.etai.okd.api.util.Sign;
import com.etai.yto.model.device.DeviceApply;
import com.etai.yto.page.RemoteResult;

/**
 * 调用微信统一下单接口
 * @author king
 *
 */
@RequestMapping(value="/pay")
@Controller
public class WechatPayController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
//	private static final String APPID = "wxdc505606067574e7";
//	private static final String MCH_ID = "1513680891";
//	private static final String KEY = "ab7d753610f34a349575f8c8cf08d199";
//	private static final String SECRET = "f281c84d6a7f5ef064c8f145cea511b9";
//	private static final String CALLURL = "http://ubi.ztwltech.com/pay/callPay";
//	private static final String WECHAT_AUTHORIZE_URL = "https://open.weixin.qq.com/connect/oauth2/authorize";
//	private static final String WECHAT_ORDER_URL = "https://api.mch.weixin.qq.com/pay/unifiedorder";
//	private static final String CALL_PAYRESULT_URL = "http://ubi.ztwltech.com/pay/callPayResult";
//	private static final String WECHAT_TOKEN_URL = "https://api.weixin.qq.com/sns/oauth2/access_token";
	
	@Value("${business.url.callurl}")
	private String CALLURL;
	@Value("${business.url.call_payresult_url}")
	private String CALL_PAYRESULT_URL;
	@Value("${business.url.wechat_authorize_url}")
	private String WECHAT_AUTHORIZE_URL;
	@Value("${business.url.wechat_order_url}")
	private String WECHAT_ORDER_URL;
	@Value("${business.url.wechat_token_url}")
	private String WECHAT_TOKEN_URL;
	@Value("${business.account.appId}")
	private String APPID;
	@Value("${business.account.mch_id}")
	private String MCH_ID;
	@Value("${business.account.key}")
	private String KEY;
	@Value("${business.account.secret}")
	private String SECRET;
	@Value("${business.url.device_url}")
	private String deviceUrl;
	@Value("${business.url.wechat_jssdk_token}")
	private String sdkTokenUrl;
	@Value("${business.url.wechat_jsapi_ticket}")
	private String jsapiTicketUrl;
	
	@Autowired
	private FeignDeviceApplyService deviceApplyService;
	
	@RequestMapping(value="/payPage")
	public ModelAndView payPage(HttpServletRequest request) throws UnsupportedEncodingException{
		logger.error("支付页面跳转开始:");
		ModelAndView mov = new ModelAndView();
		mov.setViewName("/pay/wechatPay");
		HashMap<String,Object> map = new HashMap<>();
		//组装请求openId地址
		String encodeUrl = URLEncoder.encode(CALLURL, "utf-8");
		String order = request.getParameter("orderNo");
		String url = WECHAT_AUTHORIZE_URL+"?appid="+APPID+"&redirect_uri="+encodeUrl+"&response_type=code&scope=snsapi_base&state="+order+"#wechat_redirect";
		map.put("url", url);
		map.put("orderNo", order);
		mov.addAllObjects(map);
		
		return mov;
		
	}
	@RequestMapping("/callPay")
	public ModelAndView callWeChatOrder(HttpServletRequest req) throws Exception{
		
		//订单信息先写死做支付调试
		 OrderInfoModel order = new OrderInfoModel();
		order.setPayMoney("200");
		String state = req.getParameter("state");//业务号
		order.setOrderNo(state);
		order.setNumber("1");
		//拿到获取openID的code
		String code = req.getParameter("code");
		if(StringUtils.isEmpty(code)){
			throw new RuntimeException("微信获取openID异常!");
		}
		logger.error("code值:"+code);
		//通过code调用微信https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code
		//拿到openid
		//组装请求地址
		String tokenUrl = WECHAT_TOKEN_URL+"?appid="+APPID+"&secret="+SECRET+"&code="+code+"&grant_type=authorization_code";
		String respStr = null;
		try {
			
			respStr = HttpClientUtils.httpGet(tokenUrl, null, null);
			logger.error("调用微信token接口返回信息:"+respStr);
		} catch (Exception e) {
			logger.error("调用微信token接口异常:"+respStr);
			throw new RuntimeException("微信获取openID异常!");
		}
		
		if(StringUtils.isBlank(respStr)){
			throw new RuntimeException("微信获取openID异常!");
		}
		Map<String , String> mapToken = (Map<String , String>)JSON.parse(respStr);
		String openId = mapToken.get("openid");
		if(StringUtils.isBlank(openId)){
			logger.error("调用微信token接口返回信息:"+respStr);
			throw new RuntimeException("微信获取openID异常!");
		}
		logger.error("openId值:"+openId);
		
		UnifiedOrderRequestModel request = createOrderRequest(order,req,openId);
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>";
		String xml = JAXBUtils.convertObjectToXML(request);
		xml = xml.replace(header, "").replace("\n", "");
		String responseStr;
		try {
			logger.error("调用微信统一下单接口请求参数信息:"+xml);
			responseStr = HttpClientUtils.httpPost(WECHAT_ORDER_URL, xml, "utf-8", 120, "application/xml", "utf-8");
			logger.error("调用微信统一下单接口返回信息:"+responseStr);
		} catch (Exception e) {
			logger.error("调用微信统一下单接口异常:",e);
			throw new RuntimeException("调用微信统一下单接口异常!");
		}
		
		if(StringUtils.isEmpty(responseStr)){
			throw new RuntimeException("请求微信支付统一下单接口异常!");
		}
		responseStr= header+responseStr;
		logger.error("返回调用支付参数对象:"+responseStr);
		UnifiedOrderResponseModel resonse = JAXBUtils.convertXMLToObject(UnifiedOrderResponseModel.class, responseStr);
		logger.error("返回调用支付参数对象:"+resonse);
		String return_code = resonse.getReturn_code();
		ModelAndView mov = new ModelAndView();
		mov.setViewName("/pay/wechatPay1");
		HashMap<String,Object> map = new HashMap<>();
		if("SUCCESS".equals(return_code)){//下单成功
			String prepay_id = resonse.getPrepay_id();
			
			RemoteResult<DeviceApply> remoteResult = deviceApplyService.queryDeviceApplyInfoByBizNo(state);
			if(remoteResult.isSuccess()){
				DeviceApply data = remoteResult.getData();
				if(data!=null){
//					map.put("actionCode", data.getActionCode());
//					map.put("channelCode", data.getChannelCode());
					map.put("url", deviceUrl+"?channelCode="+data.getChannelCode()+"&actionCode="+data.getActionCode());
				}
			}
			
			map.put("appId1", APPID);
			map.put("timeStamp", System.currentTimeMillis()/1000);
			map.put("nonceStr", UUID.randomUUID().toString().substring(24).toUpperCase());
			map.put("package", "prepay_id="+prepay_id);
			map.put("signType", "MD5");
			
			map.put("paySign", getSign(map));
			map.put("state", "order");
		}
		logger.error("返回调用支付参数:"+map);
		mov.addAllObjects(map);
		return mov;
		
	}

	private UnifiedOrderRequestModel createOrderRequest(OrderInfoModel order,HttpServletRequest req,String openId) {
		UnifiedOrderRequestModel request = new UnifiedOrderRequestModel();
		request.setAppid(APPID);
		request.setMch_id(MCH_ID);
		request.setNonce_str(UUID.randomUUID().toString().substring(24).toUpperCase());
		request.setBody("易通-支付押金");
		request.setOut_trade_no(order.getOrderNo());
//		request.setTotal_fee(Integer.valueOf(order.getPayMoney())*100);//需要转换成分为单位的数字.
		request.setTotal_fee(20000);//需要转换成分为单位的数字.
		request.setSpbill_create_ip(req.getLocalAddr());  //客户端Ip
		request.setTrade_type("JSAPI");
		request.setNotify_url(CALL_PAYRESULT_URL);
		request.setOpenid(openId);
		request.setSign_type("MD5");
		//加密算法
		String sign = getSign(request);
		request.setSign(sign);
		return request;
		
	}
	/**
	 * 加密算法
	 * @param request
	 */
	private String getSign(UnifiedOrderRequestModel request) {
		
		String mapStr = "appid="+request.getAppid()+"&body="+request.getBody()+"&mch_id="+request.getMch_id()
		+"&nonce_str="+request.getNonce_str()+"&notify_url="+request.getNotify_url()+"&openid="+request.getOpenid()
		+"&out_trade_no="+request.getOut_trade_no()+"&sign_type="+request.getSign_type()+"&spbill_create_ip="+request.getSpbill_create_ip()
		+"&total_fee="+request.getTotal_fee()+"&trade_type="+request.getTrade_type()+"&key="+KEY;
		
		String md5Hex;
		try {
			logger.error("加密前算法:"+mapStr);
//			md5Hex = DigestUtils.md5Hex(mapStr.getBytes("UTF-8"));
			md5Hex = MD5Util.MD5Encode(mapStr, "UTF-8");
			logger.error("加密前算法:"+md5Hex);
		} catch (Exception e) {
			throw new RuntimeException("MD5签名过程中出现错误");
		}
		
		return md5Hex.toUpperCase();
	}
	/**
	 * 加密算法
	 * @param request
	 */
	private String getSign(Map<String, Object> map) {
		
		String mapStr = "appId="+map.get("appId1")+"&nonceStr="+map.get("nonceStr")+"&package="+map.get("package")
		+"&signType="+map.get("signType")+"&timeStamp="+map.get("timeStamp")+"&key="+KEY;
		
		String md5Hex;
		try {
			logger.error("加密前算法:"+mapStr);
			md5Hex = DigestUtils.md5Hex(mapStr.getBytes("UTF-8"));
			logger.error("加密前算法:"+md5Hex);
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException("MD5签名过程中出现错误");
		}
		
		return md5Hex.toUpperCase();
	}
	/**
	 * 加密算法
	 * @param request
	 */
	private String getSignForMap(SortedMap<String, Object> map) {
		
		Set<Entry<String, Object>> entry2 = map.entrySet();
		StringBuffer buffer = new StringBuffer();
		for(Entry<String, Object> temp : entry2){
			if("sign".equals(temp.getKey())){
				continue;
			}
			
			if("appid".equals(temp.getKey())){
				
				buffer.append(temp.getKey()+"="+temp.getValue());
			}else{
				
				buffer.append("&"+temp.getKey()+"="+temp.getValue());
			}
		}
		buffer.append("&key="+KEY);
		
		String mapStr = buffer.toString();

		String md5Hex;
		try {
			logger.error("加密前:"+mapStr);
			md5Hex = DigestUtils.md5Hex(mapStr.getBytes("UTF-8"));
			logger.error("加密后:"+md5Hex);
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException("MD5签名过程中出现错误");
		}
		
		return md5Hex.toUpperCase();
	}
	
//	@RequestMapping
//	public String payMoney(HttpServletRequest request) {
//		String code = request.getParameter("code");
//		Http.post("https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code")
//		// 获取到openId
//		
//		//统一下单接口
//		Http.post()
//		//返回到页面中
//		
//	}

	@RequestMapping("/callPayResult")
	public void callBackController(HttpServletRequest request,HttpServletResponse response) throws Exception{
//		public void callBackController(@ RequestBody String payResult){
		logger.error("微信支付回调成功:");
		String info = "<xml><return_code><![CDATA[SUCCESS]]></return_code><return_msg><![CDATA[OK]]></return_msg></xml>";
		String errorInfo = "<xml><return_code><![CDATA[FAIL]]></return_code><return_msg><![CDATA[验签失败]]></return_msg></xml>";
		InputStream is = null;
        try
        {
            is = request.getInputStream();
            StringBuilder sb = new StringBuilder();
            byte[] b = new byte[4096];
            for (int n; (n = is.read(b)) != -1;)
            {
                sb.append(new String(b, 0, n));
            }
            //微信支付回调信息
            logger.error("支付回调信息:"+sb.toString());
            String result = sb.toString();
            PayResultResponse payResult = new PayResultResponse();
			try {
				payResult = JAXBUtils.convertXMLToObjectForNa(PayResultResponse.class, result);
				logger.error("支付回调信息对象:"+payResult);
			} catch (JAXBException e) {
				logger.error("支付回调异常:",e);
			}
            
            if(payResult!=null && "SUCCESS".equals(payResult.getReturn_code()) && "SUCCESS".equals(payResult.getResult_code())){
            	String orderNo = payResult.getOut_trade_no();
            	String sign = payResult.getSign();
            	String result_code = payResult.getResult_code();
            	
            	SortedMap<String, Object> map = (SortedMap<String, Object>) JAXBUtils.convertToMap(payResult);
            	String signForMap = getSignForMap(map);
            	if(StringUtils.isEmpty(sign) || !sign.equals(signForMap)){
            		response.getWriter().println(errorInfo);
            		return;
            	}
            	logger.error("查询订单开始:");
            	RemoteResult<DeviceApply> remoteResult = deviceApplyService.queryDeviceApplyInfoByBizNo(orderNo);
            	if(remoteResult.isSuccess()){
            		String payStatus = remoteResult.getData().getPayStatus();//支付状态
            		logger.error("查询订单开始:"+remoteResult.getData());
            		if("1".equals(payStatus)&& "SUCCESS".equals(result_code)){//待支付,返回值是success
            			DeviceApply device = new DeviceApply();
            			device.setBizNo(orderNo);
            			device.setPayStatus("2");//支付成
            			
            			logger.error("更新设备申领数据:"+device);
            			deviceApplyService.deviceapplyUpdate(device);
            			
            		}
            	}
            }
        }
        catch (IOException e)
        {
        	 logger.error("支付回调异常:",e);
        }
        finally
        {
            if (null != is)
            {
                try
                {
                    is.close();
                }
                catch (IOException e)
                {
                	 logger.error("支付回调异常:",e);
                }
            }
        }
        response.getWriter().println(info);

	}
	/**
	 * 生产验签方法
	 * @return
	 */
	@RequestMapping("/signature")
	@ResponseBody
	public String signature(HttpServletRequest request,String json){
		logger.error("开始验签参数:"+json);
		logger.error("开始验签参数:"+request.getParameter("url"));
//		Map<String,Object> map = new HashMap<>();
		//第一步要获取jssdk的access_token jsapiTicket
		String tokenUrl= sdkTokenUrl+"?grant_type=client_credential&appid="+APPID+"&secret="+SECRET;
		logger.error("请求地址:"+tokenUrl);
		String response = HttpClientUtils.httpGet(tokenUrl, null, null);
		logger.error("返回信息::"+response);
		Map mapResponse = (Map) JSON.parse(response);
		String access_token = (String) mapResponse.get("access_token");
		
		String ticketUrl = jsapiTicketUrl+"?access_token="+access_token+"&type=jsapi";
		logger.error("请求地址1:"+tokenUrl);
		String responseToken = HttpClientUtils.httpGet(ticketUrl, null, null);
		logger.error("返回信息1::"+responseToken);
		Map mapResponseToken = (Map) JSON.parse(responseToken);
		String ticket = (String) mapResponseToken.get("ticket");
		String url = request.getParameter("url");
		Map<String, String> sign = Sign.sign(ticket, url);
		sign.put("appid", APPID);
		
//		SortedMap<String, Object> map = new TreeMap<String,Object>();
//		map.put("appid", APPID);
//		map.put("timestamp", System.currentTimeMillis()/1000);
//		map.put("noncestr", UUID.randomUUID().toString().substring(24).toUpperCase());
//		
//		map.put("signature", getSignForMap((SortedMap<String, Object>) map));
		return JSON.toJSONString(sign);
	}
	
	public static void main(String[] args) throws JAXBException, UnsupportedEncodingException {
//		System.out.println("随机数"+UUID.randomUUID().toString().substring(24).toUpperCase());
//		String money="200";
//		System.out.println(Integer.valueOf(money)*100);
//		UnifiedOrderRequestModel request = new UnifiedOrderRequestModel();
//		request.setAppid(APPID);
//		request.setMch_id(MCH_ID);
//		request.setNonce_str(UUID.randomUUID().toString().substring(24).toUpperCase());
//		request.setBody("易通-支付押金");
//		request.setOut_trade_no("123");
//		request.setTotal_fee(200);//需要转换成分为单位的数字.
//		request.setSpbill_create_ip("192.168.0.1");  //客户端Ip
//		request.setTrade_type("JSAPI");
//		request.setNotify_url(CALL_PAYRESULT_URL);
//		
//		OrderInfoModel model = new OrderInfoModel();
//		model.setPayMoney("200");
//		model.setNumber("1");
//		model.setOrderNo("11");
//		model.setPayType("1");
//		model.setProductName("mizi");
//		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>";
//		String xml = JAXBUtils.convertObjectToXML(request);
//		xml = xml.replace(header, "").replace("\n", "");
//		UnifiedOrderRequestModel object = JAXBUtils.convertXMLToObject(UnifiedOrderRequestModel.class, xml);
//		System.out.println(System.currentTimeMillis()/1000);
//		System.currentTimeMillis();
//		HashMap<Object,Object> map = new HashMap<>();
//		map.put("key", "1");
//		map.put("key2", "2");
//		System.out.println("55:"+map);
		String abc = "appid=wxdc505606067574e7&nonce_str=43C911F57112&package=prepay_id=wx1718450744452322646d99632861350045&signType=MD5&timeStamp=1537181107&key=ab7d753610f34a349575f8c8cf08d199";

//		System.out.println(JAXBUtils.convertXMLToObject(UnifiedOrderResponseModel.class, abc));
//				String encode = MD5Util.MD5Encode(abc, "UTF-8");
		String encode = DigestUtils.md5Hex(abc.getBytes("UTF-8"));;
//		System.out.println(encode.toUpperCase());
		System.out.println(new StringBuffer().append("123"));
	}
}
