package com.etai.yto.mapper.preinfo;

import com.etai.yto.model.preinfo.PreInfoModel;

public class PreInfoProvider {

	public String addPreInfo(PreInfoModel model) {
		StringBuffer sb = new StringBuffer();
		sb.append(" insert into t_policy_pre_info("
				+ " licence_no, action_code ) values (" + 
				" #{licenceNo},#{actionCode} )");
		return sb.toString();
	}
	public String queryByLicenceNo(String licenceNo){
		
		StringBuffer sb = new StringBuffer();
		sb.append(" select "
				+ " licence_no, action_code from t_policy_pre_info" + 
				" where licence_no =#{licenceNo} ");
		return sb.toString();
		
	}
	public String updatePreInfoByLicence(PreInfoModel model) {
		StringBuffer sb = new StringBuffer();
		sb.append(" update t_policy_pre_info "
				+ " set action_code=#{actionCode} where licence_no =#{licenceNo}  ");
		return sb.toString();
	}
}
