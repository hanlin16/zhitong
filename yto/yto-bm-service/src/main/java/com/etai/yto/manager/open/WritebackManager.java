package com.etai.yto.manager.open;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.etai.yto.mapper.open.WriteBackMapper;
import com.etai.yto.model.underwriting.Agreements;
import com.etai.yto.model.underwriting.ApplyDeviceInfo;
import com.etai.yto.model.underwriting.ExtraData;
import com.etai.yto.model.underwriting.Kinds;
import com.etai.yto.model.underwriting.PersonInfo;
import com.etai.yto.model.underwriting.VehicleInfo;
import com.etai.yto.model.underwriting.WritingData;
@Component("writebackManager")
public class WritebackManager {

	@Resource
	private WriteBackMapper writeBackMapper;
	/**
	 * 删除保单信息
	 * @param bizNo	
	 * 2018年7月18日
	 * void
	 */

	public void deleteProposalByNo(int bizNo){
		writeBackMapper.deleteProposalByNo(bizNo);
	}
	/**
	 * 删除人员信息
	 * @param bizNo
	 * 2018年7月18日
	 * void
	 */
	public void deletePersonByNo(int bizNo){
		writeBackMapper.deletePersonByNo(bizNo);
	}
	
	/**
	 * 删除车辆信息
	 * @param bizNo
	 * 2018年7月18日
	 * void
	 */
	public void deleteCarinfoByNo(int bizNo){
		writeBackMapper.deleteCarinfoByNo(bizNo);
	}
	
	/**
	 * 删除险别信息
	 * @param bizNo
	 * 2018年7月18日
	 * void
	 */
	public void deleteKindByNo(int bizNo){
		writeBackMapper.deleteKindByNo(bizNo);
	}
	
	/**
	 * 删除特约信息
	 * @param bizNo
	 * 2018年7月18日
	 * void
	 */
	public void deleteAgreementByNo(int bizNo){
		writeBackMapper.deleteAgreementByNo(bizNo);
	}
	
	/**
	 * 根据车主电话号码查询设备信息
	 * @param phoneNo
	 * @return
	 * 2018年7月18日
	 * String
	 */
	public Integer queryDeviceByPhone(String phoneNo,String licenseNo){
		return writeBackMapper.queryDeviceByPhone(phoneNo,licenseNo);
	}
	
	/**
	 * 添加保单信息
	 * @param writingData
	 * @param extraData
	 * 2018年7月18日
	 * void
	 */
	public void insertProposal(WritingData writingData,ExtraData extraData){
		writeBackMapper.insertProposal(writingData, extraData);
	}
	
	/**
	 * 添加人员信息 
	 * @param personInfo
	 * @param bizNo
	 * 2018年7月18日
	 * void
	 */
	public void insertPerson(PersonInfo personInfo,int bizNo){
		writeBackMapper.insertPerson( bizNo,personInfo);
	}
	/**
	 * 添加车辆信息
	 * @param ve
	 * @param bizNo
	 * 2018年7月18日
	 * void
	 */
	public void insertCarinfo(VehicleInfo vehicleInfo,int bizNo){
		writeBackMapper.insertCarinfo(vehicleInfo, bizNo);
	}
	/**
	 * 保存投保险别信息
	 * @param kind
	 * @param bizNo
	 * 2018年7月18日
	 * void
	 */
	public void insertKind(Kinds kind,int bizNo){
		writeBackMapper.insertKind(kind, bizNo);
	}
	
	/**
	 * 保存特约信息
	 * @param agreements
	 * @param bizNo
	 * 2018年7月18日
	 * void
	 */
	public void insertAgreements(Agreements agreements,int bizNo){
		writeBackMapper.insertAgreements(agreements, bizNo);
	}
	
	public void saveEquipmentApply(ApplyDeviceInfo applyDeviceInfo){
		writeBackMapper.saveEquipmentApply(applyDeviceInfo);
	}
	/**
	 * 根据车牌号查询设备申领时间
	 */
	public ApplyDeviceInfo queryAppDeviceInfoByLicenceNo(String licenceNo){
		return writeBackMapper.queryAppDeviceInfoByLicenceNo(licenceNo);
		
	}
	
}
