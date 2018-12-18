package com.etai.yto.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.etai.yto.mapper.personinfo.PersonInfoMapper;
import com.etai.yto.model.underwriting.PersonInfo;

@Component
public class PersonInfoManager {

	@Autowired
	PersonInfoMapper personInfoMapper;
	
	public PersonInfo getPersionInfo(String bizId) {
		return personInfoMapper.getPersionInfo(bizId);
	}
}
