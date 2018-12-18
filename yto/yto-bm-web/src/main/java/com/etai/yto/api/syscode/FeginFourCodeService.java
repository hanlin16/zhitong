package com.etai.yto.api.syscode;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("${service.application.name}")
public interface FeginFourCodeService extends FourCodeService{

}
