package com.mybatis.demo.mybatisstudy.service.impl;

import com.mybatis.demo.mybatisstudy.mapper.UserMapper;
import com.mybatis.demo.mybatisstudy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author：marco pan
 * @ClassName：UserServiceImpl
 * @Description：
 * @date 2021年10月01日 10:23 上午
 */
@Service
public class UserServiceImpl implements UserService {
    /**
     * MyBatis针对UserMapper生成的代理对象赋值给userMapper
     * Spring整合其他框架的思路就是把其他框架产生的对象放到Spring容器中
     */
    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public String createOrder() {
        return userMapper.queryUsers();
    }
}
