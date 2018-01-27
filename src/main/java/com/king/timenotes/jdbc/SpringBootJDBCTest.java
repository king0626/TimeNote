package com.king.timenotes.jdbc;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.king.timenotes.jdbc.entity.UserInfo;
import com.king.timenotes.jdbc.service.UserInfoService;

/**
 * Created by nickzhang on 2016/9/1.
 */
@RestController
public class SpringBootJDBCTest {

    private static final Logger logger = LoggerFactory.getLogger(SpringBootJDBCTest.class);

    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping("/query1")
    public List<UserInfo> query(){
        logger.info(">>>>从数据库查询userinfo数据>>>>");
        return userInfoService.login("","");
    }

}
