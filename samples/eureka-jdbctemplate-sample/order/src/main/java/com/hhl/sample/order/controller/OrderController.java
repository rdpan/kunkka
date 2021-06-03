package com.hhl.sample.order.controller;

import com.hhl.sample.order.dao.OrderDAO;
import com.hhl.sample.order.stub.StorageStub;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    private OrderDAO orderDAO;
    @Autowired
    private StorageStub storageStub;

    @RequestMapping(value = "/order/create")
    public String createOrder(String userId, String commodityCode) {
        int count = 1;
        int money = 10;
        System.out.println("扣减库存");
        String deductResult = storageStub.deduct(commodityCode, count);
        System.out.println("扣减库存-result:" + deductResult);
        int createOrderResult = orderDAO.createOrder(userId, commodityCode, count, money);
        return "success:" + createOrderResult;
    }
}
