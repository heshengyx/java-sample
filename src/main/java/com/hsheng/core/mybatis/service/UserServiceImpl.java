package com.hsheng.core.mybatis.service;

import com.hsheng.core.mybatis.mapper.OrderMapper;
import com.hsheng.core.mybatis.mapper.ProductMapper;
import com.hsheng.core.mybatis.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description TODO
 * @author hesheng
 * @date 2020/6/9 8:16
 * @since TODO
 */
@Service
public class UserServiceImpl {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private ProductMapper productMapper;

    public void selectById() {
        userMapper.selectById();
        orderMapper.selectById();
        productMapper.selectById();
    }
}
