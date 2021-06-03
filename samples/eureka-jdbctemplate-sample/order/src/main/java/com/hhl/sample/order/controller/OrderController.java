package com.hhl.sample.order.controller;

import com.hhl.kunkka.client.transactionannotation.ATTransactional;
import com.hhl.sample.order.service.OrderService;
import com.hhl.sample.order.stub.StorageStub;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class OrderController {


    @Autowired
    private StorageStub storageStub;
    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/order/create")
    @ATTransactional
    public String createOrder(String userId, String commodityCode) {
        int count = 1;
        int money = 10;
        String deductResult = storageStub.deduct(commodityCode, count);
        log.info("扣减库存-result:" + deductResult);
        int createOrderResult = orderService.createOrder(userId, commodityCode, count, money);
        return "success:" + createOrderResult;
    }

}
