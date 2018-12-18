package com.etai.yto.manager.saleaction;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.etai.yto.mapper.saleaction.SaleActionMapper;
import com.etai.yto.model.saleaction.SaleAction;
import com.etai.yto.page.saleaction.SaleActionPage;


@Component("saleActionManager")
public class SaleActionManager {

	@Resource
	private SaleActionMapper saleActionMapper;
	
	public List<SaleAction> querySaleActionPage(SaleActionPage page){
		List<SaleAction>  list = saleActionMapper.querySaleActionPage(page);
		return list;
	}
	
	/**
	 * 查询活动总条数
	 */
	public int querySaleActionCount(SaleActionPage page) {
		return saleActionMapper.querySaleActionCount(page);
	}

	/**
	 * 根据活动Id获取活动信息
	 */
	public SaleAction getSaleActionById(Integer saleActionId) {
		return saleActionMapper.getSaleActionById(saleActionId);
	}

	/**
	 * 根据活动Id编辑活动
	 */
	@Transactional(rollbackFor=Exception.class)
	public void saleActionEditById(SaleAction saleAction) {
		saleActionMapper.saleActionEditById(saleAction);
	}

	/**
	 * 活动添加
	 */
	@Transactional(rollbackFor=Exception.class)
	public void saleActionAdd(SaleAction saleAction) {
		saleActionMapper.saleActionAdd(saleAction);
	}

	/**
	 * 活动删除
	 */
	@Transactional(rollbackFor=Exception.class)
	public void saleActionDelete(Integer saleActionId) {
		saleActionMapper.saleActionDelete(saleActionId);
	}

	public SaleAction getSaleActionByCode(String actionCode) {
		return saleActionMapper.getSaleActionByCode(actionCode);
	}

	public List<SaleAction> getSaleActionByChannlCode(String code) {
		return saleActionMapper.getSaleActionByChannlCode(code);
	}

}
