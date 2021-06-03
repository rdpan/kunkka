package com.hhl.sample.order.service;

public interface OrderService {

    int createOrder(String userId, String commodityCode, Integer count, Integer money);
}
