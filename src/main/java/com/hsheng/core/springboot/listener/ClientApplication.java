package com.hsheng.core.springboot.listener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @description TODO
 * @author hesheng
 * @date 2020/6/13 22:18
 * @since TODO
 */
@SpringBootApplication
public class ClientApplication {

    public static void main(String[] args) {
        //构造容器启动类
        SpringApplication application = new SpringApplication(com.hsheng.core.springboot.initializer.ClientApplication.class);
        application.addListeners(new SecondListener());
        ConfigurableApplicationContext context = application.run(args);
    }
}
