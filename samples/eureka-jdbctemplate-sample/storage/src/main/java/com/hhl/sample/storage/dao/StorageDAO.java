package com.hhl.sample.storage.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class StorageDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int deduct(String commodityCode, Integer count) {
        int result = jdbcTemplate.update("update storage_tbl set count = count - ? where commodity_code = ?",
                new Object[]{count, commodityCode});
        System.out.println("update结果:" + result);
        return result;
    }
}
