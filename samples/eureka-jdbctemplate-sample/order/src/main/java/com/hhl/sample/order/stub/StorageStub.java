package com.hhl.sample.order.stub;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="eureka-jdbctemplate-sample-storage")
public interface StorageStub {

    @GetMapping(value = "/storage/deduct")
    String deduct(@RequestParam("commodityCode") String commodityCode, @RequestParam("count")Integer count);
}
