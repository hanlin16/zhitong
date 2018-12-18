package com.etai.yto.mapper.open;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

import com.etai.yto.model.underwriting.Agreements;
import com.etai.yto.model.underwriting.ApplyDeviceInfo;
import com.etai.yto.model.underwriting.ExtraData;
import com.etai.yto.model.underwriting.Kinds;
import com.etai.yto.model.underwriting.PersonInfo;
import com.etai.yto.model.underwriting.VehicleInfo;
import com.etai.yto.model.underwriting.WritingData;

public class WriteBackProvider {

	/**
	 * 添加保单信息
	 * @param writingData
	 * @param extraData
	 * 2018年7月18日
	 * void
	 */
	public String insertProposal(final @Param("writingData") WritingData writingData,final @Param("extraData") ExtraData extraData){
		return new SQL(){
			{
				INSERT_INTO("t_policy_info");
				//WritingData
				VALUES("zt_biz_id", "#{writingData.bizId,jdbcType=VARCHAR}");
				VALUES("total_credits", "#{writingData.totalCredits,jdbcType=VARCHAR}");
				VALUES("bi_premium", "#{writingData.biPremium,jdbcType=VARCHAR}");
				VALUES("ci_premium", "#{writingData.ciPremium,jdbcType=VARCHAR}");
				
				VALUES("vehicle_tax_premium", "#{writingData.vehicleTaxPremium,jdbcType=VARCHAR}");
				VALUES("sum_premium", "#{writingData.sumPremium,jdbcType=VARCHAR}");
				
				if (StringUtils.isNotBlank(writingData.getBiStartDate())) {
					VALUES("bi_start_date", "#{writingData.biStartDate,jdbcType=VARCHAR}");
				}
				if (StringUtils.isNotBlank(writingData.getBiEndDate())) {
					VALUES("bi_end_date", "#{writingData.biEndDate,jdbcType=VARCHAR}");
				}
				if (StringUtils.isNotBlank(writingData.getCiStartDate())) {
					VALUES("ci_start_date", "#{writingData.ciStartDate,jdbcType=VARCHAR}");
				}
				if (StringUtils.isNotBlank(writingData.getCiEndDate())) {
					VALUES("ci_end_date", "#{writingData.ciEndDate,jdbcType=VARCHAR}");
				}
				if (StringUtils.isNotBlank(writingData.getBalanceCiIntegral())) {
					VALUES("balance_ci_integral", "#{writingData.balanceCiIntegral,jdbcType=VARCHAR}");
				}
				if (StringUtils.isNotBlank(writingData.getBalanceBiIntegral())) {
					VALUES("balance_bi_integral", "#{writingData.balanceBiIntegral,jdbcType=VARCHAR}");
				}
				if (StringUtils.isNotBlank(writingData.getBalanceCiCost())) {
					VALUES("balance_ci_cost", "#{writingData.balanceCiCost,jdbcType=VARCHAR}");
				}
				if (StringUtils.isNotBlank(writingData.getBalanceBiCost())) {
					VALUES("balance_bi_cost", "#{writingData.balanceBiCost,jdbcType=VARCHAR}");
				}
				VALUES("city_code", "#{writingData.cityCode,jdbcType=VARCHAR}");
				VALUES("city_name", "#{writingData.cityName,jdbcType=VARCHAR}");
				VALUES("province_code", "#{writingData.provinceCode,jdbcType=VARCHAR}");
				VALUES("province_name", "#{writingData.provinceName,jdbcType=VARCHAR}");
				if (StringUtils.isNotBlank(writingData.getCloudFlag())) {
					VALUES("cloud_flag", "#{writingData.cloudFlag,jdbcType=VARCHAR}");
				}
				VALUES("agent_code", "#{writingData.agentCode,jdbcType=VARCHAR}");
				VALUES("pay_time", "#{writingData.payTime,jdbcType=VARCHAR}");
				VALUES("pay_money", "#{writingData.payMoney,jdbcType=VARCHAR}");
				
				VALUES("insurer_code", "#{writingData.insurerCode,jdbcType=VARCHAR}");
				if (StringUtils.isNotBlank(writingData.getAccountNo())) {
					VALUES("account_no", "#{writingData.accountNo,jdbcType=VARCHAR}");
				}
				
				// ExtraData
				if (StringUtils.isNotBlank(extraData.getBiProposalNo())) {
					VALUES("bi_proposal_no", "#{extraData.biProposalNo,jdbcType=VARCHAR}");
				}
				if (StringUtils.isNotBlank(extraData.getBiPolicyNo())) {
					VALUES("bi_policy_no", "#{extraData.biPolicyNo,jdbcType=VARCHAR}");				
				}
				if (StringUtils.isNotBlank(extraData.getCiProposalNo())) {
					VALUES("ci_proposal_no", "#{extraData.ciProposalNo,jdbcType=VARCHAR}");
				}
				if (StringUtils.isNotBlank(extraData.getCiPolicyNo())) {
					VALUES("ci_policy_no", "#{extraData.ciPolicyNo,jdbcType=VARCHAR}");
				}
				if (StringUtils.isNotBlank(extraData.getAcceptTime())) {
					VALUES("accept_time", "#{extraData.acceptTime,jdbcType=VARCHAR}");
				}
				//
				/*VALUES("bind_status", "#{extraData.bindStatus,jdbcType=INTEGER}");
				VALUES("relation_status", "#{extraData.relationStatus,jdbcType=INTEGER}");
				if (StringUtils.isNotBlank(extraData.getDeviceNo())) {
					VALUES("device_no", "#{extraData.deviceNo,jdbcType=VARCHAR}");
				}*/
			}
		}.toString();
	}
	
	/**
	 * 添加人员信息 
	 * @param personInfo
	 * @param bizNo
	 * 2018年7月18日
	 * String
	 */
	public String insertPerson(final @Param("personInfo") PersonInfo personInfo,final @Param("bizNo") int bizNo){
		
		return new SQL(){
			{
				INSERT_INTO("t_policy_person");
				//WritingData
				VALUES("zt_biz_id", "#{bizNo,jdbcType=INTEGER}");
				VALUES("owner_name", "#{personInfo.ownerName,jdbcType=VARCHAR}");
				VALUES("ownerId_no", "#{personInfo.ownerIdNo,jdbcType=VARCHAR}");
				VALUES("owner_mobile", "#{personInfo.ownerMobile,jdbcType=VARCHAR}");
				
				VALUES("applicant_name", "#{personInfo.applicantName,jdbcType=VARCHAR}");
				VALUES("applicantId_no", "#{personInfo.applicantIdNo,jdbcType=VARCHAR}");
				VALUES("applicant_mobile", "#{personInfo.applicantMobile,jdbcType=VARCHAR}");
				VALUES("insured_name", "#{personInfo.insuredName,jdbcType=VARCHAR}");
				VALUES("insuredId_no", "#{personInfo.insuredIdNo,jdbcType=VARCHAR}");
				VALUES("insured_mobile", "#{personInfo.insuredMobile,jdbcType=VARCHAR}");
				if (StringUtils.isNotBlank(personInfo.getInsuredAddress())) {
					VALUES("insured_address", "#{personInfo.insuredAddress,jdbcType=VARCHAR}");
				}
				VALUES("addressee_name", "#{personInfo.addresseeName,jdbcType=VARCHAR}");
				VALUES("addressee_mobile", "#{personInfo.addresseeMobile,jdbcType=VARCHAR}");
				VALUES("addressee_details", "#{personInfo.addresseeDetails,jdbcType=VARCHAR}");
				if (StringUtils.isNotBlank(personInfo.getPolicyEmail())) {
					VALUES("policy_email", "#{personInfo.policyEmail,jdbcType=VARCHAR}");
				}
				
			}
		}.toString();
	}
	
	/**
	 * 添加车辆信息
	 * @param ve
	 * @param bizNo
	 * 2018年7月18日
	 * string
	 */
	public String insertCarinfo(final @Param("vehicleInfo") VehicleInfo vehicleInfo,final @Param("bizNo") int bizNo){
		return new SQL(){
			{
				INSERT_INTO("t_policy_carinfo");
				VALUES("zt_biz_id", "#{bizNo,jdbcType=INTEGER}");
				VALUES("license_no", "#{vehicleInfo.licenseNo,jdbcType=VARCHAR}");
				VALUES("frame_no", "#{vehicleInfo.frameNo,jdbcType=VARCHAR}");
				VALUES("engine_no", "#{vehicleInfo.engineNo,jdbcType=VARCHAR}");
				VALUES("register_date", "#{vehicleInfo.registerDate,jdbcType=VARCHAR}");
				VALUES("vehicle_model_code", "#{vehicleInfo.vehicleModelCode,jdbcType=VARCHAR}");
				if (StringUtils.isNotBlank(vehicleInfo.getVehicleBrand())) {
					VALUES("vehicle_brand", "#{vehicleInfo.vehicleBrand,jdbcType=VARCHAR}");
				}
				if (StringUtils.isNotBlank(vehicleInfo.getVehicleModelName())) {
					VALUES("vehicle_modelName", "#{vehicleInfo.vehicleModelName,jdbcType=VARCHAR}");
				}
				VALUES("new_car_price", "#{vehicleInfo.newCarPrice,jdbcType=VARCHAR}");
				VALUES("seat_count", "#{vehicleInfo.seatCount,jdbcType=VARCHAR}");
				VALUES("transfer_flag", "#{vehicleInfo.transferFlag,jdbcType=VARCHAR}");
				if (StringUtils.isNotBlank(vehicleInfo.getTransferDate())) {
					VALUES("transfer_date", "#{vehicleInfo.transferDate,jdbcType=VARC AR}");
				}
				VALUES("loan_flag", "#{vehicleInfo.loanFlag,jdbcType=VARCHAR}");
			}
		}.toString();
	}
	
	/**
	 * 保存投保险别信息
	 * @param kind
	 * @param bizNo
	 * 2018年7月18日
	 * String
	 */
	public String insertKind(final @Param("kind") Kinds kind,final @Param("bizNo") int bizNo){
		return new SQL(){
			{
				INSERT_INTO("t_policy_kind");
				VALUES("zt_biz_id", "#{bizNo,jdbcType=INTEGER}");
				VALUES("risk_code", "#{kind.riskCode,jdbcType=VARCHAR}");
				VALUES("kind_code", "#{kind.kindCode,jdbcType=VARCHAR}");
				VALUES("kind_name", "#{kind.kindName,jdbcType=VARCHAR}");
				VALUES("amount", "#{kind.amount,jdbcType=VARCHAR}");
				VALUES("premium", "#{kind.premium,jdbcType=VARCHAR}");
				if (StringUtils.isNotBlank(kind.getFlag())) {
					VALUES("flag", "#{kind.flag,jdbcType=VARCHAR}");
				}
				if (StringUtils.isNotBlank(kind.getDeductibleFlag())) {
					VALUES("deductible_flag", "#{kind.deductibleFlag,jdbcType=VARCHAR}");
				}
				
			}
		}.toString();
	}
	
	/**
	 * 保存特约信息
	 * @param agreements
	 * @param bizNo
	 * 2018年7月18日
	 * String
	 */
	public String insertAgreements(final @Param("agreements") Agreements agreements,final @Param("bizNo") int bizNo){
		return new SQL(){
			{
				INSERT_INTO("t_policy_agreement");
				VALUES("zt_biz_id", "#{bizNo,jdbcType=INTEGER}");
				if (StringUtils.isNotBlank(agreements.getCode())) {
					VALUES("code", "#{agreements.code,jdbcType=VARCHAR}");
				}
				if (StringUtils.isNotBlank(agreements.getName())) {
					VALUES("name", "#{agreements.name,jdbcType=VARCHAR}");
				}
				VALUES("content", "#{agreements.content,jdbcType=VARCHAR}");
				VALUES("risk_code", "#{agreements.riskCode,jdbcType=VARCHAR}");
			}
		}.toString();
	}
	/**
	 * 生成设备申领信息
	 * @param personInfo
	 * @param uuid
	 * @return
	 * 2018年9月3日
	 * String
	 */
	public String saveEquipmentApply(final @Param("applyDeviceInfo") ApplyDeviceInfo applyDeviceInfo){
		return new SQL(){
			{
				INSERT_INTO("t_device_apply");
				VALUES("BIZ_NO", "#{applyDeviceInfo.bizNo,jdbcType=VARCHAR}");
				if (StringUtils.isNotBlank(applyDeviceInfo.getAddresseeName())) {
					VALUES("RECEIVER", "#{applyDeviceInfo.addresseeName,jdbcType=VARCHAR}");
				}
				if (StringUtils.isNotBlank(applyDeviceInfo.getAddresseeMobile())) {
					VALUES("ADDRESS", "#{applyDeviceInfo.addresseeDetails,jdbcType=VARCHAR}");
				}
				if (StringUtils.isNotBlank(applyDeviceInfo.getAddresseeDetails())) {
					VALUES("RECEIVER_PHONE_NO", "#{applyDeviceInfo.addresseeMobile,jdbcType=VARCHAR}");
				}
				VALUES("CHANNEL_CODE", "#{applyDeviceInfo.channelCode,jdbcType=VARCHAR}");
				VALUES("ACTION_CODE", "#{applyDeviceInfo.actionCode,jdbcType=VARCHAR}");
				VALUES("APPLY_TIME", "#{applyDeviceInfo.applyTime,jdbcType=VARCHAR}");
				VALUES("APPLY_TYPE", "#{applyDeviceInfo.applyType,jdbcType=VARCHAR}");
				VALUES("LINK_STATUS", "#{applyDeviceInfo.linkStatus,jdbcType=INTEGER}");
				VALUES("PAY_STATUS", "2");
			}
		}.toString();
	}
	
}
