package com.etai.yto.interceptor;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.etai.yto.model.user.User;
import com.fasterxml.jackson.databind.ObjectMapper;


/**
 * 权限拦截器
 */
@Component 
public class AuthInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		System.out.println(request.getRequestURL().toString());
		if(handler instanceof HandlerMethod) {
			HandlerMethod method = (HandlerMethod) handler;
			Auth auth = method.getMethod().getAnnotation(Auth.class);
			// //验证登陆超时问题 auth = null，默认验证
			if (auth == null || auth.verifyLogin()) {
				String baseUri = request.getContextPath();
				HttpSession session = request.getSession();
				User user = (User) session.getAttribute("currentUser");
				if (user == null) {
					String header = request.getHeader("X-Requested-With");  
				    boolean isAjax = "XMLHttpRequest".equals(header) ? true:false;
				    if(isAjax) {
				    	response.setContentType("application/json");
				    	response.addHeader("Content-Type","application/json;charset=UTF-8");
				    	response.setHeader("Pragma", "No-cache");
						response.setHeader("Cache-Control", "no-cache");
						response.setCharacterEncoding("UTF-8");
						PrintWriter out = response.getWriter();
						ObjectMapper mapper = new ObjectMapper();
						Map<String, Object> result = new HashMap<>();
						result.put("success", false);
						result.put("errorMsg", "当前用户身份过期，请重新登录!");
						String valueAsString = mapper.writeValueAsString(result);
						out.print(valueAsString);
						out.flush();
				    }else {
				    	response.setStatus(HttpServletResponse.SC_GATEWAY_TIMEOUT);
						response.sendRedirect(baseUri + "/viewLogin");
				    }
					return false;
				}
			}
		}
		
		response.addHeader("Access-Control-Expose-Headers","Roleplay-Error-Code");
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "GET,POST,PUT,DELETE,OPTIONS");
		response.addHeader("Access-Control-Allow-Credentials", "true");
		response.addHeader("Access-Control-Allow-Headers",
		 "Origin, Content-Type, Accept, Authorization, x-requested-with, cache-control, Access-Control-Allow-Origin, Access-Control-Allow-Credentials, uuid");
		return super.preHandle(request, response, handler);
	}
}
