package com.etai.yto.mapper.partyinfo;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.etai.yto.model.partyinfo.PartyInfo;

public interface PartyInfoMapper {

	@Insert(" insert into t_party_info(code,phone_no,name, email, create_time  ) "
			+ " values(#{code}, #{phoneNo}, #{name}, #{email}, #{createTime})")
	void insertPartyInfo(PartyInfo partyInfo);

	@Select("select max(code) from t_party_info")
	Integer getMaxPartyInfoCode();

	@Select("select id,code,phone_no,name, email, create_time from t_party_info where phone_no=#{phoneNo}")
	PartyInfo getPartyInfoByPhoneNo(String phoneNo);

	@Update(" update t_party_info set name=#{name},email=#{email} where phone_no=#{phoneNo}")
	void updatePartyInfo(PartyInfo partyInfo);

}
