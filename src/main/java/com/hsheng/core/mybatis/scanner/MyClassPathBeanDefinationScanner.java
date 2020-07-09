package com.hsheng.core.mybatis.scanner;

import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;

import java.util.Set;

/**
 * @description TODO
 * @author hesheng
 * @date 2020/6/25 12:52
 * @since TODO
 */
public class MyClassPathBeanDefinationScanner extends ClassPathBeanDefinitionScanner {

    public MyClassPathBeanDefinationScanner(BeanDefinitionRegistry registry) {
        super(registry);
    }

    /**
     * spring默认不会获取接口的bean定义，重写isCandidateComponent
     * 允许接口类的bean定义添加到BeanDefinitionMap中
     * @param beanDefinition
     * @return
     */
    @Override
    protected boolean isCandidateComponent(AnnotatedBeanDefinition beanDefinition) {
        return beanDefinition.getMetadata().isInterface();
    }

    @Override
    public Set<BeanDefinitionHolder> doScan(String... basePackages) {
        return super.doScan(basePackages);
    }
}
