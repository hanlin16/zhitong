package com.etai.yto.mapper.saleaction;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import com.etai.yto.model.saleaction.SaleAction;
import com.etai.yto.page.saleaction.SaleActionPage;

public interface SaleActionMapper {

	/**
	 * 分页查询活动信息
	 */
	@SelectProvider(method="querySaleActionPage", type=SaleActionProvider.class)
	public List<SaleAction> querySaleActionPage(SaleActionPage page);

	/**
	 * 查询活动总条数
	 */
	@SelectProvider(method="querySaleActionCount", type=SaleActionProvider.class)
	public int querySaleActionCount(SaleActionPage page);

	/**
	 * 获取活动信息
	 */
	@SelectProvider(method="getSaleActionById", type=SaleActionProvider.class)
	public SaleAction getSaleActionById(Integer saleActionId);

	/**
	 * 活动编辑
	 */
	@UpdateProvider(method="saleActionEditById", type=SaleActionProvider.class)
	public void saleActionEditById(SaleAction saleAction);

	/**
	 * 添加活动
	 */
	@InsertProvider(method="saleActionAdd", type=SaleActionProvider.class)
	public void saleActionAdd(SaleAction saleAction);

	/**
	 * 删除活动
	 */
	@Delete(" delete from t_sale_action where id=#{saleActionId}")
	public void saleActionDelete(@Param("saleActionId") Integer saleActionId);

	/**
	 * 获取活动信息
	 * @return 
	 */
	@SelectProvider(method="getSaleActionByCode", type=SaleActionProvider.class)
	public SaleAction getSaleActionByCode(String actionCode);

	/**
	 * 获取活动信息
	 * @return 
	 */
	@SelectProvider(method="getSaleActionByChannlCode", type=SaleActionProvider.class)
	public List<SaleAction> getSaleActionByChannlCode(String code);

}
