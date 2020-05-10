package com.hsheng.core.springboot.autoconfig.p1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

/**
 * @description TODO
 * @author hesheng
 * @date 2020/5/10 18:52
 * @since TODO
 */
@EnableHelloWorld
@Configuration
public class HelloWorldApplication {

    public static void main(String[] args) {
        //构建Annotation配置Spring上下文
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        //注册引导类
        context.register(HelloWorldApplication.class);
        //启动上下文
        context.refresh();

        String helloworld = context.getBean("helloworld", String.class);
        System.out.println(helloworld);
        //关闭上下文
        context.close();
    }
}
