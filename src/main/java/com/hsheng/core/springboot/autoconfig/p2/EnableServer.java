package com.hsheng.core.springboot.autoconfig.p2;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @description TODO
 * @author hesheng
 * @date 2020/5/10 19:05
 * @since TODO
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
//@Import(ServerImportSelector.class)
@Import(ServerImportBeanDefinitionRegistrar.class)
public @interface EnableServer {

    /**
     * 服务器类型
     * @return
     */
    Server.Type type() default Server.Type.HTTP;
}
