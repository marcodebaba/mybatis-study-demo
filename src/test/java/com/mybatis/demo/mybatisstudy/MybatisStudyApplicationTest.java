package com.mybatis.demo.mybatisstudy;

import com.mybatis.demo.mybatisstudy.service.OrderService;
import com.mybatis.demo.mybatisstudy.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MybatisStudyApplicationTest {
    @Autowired
    private UserService userService;

    @Autowired
    private OrderService orderService;

    @Test
    void testMybatis() {
        System.out.println(userService.createOrder());
        System.out.println(orderService.queryDataFromDB());
    }
}
