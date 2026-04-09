package com.mybatis.demo.mybatisstudy.service.impl;

import com.mybatis.demo.mybatisstudy.mapper.OrderMapper;
import com.mybatis.demo.mybatisstudy.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author marco pan
 * @ClassName MyBatisServiceImpl
 * @Description
 * @date 2021年10月01日 10:26 上午
 */
@Service
public class OrderServiceImpl implements OrderService {
    private final OrderMapper orderMapper;

    @Autowired
    public OrderServiceImpl(OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }

    @Override
    public String queryDataFromDB() {
        return orderMapper.query();
    }
}
