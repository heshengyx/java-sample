package com.hsheng.core.springboot.autoconfig.p2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

/**
 * @description TODO
 * @author hesheng
 * @date 2020/5/10 19:23
 * @since TODO
 */
@EnableServer(type = Server.Type.FTP)
@Configuration
public class ServerApplication {

    public static void main(String[] args) {
        //构建Annotation配置Spring上下文
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        //注册引导类
        context.register(ServerApplication.class);
        //启动上下文
        context.refresh();

        Server server = context.getBean(Server.class);
        server.start();
        server.stop();
    }
}
