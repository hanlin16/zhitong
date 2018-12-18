package com.etai.yto.manager.partyinfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.etai.yto.mapper.partyinfo.PartyInfoMapper;
import com.etai.yto.model.partyinfo.PartyInfo;

@Component
public class PartyInfoManager {

	@Autowired
	PartyInfoMapper partyInfoMapper;
	
	@Transactional(rollbackFor=Exception.class)
	public void insertPartyInfo(PartyInfo partyInfo) {
		partyInfoMapper.insertPartyInfo(partyInfo);
	}
	
	public Integer getMaxPartyInfoCode() {
		return partyInfoMapper.getMaxPartyInfoCode();
	}

	public PartyInfo getPartyInfoByPhoneNo(String phoneNo) {
		return partyInfoMapper.getPartyInfoByPhoneNo(phoneNo);
	}

	@Transactional(rollbackFor=Exception.class)
	public void updatePartyInfo(PartyInfo partyInfo) {
		partyInfoMapper.updatePartyInfo(partyInfo);
	}
}
