package com.etai.yto.manager.syscode;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.etai.yto.mapper.syscode.FourCodeMapper;
import com.etai.yto.model.syscode.FourCode;

@Component("FourCodeManager")
public class FourCodeManager {

	@Resource
	private FourCodeMapper fourCodeMapper;
	
	/**
	 * 保存随机码
	 */
	public void insertFourCode(FourCode FourCode){
		fourCodeMapper.insertFourCode(FourCode);
	}
	
	/**
	 * 获取一个未使用的随机码
	 */
	@Transactional(rollbackFor=Exception.class)
	public FourCode queryFourCode(){
		FourCode fourCode = fourCodeMapper.queryFourCode();
		String dateStr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		if (fourCode!=null) {
			fourCode.setStatus("1");
			fourCode.setUseTime(dateStr);
			fourCodeMapper.updateFourCode(fourCode);
		}
		return fourCode;
	}
	
	/**
	 * 更新随机码状态
	 */
	public void updateFourCode(FourCode fourCode){
		fourCodeMapper.updateFourCode(fourCode);
	}
}
