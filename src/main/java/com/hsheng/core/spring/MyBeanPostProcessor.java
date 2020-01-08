package com.hsheng.core.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @description TODO
 * @author hesheng
 * @date 2020/1/8 9:29
 * @since TODO
 */
@Component
public class MyBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("===postProcessBeforeInitialization===" + beanName);
        if(beanName.equals("springBean")) {
            System.out.println("postProcessBeforeInitialization");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("===postProcessAfterInitialization===" + beanName);
        if(beanName.equals("springBean")) {
            System.out.println("postProcessAfterInitialization");
        }
        return bean;
    }
}
