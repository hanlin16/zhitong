package com.etai.yto.mapper.syscode;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.UpdateProvider;

import com.etai.yto.model.syscode.EightCode;
@Mapper
public interface EightCodeMapper {

	/**
	 * 保存随机码
	 * @param eightCode
	 * 2018年9月13日
	 * void
	 */
	@InsertProvider(type=EightCodeProvider.class,method="insertEightCode")
	public void insertEightCode(@Param("eightCode") EightCode eightCode);
	
	/**
	 * 获取一个未使用的随机码
	 * @return
	 * 2018年9月13日
	 * Integer
	 */
	@Select({
		
		" select code,id,status from t_sys_8bcode where status=0 order by rand() limit 1"
	})
	public EightCode queryEightCode();
	
	/**
	 * 更新随机码状态
	 * @param eightCode
	 * 2018年9月13日
	 * void
	 */
	@UpdateProvider(type=EightCodeProvider.class,method="UpdateEightCode")
	public void UpdateEightCode(@Param("eightCode") EightCode eightCode); 
	
}
