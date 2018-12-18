package com.etai.yto.mapper.personinfo;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;

import com.etai.yto.model.underwriting.PersonInfo;

public interface PersonInfoMapper {

	@SelectProvider(method="getPersionInfo", type=PersonInfoProvider.class)
	PersonInfo getPersionInfo(@Param("bizId") String bizId);
}
