package com.etai.yto;

import java.io.UnsupportedEncodingException;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.PropertySource;

import com.etai.yto.api.syscode.EightCodeService;

@EnableDiscoveryClient
@SpringBootApplication
@MapperScan("com.etai.yto.mapper")
public class YtoClientApplication {
	
	@Autowired
	EightCodeService eightCodeService;

    public static void main(String[] args) throws UnsupportedEncodingException {
        SpringApplication.run(YtoClientApplication.class);
    }
}
