package com.etai.yto.mapper.city;

import org.apache.commons.lang3.StringUtils;

import com.etai.yto.mapper.BaseProvider;
import com.etai.yto.page.city.CityMappingPage;

public class CityMappingProvider extends BaseProvider {

	public String queryAreaCityPage(CityMappingPage page) {
		StringBuffer sb = new StringBuffer();
		sb.append("select "
				+ " id,areaName,areaCode,areaLevel,areaSeq,areaLeaf,areaState,areaParentId"
				+ " from t_base_areaconfig where 1=1 ");
		if(StringUtils.isNotEmpty(page.getId())) {
			sb.append(" and id = #{id}");
		}
		if(StringUtils.isNotEmpty(page.getAreaLevel())) {
			sb.append(" and areaLevel = #{areaLevel}");
		}
		if(StringUtils.isNotEmpty(page.getAreaParentId())) {
			sb.append(" and areaParentId = #{areaParentId}");
		}
//		if (page.getPager()!=null && StringUtils.isNotEmpty(page.getPager().getMysqlQueryCondition())) {
//			return queryWithPage(sb.toString(), page.getPager().getMysqlQueryCondition());
//		}
		return sb.toString();
	}
	
	
}
