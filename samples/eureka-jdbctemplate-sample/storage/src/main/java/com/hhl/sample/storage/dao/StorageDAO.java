package com.hhl.sample.storage.dao;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class StorageDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int deduct(String commodityCode, Integer count) {
        int result = jdbcTemplate.update("update storage_tbl set count = count - ? where commodity_code = ?",
                new Object[]{count, commodityCode});
        log.info("update结果:{}", result);
        return result;
    }
}
