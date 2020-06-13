/**
 * @Copyright (c) 2019, Denali System Co., Ltd. All Rights Reserved.
 * Website: www.denalisystem.com | Email: marketing@denalisystem.com
 */
package com.hsheng.core.springboot.initializer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * 1、都要实现ApplicationContextInitializer接口
 * 2、Order值越小越先执行
 * 3、application.yml中定义的初始化器最先执行
 * Run ThirdInitializer
 * Run FirstInitializer
 * Run SecondInitializer
 * @description 初始化器
 * @author hesheng
 * @date 2020/6/13 21:31
 * @since TODO
 */
@SpringBootApplication
public class ClientApplication {

    public static void main(String[] args) {
        //启动并返回当前容器上下文
        /*ConfigurableApplicationContext context = SpringApplication.run(com.hsheng.core.springboot.runlistener.ClientApplication.class, args);
        String value = context.getEnvironment().getProperty("key1");
        System.out.println("value1=" + value);*/

        //构造容器启动类
        SpringApplication application = new SpringApplication(ClientApplication.class);
        application.addInitializers(new SecondInitializer());
        ConfigurableApplicationContext context = application.run(args);
        String value1 = context.getEnvironment().getProperty("key1");
        System.out.println("value1=" + value1);

        String value2 = context.getEnvironment().getProperty("key2");
        System.out.println("value2=" + value2);

        String value3 = context.getEnvironment().getProperty("key3");
        System.out.println("value3=" + value3);
    }
}
