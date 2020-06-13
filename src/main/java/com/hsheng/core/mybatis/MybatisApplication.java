package com.hsheng.core.mybatis;

import com.hsheng.core.mybatis.config.AppConfig;
import com.hsheng.core.mybatis.service.UserServiceImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @description TODO
 * @author hesheng
 * @date 2020/6/9 8:18
 * @since TODO
 */
public class MybatisApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        UserServiceImpl userService = context.getBean(UserServiceImpl.class);
        System.out.println(userService);

        userService.selectById();
    }
}
