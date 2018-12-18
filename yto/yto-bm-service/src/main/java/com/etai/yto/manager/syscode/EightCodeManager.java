package com.etai.yto.manager.syscode;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.etai.yto.mapper.syscode.EightCodeMapper;
import com.etai.yto.model.syscode.EightCode;

@Component("eightCodeManager")
public class EightCodeManager {

	@Resource
	private EightCodeMapper eightCodeMapper;
	
	/**
	 * 保存随机码
	 * @param eightCode
	 * 2018年9月13日
	 * void
	 */
	public void insertEightCode(EightCode eightCode){
		eightCodeMapper.insertEightCode(eightCode);
	}
	
	/**
	 * 获取一个未使用的随机码
	 * @return
	 * 2018年9月13日
	 * Integer
	 */
	@Transactional(rollbackFor=Exception.class)
	public EightCode queryEightCode(){
		EightCode eightCode = eightCodeMapper.queryEightCode();
		String dateStr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		if (eightCode!=null) {
			eightCode.setStatus("1");
			eightCode.setUseTime(dateStr);
			eightCodeMapper.UpdateEightCode(eightCode);
		}
		return eightCode;
	}
	
	/**
	 * 更新随机码状态
	 * @param eightCode
	 * 2018年9月13日
	 * void
	 */
	public void UpdateEightCode(EightCode eightCode){
		eightCodeMapper.UpdateEightCode(eightCode);
	}
}
