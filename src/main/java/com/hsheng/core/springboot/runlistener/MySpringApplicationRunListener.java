/**
 * @Copyright (c) 2019, Denali System Co., Ltd. All Rights Reserved.
 * Website: www.denalisystem.com | Email: marketing@denalisystem.com
 */
package com.hsheng.core.springboot.runlistener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;

import java.io.IOException;
import java.util.Properties;

/**
 * @description TODO
 * @author hesheng
 * @date 2020/6/3 8:01
 * @since TODO
 */
public class MySpringApplicationRunListener implements SpringApplicationRunListener {

    private SpringApplication application;
    private String[] args;

    /**
     * 必须要有此构造函数, springboot启动时, 通过反射调用此构造函数
     * @param application
     * @param args
     */
    public MySpringApplicationRunListener(SpringApplication application, String[] args) {
        this.application = application;
        this.args = args;
    }

    @Override
    public void starting() {
        System.out.println("===starting===");
    }

    @Override
    public void environmentPrepared(ConfigurableEnvironment environment) {
        System.out.println("===environmentPrepared===");
        //读取属性文件，载入到springboot容器中
        Properties properties = new Properties();
        try {
            //载入my.properties属性文件
            properties.load(this.getClass().getClassLoader()
                    .getResourceAsStream("my.properties"));

            //读取文件名为my.propertie属性文件
            PropertySource propertySource = new PropertiesPropertySource("my", properties);
            //添加属性资源
            MutablePropertySources propertySources = environment.getPropertySources();
            propertySources.addLast(propertySource);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void contextPrepared(ConfigurableApplicationContext context) {
        System.out.println("===contextPrepared===");
    }

    @Override
    public void contextLoaded(ConfigurableApplicationContext context) {
        System.out.println("===contextLoaded===");
    }

    @Override
    public void started(ConfigurableApplicationContext context) {
        System.out.println("===started===");
    }

    @Override
    public void running(ConfigurableApplicationContext context) {
        System.out.println("===running===");
    }

    @Override
    public void failed(ConfigurableApplicationContext context, Throwable exception) {
        System.out.println("===failed===");
    }
}
