package com.sanxun.test.controller;

import com.sanxun.test.dao.CustomerInfoMapper;
import com.sanxun.test.pojo.CustomerInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private CustomerInfoMapper customerInfoMapper;

    @RequestMapping("list")
    public CustomerInfo test(){
        return customerInfoMapper.getInfoList();
    }


}
