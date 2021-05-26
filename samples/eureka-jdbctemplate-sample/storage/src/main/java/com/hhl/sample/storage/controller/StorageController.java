package com.hhl.sample.storage.controller;

import com.hhl.sample.storage.dao.StorageDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StorageController {

    @Autowired
    private StorageDAO storageDAO;

    @RequestMapping(value = "/storage/deduct", produces = "application/json")
    public String deduct(String commodityCode, Integer count) {
        System.out.println("扣减库存");
        storageDAO.deduct(commodityCode, count);
        return "success";
    }
}
