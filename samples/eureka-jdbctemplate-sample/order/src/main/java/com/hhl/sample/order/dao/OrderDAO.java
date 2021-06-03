package com.hhl.sample.order.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class OrderDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int createOrder(String userId, String commodity_code, Integer count, Integer money) {
        System.out.println("创建订单");
        int result = jdbcTemplate.update("insert into order_tbl(user_id,commodity_code,`count`,money) values (?,?,?,?)",
                new Object[]{userId, commodity_code, count, money});
        System.out.println("createOrder结果:" + result);
        return result;
    }
}
