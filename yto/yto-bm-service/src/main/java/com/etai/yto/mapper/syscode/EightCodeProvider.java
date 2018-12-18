package com.etai.yto.mapper.syscode;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

import com.etai.yto.model.syscode.EightCode;

public class EightCodeProvider {
	
	/**
	 * 保存随机码
	 * @param eightCode
	 * 2018年9月13日
	 * void
	 */
	public String insertEightCode(final @Param("eightCode") EightCode eightCode){
		return new SQL(){
			{
				INSERT_INTO("t_sys_8bcode");
				VALUES("CODE", "#{eightCode.code,jdbcType=VARCHAR}");
				VALUES("STATUS", "#{eightCode.status,jdbcType=VARCHAR}");
				VALUES("CREATE_TIME", "#{eightCode.createTime,jdbcType=VARCHAR}");
				VALUES("CREATE_USER", "#{eightCode.createUser,jdbcType=VARCHAR}");
				VALUES("BATCH_NO", "#{eightCode.batchNo,jdbcType=VARCHAR}");
			}
		}.toString();
	}
	/**
	 * 更新随机码状态
	 * @param eightCode
	 * 2018年9月13日
	 * void
	 */
	public String UpdateEightCode(final @Param("eightCode") EightCode eightCode){
		return new SQL(){
			{
				UPDATE("t_sys_8bcode");
				SET("USE_TIME=#{eightCode.useTime,jdbcType=VARCHAR}");
				SET("STATUS=#{eightCode.status,jdbcType=VARCHAR}");
				WHERE("id=#{eightCode.id,jdbcType=VARCHAR}");
				
			}
		}.toString();
	}

}
