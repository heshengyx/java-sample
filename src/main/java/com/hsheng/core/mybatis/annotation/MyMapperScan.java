package com.hsheng.core.mybatis.annotation;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @description 扫描mapper包注解
 * @author hesheng
 * @date 2020/6/9 8:32
 * @since TODO
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Documented
//@Import(MyMapperBeanDefinitionRegistrar.class)
@Import(MyImportBeanDefinitionRegistrar.class)
public @interface MyMapperScan {

    String basePackage() default "";
}
