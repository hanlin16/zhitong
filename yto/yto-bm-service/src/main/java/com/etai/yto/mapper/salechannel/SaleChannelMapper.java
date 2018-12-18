package com.etai.yto.mapper.salechannel;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import com.etai.yto.model.salechannel.SaleChannel;
import com.etai.yto.page.salechannel.SaleChannelPage;

public interface SaleChannelMapper {

	/**
	 * 分页查询渠道信息
	 */
	@SelectProvider(method="querySaleChannelPage", type=SaleChannelProvider.class)
	public List<SaleChannel> querySaleChannelPage(SaleChannelPage page);

	/**
	 * 查询渠道总条数
	 */
	@SelectProvider(method="querySaleChannelCount", type=SaleChannelProvider.class)
	public int querySaleChannelCount(SaleChannelPage page);

	/**
	 * 获取渠道信息
	 */
	@SelectProvider(method="getSaleChannelById", type=SaleChannelProvider.class)
	public SaleChannel getSaleChannelById(Integer saleChannelId);

	/**
	 * 渠道编辑
	 */
	@UpdateProvider(method="saleChannelEditById", type=SaleChannelProvider.class)
	public void saleChannelEditById(SaleChannel saleChannel);

	/**
	 * 添加渠道
	 */
	@InsertProvider(method="saleChannelAdd", type=SaleChannelProvider.class)
	public void saleChannelAdd(SaleChannel saleChannel);

	/**
	 * 删除渠道
	 */
	@Delete(" delete from t_sale_channel where id=#{saleChannelId}")
	public void saleChannelDelete(@Param("saleChannelId") Integer saleChannelId);

	/**
	 * 获取渠道信息
	 */
	@SelectProvider(method="getSaleChannelByPartnerCode", type=SaleChannelProvider.class)
	public List<SaleChannel> getSaleChannelByPartnerCode(String partnerCode);

	/**
	 * 获取渠道信息
	 */
	@SelectProvider(method="getSaleChannelByName", type=SaleChannelProvider.class)
	public SaleChannel getSaleChannelByName(String name);
}
