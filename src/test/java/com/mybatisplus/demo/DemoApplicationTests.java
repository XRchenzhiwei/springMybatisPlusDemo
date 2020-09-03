package com.mybatisplus.demo;

import com.mybatisplus.service.sys.user.impl.SysUserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    SysUserServiceImpl sysUserServiceImpl;

    @Test
    public void pageListTest(){

    }

}
