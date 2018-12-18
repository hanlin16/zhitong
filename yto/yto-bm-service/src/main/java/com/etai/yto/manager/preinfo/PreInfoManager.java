package com.etai.yto.manager.preinfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.etai.yto.mapper.preinfo.PreInfoMapper;
import com.etai.yto.model.preinfo.PreInfoModel;

@Component("preInfoManager")
public class PreInfoManager {

	@Autowired
	private PreInfoMapper preInfoMapper;
	
	public void addPreInfo(PreInfoModel preInfo){
		
		preInfoMapper.addPreInfo(preInfo);
	}
	public PreInfoModel queryByLicenceNo(String licenceNo){
		
		return preInfoMapper.queryByLicenceNo(licenceNo);
	}
	public void updatePreInfoByLicence(PreInfoModel preInfo){
		preInfoMapper.updatePreInfoByLicence(preInfo);
	}
	
}
