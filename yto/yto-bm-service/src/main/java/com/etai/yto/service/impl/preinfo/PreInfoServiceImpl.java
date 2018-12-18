package com.etai.yto.service.impl.preinfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.etai.yto.api.PreInfoService;
import com.etai.yto.manager.preinfo.PreInfoManager;
import com.etai.yto.model.preinfo.PreInfoModel;
import com.etai.yto.page.RemoteResult;
@RestController
public class PreInfoServiceImpl implements PreInfoService {

	@Autowired
	PreInfoManager preInfoManager;
	
	@Override
	public RemoteResult<PreInfoModel> preInfoAdd(@RequestBody PreInfoModel preInfo) {
		RemoteResult<PreInfoModel> result = new RemoteResult<PreInfoModel>();
		try {
			PreInfoModel model = preInfoManager.queryByLicenceNo(preInfo.getLicenceNo());
			if(model==null){
				preInfoManager.addPreInfo(preInfo);
			}else {
				preInfoManager.updatePreInfoByLicence(preInfo);
			}
			result.setSuccess(true);
		} catch (Exception e) {
			System.out.println("异常信息:"+e);
			result.setSuccess(false);
			result.setErrorMsg("数据库保存预填活动码车牌信息异常!");
		}
		return result;
	}

}
