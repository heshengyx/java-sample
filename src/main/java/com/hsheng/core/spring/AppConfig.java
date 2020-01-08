package com.hsheng.core.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @description TODO
 * @author hesheng
 * @date 2019/12/21 14:59
 * @since TODO
 */
@Configuration
@ComponentScan
@Import({Blue.class, Red.class, MyImportSelector.class, MyImportBeanDefinitionRegistrar.class})
public class AppConfig {

    @Bean(initMethod = "initMethod", destroyMethod = "destroyMethod")
    public MySpringBean springBean() {
        return new MySpringBean();
    }
}
