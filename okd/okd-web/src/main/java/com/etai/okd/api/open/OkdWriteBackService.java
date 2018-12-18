package com.etai.okd.api.open;

import com.etai.yto.api.WriteBackService;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("${service.application.name}")
public interface OkdWriteBackService extends WriteBackService {

	
}
