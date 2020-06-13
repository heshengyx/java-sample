package com.hsheng.core.mybatis.config;

import com.hsheng.core.mybatis.annotation.MyMapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @description 应用配置类
 * @author hesheng
 * @date 2020/6/9 8:17
 * @since TODO
 */
@Configuration
@ComponentScan(basePackages = "com.hsheng.core.mybatis")
@MyMapperScan("com.hsheng.core.mybatis.mapper")
public class AppConfig {
}
