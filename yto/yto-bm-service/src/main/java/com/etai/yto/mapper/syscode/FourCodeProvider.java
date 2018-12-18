package com.etai.yto.mapper.syscode;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

import com.etai.yto.model.syscode.FourCode;

public class FourCodeProvider {
	
	/**
	 * 保存随机码
	 * @param FourCode
	 * 2018年9月13日
	 * void
	 */
	public String insertFourCode(final @Param("FourCode") FourCode FourCode){
		return new SQL(){
			{
				INSERT_INTO("t_sys_d4code");
				VALUES("CODE", "#{FourCode.code,jdbcType=VARCHAR}");
				VALUES("STATUS", "#{FourCode.status,jdbcType=VARCHAR}");
				VALUES("CREATE_TIME", "#{FourCode.createTime,jdbcType=VARCHAR}");
				VALUES("CREATE_USER", "#{FourCode.createUser,jdbcType=VARCHAR}");
				VALUES("BATCH_NO", "#{FourCode.batchNo,jdbcType=VARCHAR}");
			}
		}.toString();
	}
	/**
	 * 更新随机码状态
	 * @param FourCode
	 * 2018年9月13日
	 * void
	 */
	public String UpdateFourCode(final @Param("FourCode") FourCode FourCode){
		return new SQL(){
			{
				UPDATE("t_sys_d4code");
				SET("USE_TIME=#{FourCode.useTime,jdbcType=VARCHAR}");
				SET("STATUS=#{FourCode.status,jdbcType=VARCHAR}");
				WHERE("id=#{FourCode.id,jdbcType=VARCHAR}");
				
			}
		}.toString();
	}

}
