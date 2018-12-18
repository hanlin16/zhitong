package com.etai.yto.mapper.province;

import org.apache.commons.lang3.StringUtils;

import com.etai.yto.mapper.BaseProvider;
import com.etai.yto.page.province.ProvincePage;

public class ProvinceProvider extends BaseProvider {

	public String queryProvincesPage(ProvincePage page) {
		StringBuffer sb = new StringBuffer();
		sb.append("select "
				+ " pro_id, province, spelling, pro_id_gb "
				+ " from t_base_province where 1=1 ");
		if(StringUtils.isNotEmpty(page.getProvince())) {
			sb.append(" and province like #{province} ");
		}
		if(StringUtils.isNotEmpty(page.getSpelling())) {
			sb.append(" and spelling like #{spelling}");
		}
		if (page.getPager()!=null && StringUtils.isNotEmpty(page.getPager().getMysqlQueryCondition())) {
			return queryWithPage(sb.toString(), page.getPager().getMysqlQueryCondition());
		}
		return sb.toString();
	}
	
	public String queryProvinceCount(ProvincePage page) {
		StringBuffer sb = new StringBuffer();
		sb.append("select count(1) from  t_base_province where 1=1 ");
		if(StringUtils.isNotEmpty(page.getProvince())) {
			sb.append(" and province like #{province} ");
		}
		if(StringUtils.isNotEmpty(page.getSpelling())) {
			sb.append(" and spelling like #{spelling} ");
		}
		return sb.toString();
	}	
}
