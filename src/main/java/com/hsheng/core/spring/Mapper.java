package com.hsheng.core.spring;

import java.lang.annotation.*;

/**
 * @description 自定义Mapper注解
 * @author hesheng
 * @date 2020/1/8 13:35
 * @since TODO
 */
@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
public @interface Mapper {
}
