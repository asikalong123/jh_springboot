package com.sanxun.test.dao;

import com.sanxun.test.pojo.CustomerInfo;
import org.springframework.stereotype.Repository;

/**
 * @author jinhui
 */
@Repository
public interface CustomerInfoMapper {

    CustomerInfo getInfoList();
}
