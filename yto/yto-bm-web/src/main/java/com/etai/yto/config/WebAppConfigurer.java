package com.etai.yto.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.etai.yto.interceptor.AuthInterceptor;

@Configuration
public class WebAppConfigurer extends WebMvcConfigurerAdapter {

    /**
     * 增加拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 多个拦截器组成一个拦截器链
        // addPathPatterns 用于添加拦截规则
        // excludePathPatterns 用户排除拦截
        registry.addInterceptor(new AuthInterceptor())
        .excludePathPatterns("/login")
        .excludePathPatterns("/viewLogin")
        .excludePathPatterns("/logout")
        .addPathPatterns("/**");
        super.addInterceptors(registry);
    }

}
