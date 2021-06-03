package com.hhl.sample.order.dao;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class OrderDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int createOrder(String userId, String commodity_code, Integer count, Integer money) {
        log.info("创建订单");
        int result = jdbcTemplate.update("insert into order_tbl(user_id,commodity_code,`count`,money) values (?,?,?,?)",
                new Object[]{userId, commodity_code, count, money});
        log.info("createOrder结果:{}", result);
        return result;
    }
}
