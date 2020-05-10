package com.hsheng.core.springboot.autoconfig.p1;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @description TODO
 * @author hesheng
 * @date 2020/5/10 18:50
 * @since TODO
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(HelloWorldConfiguration.class)
public @interface EnableHelloWorld {
}
