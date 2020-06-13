/**
 * @Copyright (c) 2019, Denali System Co., Ltd. All Rights Reserved.
 * Website: www.denalisystem.com | Email: marketing@denalisystem.com
 */
package com.hsheng.core.springboot.initializer;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;

import java.util.HashMap;
import java.util.Map;

/**
 * 此初始化器是在application.yml文件中配置context.initializer.classes
 * 此初始化器由DelegatingApplicationContextInitializer发现注册，并设置Order=0
 * 类上定义的Order(3)会失效
 * 所有此初始化器优先于其他初始化器加载
 * @description 第三个初始化器
 * @author hesheng
 * @date 2020/6/13 21:24
 * @since TODO
 */
@Order(3)
public class ThirdInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    @Override
    public void initialize(ConfigurableApplicationContext context) {
        ConfigurableEnvironment environment = context.getEnvironment();
        Map<String, Object> map = new HashMap<>();
        map.put("key3", "value3");
        MapPropertySource source = new MapPropertySource("ThirdInitializer", map);
        environment.getPropertySources().addLast(source);
        System.out.println("Run ThirdInitializer");
    }
}
