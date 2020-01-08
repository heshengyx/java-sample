package com.hsheng.core.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @description TODO
 * @author hesheng
 * @date 2020/1/8 13:43
 * @since TODO
 */
public class MyMapperAutoConfigureRegistrar implements ImportBeanDefinitionRegistrar, ResourceLoaderAware, BeanFactoryAware {

    private ResourceLoader resourceLoader;

    private ConfigurableListableBeanFactory beanFactory;


    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    // 实现BeanFactoryAware的方法，设置BeanFactory
    // BeanFactoryAware接口的实现是用来暴露Spring的ConfigurableListableBeanFactory对象。
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        if (beanFactory instanceof ConfigurableListableBeanFactory) {
            this.beanFactory = (ConfigurableListableBeanFactory) beanFactory;
        }
    }

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        MyMapperBeanDefinitionScanner scanner = new MyMapperBeanDefinitionScanner(registry, false);
        scanner.setResourceLoader(resourceLoader);
        scanner.registerFilters();
        //scanner.addIncludeFilter(new AnnotationTypeFilter(Mapper.class));
        scanner.doScan("com.hsheng.core.spring.mapper");
    }
}
