package com.etai.yto.mapper.preinfo;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import com.etai.yto.model.preinfo.PreInfoModel;

public interface PreInfoMapper {

	@InsertProvider(method="addPreInfo", type=PreInfoProvider.class)
	public void addPreInfo(PreInfoModel preInfo);
	@SelectProvider(method="queryByLicenceNo",type=PreInfoProvider.class)
	public PreInfoModel queryByLicenceNo(String licenceNo);
	@UpdateProvider(method="updatePreInfoByLicence", type=PreInfoProvider.class)
	public void updatePreInfoByLicence(PreInfoModel preInfo);
	
}
