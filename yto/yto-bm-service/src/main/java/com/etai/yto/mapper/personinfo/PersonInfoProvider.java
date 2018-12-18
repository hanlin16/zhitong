package com.etai.yto.mapper.personinfo;

import org.apache.ibatis.annotations.Param;

public class PersonInfoProvider {
	
	public String getPersionInfo(@Param("bizId") String bizId) {
		StringBuffer sb = new StringBuffer();
		sb.append(" SELECT applicant_name,\n" + 
				" applicantId_no,applicant_mobile,\n" + 
				" insured_name,insuredId_no,\n" + 
				" insured_mobile,insured_address,\n" + 
				" addressee_name,addressee_mobile,\n" + 
				" addressee_details,policy_email\n" + 
				" FROM t_policy_person where zt_biz_id =#{bizId}");
		return sb.toString();
	}
}
