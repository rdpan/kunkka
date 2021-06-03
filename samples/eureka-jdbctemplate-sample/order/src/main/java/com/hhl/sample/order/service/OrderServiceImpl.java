package com.hhl.sample.order.service;

import com.hhl.sample.order.dao.OrderDAO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDAO orderDAO;

    @Override
    public int createOrder(String userId, String commodityCode, Integer count, Integer money) {
        return orderDAO.createOrder(userId, commodityCode, count, money);
    }

}
