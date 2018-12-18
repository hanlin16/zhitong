package com.etai.yto.mapper.syscode;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.UpdateProvider;

import com.etai.yto.model.syscode.FourCode;
@Mapper
public interface FourCodeMapper {

	/**
	 * 保存随机码
	 * @param FourCode
	 * 2018年9月13日
	 * void
	 */
	@InsertProvider(type=FourCodeProvider.class,method="insertFourCode")
	public void insertFourCode(@Param("FourCode") FourCode FourCode);
	
	/**
	 * 获取一个未使用的随机码
	 * @return
	 * 2018年9月13日
	 * Integer
	 */
	@Select({
		
		" select code,id,status from t_sys_d4code where status=0 order by rand() limit 1"
	})
	public FourCode queryFourCode();
	
	/**
	 * 更新随机码状态
	 * @param FourCode
	 * 2018年9月13日
	 * void
	 */
	@UpdateProvider(type=FourCodeProvider.class,method="UpdateFourCode")
	public void updateFourCode(@Param("FourCode") FourCode FourCode); 
	
}
