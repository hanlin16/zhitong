package com.etai.yto.mapper.vehicleinfo;

import org.apache.ibatis.annotations.Param;

public class VehicleInfoProvider {

	public String getVehicleInfo(@Param("bizId") String bizId) {
		StringBuffer sb = new StringBuffer();
		sb.append(" SELECT  " + 
				" license_no,frame_no,\n" + 
				" engine_no,register_date,\n" + 
				" vehicle_model_code,vehicle_brand,\n" + 
				" vehicle_modelName,new_car_price,\n" + 
				" seat_count FROM \n" + 
				" t_policy_carinfo where zt_biz_id =#{bizId}");
		return sb.toString();
	}
}
