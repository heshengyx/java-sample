package com.hsheng.core.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @description spring配置类
 * @author hesheng
 * @date 2019/12/21 14:59
 * @since TODO
 */

/**
 * @Configuration 说明当前类是配置
 * @ComponentScan 扫描当前包下有@Component注解的类, 并实例化到spring ioc容器中
 * @Import 加载其他类, 并实例化到spring ioc容器中
 */
@Configuration
@ComponentScan
@Import({ColorBlue.class, ColorRed.class, MyImportSelector.class, MyImportBeanDefinitionRegistrar.class, MyMapperAutoConfigureRegistrar.class})
public class AppConfig {

    /**
     * 以new的方式实例化到spring ioc容器中
     * @return
     */
    @Bean(initMethod = "initMethod", destroyMethod = "destroyMethod")
    public MySpringBean springBean() {
        return new MySpringBean();
    }
}
