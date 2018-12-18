package com.etai.yto.mapper.open;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.etai.yto.model.underwriting.Agreements;
import com.etai.yto.model.underwriting.ApplyDeviceInfo;
import com.etai.yto.model.underwriting.ExtraData;
import com.etai.yto.model.underwriting.Kinds;
import com.etai.yto.model.underwriting.PersonInfo;
import com.etai.yto.model.underwriting.VehicleInfo;
import com.etai.yto.model.underwriting.WritingData;
@Mapper
public interface WriteBackMapper {
	
	/**
	 * 删除保单信息
	 * @param bizNo
	 * 2018年7月18日
	 * void
	 */
	@Delete({
		" delete from t_policy_info where zt_biz_id=#{bizNo,jdbcType=INTEGER}"
	})
	public void deleteProposalByNo(@Param("bizNo") int bizNo);
	/**
	 * 删除人员信息
	 * @param bizNo
	 * 2018年7月18日
	 * void
	 */
	@Delete({
		" delete from t_policy_person where zt_biz_id=#{bizNo,jdbcType=INTEGER}"
	})
	public void deletePersonByNo(@Param("bizNo") int bizNo);
	
	/**
	 * 删除车辆信息
	 * @param bizNo
	 * 2018年7月18日
	 * void
	 */
	@Delete({
		" delete from t_policy_carinfo where zt_biz_id=#{bizNo,jdbcType=INTEGER}"
	})
	public void deleteCarinfoByNo(@Param("bizNo") int bizNo);
	
	/**
	 * 删除险别信息
	 * @param bizNo
	 * 2018年7月18日
	 * void
	 */
	@Delete({
		" delete from t_policy_kind where zt_biz_id=#{bizNo,jdbcType=INTEGER}"
	})
	public void deleteKindByNo(@Param("bizNo") int bizNo);
	
	/**
	 * 删除特约信息
	 * @param bizNo
	 * 2018年7月18日
	 * void
	 */
	@Delete({
		" delete from t_policy_agreement where zt_biz_id=#{bizNo,jdbcType=INTEGER}"
	})
	public void deleteAgreementByNo(@Param("bizNo") int bizNo);
	
	/**
	 * 根据车主电话号码查询设备信息
	 * @param phoneNo
	 * @return
	 * 2018年7月18日
	 * String
	 */
	@Select({
		
		" select count(*) as total from t_device_bind where LICENSE_NO= #{licenseNo,jdbcType=VARCHAR}"
	})
	public Integer queryDeviceByPhone(@Param("phoneNo") String phoneNo,@Param("licenseNo") String licenseNo);
	
	/**
	 * 添加保单信息
	 * @param writingData
	 * @param extraData
	 * 2018年7月18日
	 * void
	 */
	@InsertProvider(type=WriteBackProvider.class,method="insertProposal")
	public void insertProposal(@Param("writingData") WritingData writingData,@Param("extraData")  ExtraData extraData);
	
	/**
	 * 添加人员信息 
	 * @param personInfo
	 * @param bizNo
	 * 2018年7月18日
	 * void
	 */
	@InsertProvider(type=WriteBackProvider.class,method="insertPerson")
	public void insertPerson(@Param("bizNo") int bizNo,@Param("personInfo") PersonInfo personInfo);
	/**
	 * 添加车辆信息
	 * @param ve
	 * @param bizNo
	 * 2018年7月18日
	 * void
	 */
	@InsertProvider(type=WriteBackProvider.class,method="insertCarinfo")
	public void insertCarinfo(@Param("vehicleInfo") VehicleInfo vehicleInfo,@Param("bizNo") int bizNo);
	/**
	 * 保存投保险别信息
	 * @param kind
	 * @param bizNo
	 * 2018年7月18日
	 * void
	 */
	@InsertProvider(type=WriteBackProvider.class,method="insertKind")
	public void insertKind(@Param("kind") Kinds kind,@Param("bizNo") int bizNo);
	
	/**
	 * 保存特约信息
	 * @param agreements
	 * @param bizNo
	 * 2018年7月18日
	 * void
	 */
	@InsertProvider(type=WriteBackProvider.class,method="insertAgreements")
	public void insertAgreements(@Param("agreements") Agreements agreements,@Param("bizNo") int bizNo);
	
	/**
	 * 生成设备申领信息
	 * @param personInfo
	 * @param uuid
	 * 2018年9月3日
	 * void
	 */
	@InsertProvider(type=WriteBackProvider.class,method="saveEquipmentApply")
	public void saveEquipmentApply(@Param("applyDeviceInfo") ApplyDeviceInfo applyDeviceInfo);
	/**
	 * 查询设备申领时间
	 * @param licenceNo
	 * @return
	 */
	@Select({
		" select BIZ_NO RECEIVER,ADDRESS,RECEIVER_PHONE_NO,CHANNEL_CODE,ACTION_CODE,APPLY_TIME,APPLY_TYPE,"
		+ "LINK_STATUS from  t_device_apply app,t_device_bind bin,t_device_info info "
		+ "where LICENSE_NO= #{licenseNo,jdbcType=VARCHAR}  "
		+ "AND bin.DEVICE_CODE=info.DEVICE_CODE AND info.DEVICE_APPLY_ID=app.ID"
	})
	public ApplyDeviceInfo queryAppDeviceInfoByLicenceNo(String licenceNo);

}
