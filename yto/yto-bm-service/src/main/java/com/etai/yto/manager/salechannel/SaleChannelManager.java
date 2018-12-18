package com.etai.yto.manager.salechannel;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.etai.yto.mapper.salechannel.SaleChannelMapper;
import com.etai.yto.model.salechannel.SaleChannel;
import com.etai.yto.page.salechannel.SaleChannelPage;


@Component("saleChannelManager")
public class SaleChannelManager {

	@Resource
	private SaleChannelMapper saleChannelMapper;
	
	public List<SaleChannel> querySaleChannelPage(SaleChannelPage page){
		List<SaleChannel>  list = saleChannelMapper.querySaleChannelPage(page);
		return list;
	}
	
	/**
	 * 查询合作伙伴总条数
	 */
	public int querySaleChannelCount(SaleChannelPage page) {
		return saleChannelMapper.querySaleChannelCount(page);
	}

	/**
	 * 根据合作伙伴Id获取合作伙伴信息
	 */
	public SaleChannel getSaleChannelById(Integer saleChannelId) {
		return saleChannelMapper.getSaleChannelById(saleChannelId);
	}

	/**
	 * 根据合作伙伴Id编辑合作伙伴
	 */
	@Transactional(rollbackFor=Exception.class)
	public void saleChannelEditById(SaleChannel saleChannel) {
		saleChannelMapper.saleChannelEditById(saleChannel);
	}

	/**
	 * 合作伙伴添加
	 */
	@Transactional(rollbackFor=Exception.class)
	public void saleChannelAdd(SaleChannel saleChannel) {
		saleChannelMapper.saleChannelAdd(saleChannel);
	}

	/**
	 * 合作伙伴删除
	 */
	@Transactional(rollbackFor=Exception.class)
	public void saleChannelDelete(Integer saleChannelId) {
		saleChannelMapper.saleChannelDelete(saleChannelId);
	}

	public List<SaleChannel> getSaleChannelByPartnerCode(String partnerCode) {
		return saleChannelMapper.getSaleChannelByPartnerCode(partnerCode);
	}

	public SaleChannel getSaleChannelByName(String name) {
		return saleChannelMapper.getSaleChannelByName(name);
	}

}
