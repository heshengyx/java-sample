package com.hsheng.core.springboot.autoconfig.p1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description TODO
 * @author hesheng
 * @date 2020/5/10 18:48
 * @since TODO
 */
@Configuration
public class HelloWorldConfiguration {

    @Bean
    public String helloworld() {
        return "hello,world";
    }
}
