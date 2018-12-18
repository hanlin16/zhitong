package com.etai.yto.api;

import org.springframework.web.bind.annotation.PostMapping;

import com.etai.yto.model.preinfo.PreInfoModel;
import com.etai.yto.page.RemoteResult;

public interface PreInfoService {

	@PostMapping("/preInfo/preInfoAdd")
	RemoteResult<PreInfoModel> preInfoAdd(PreInfoModel preInfo);
}
