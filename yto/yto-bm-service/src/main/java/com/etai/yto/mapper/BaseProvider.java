package com.etai.yto.mapper;

/**
 * 分页查询
 * @author liushengli
 * @date 2017年12月26日
 */
public class BaseProvider {
	public String queryWithPage(String baseSql,String conditon) {
        return baseSql+" "+conditon;
    }
}