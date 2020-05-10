package com.hsheng.core.springboot.autoconfig.p2;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.stream.Stream;

/**
 * @description TODO
 * @author hesheng
 * @date 2020/5/10 19:29
 * @since TODO
 */
public class ServerImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        ImportSelector importSelector = new ServerImportSelector();
        String[] selectedClassNames = importSelector.selectImports(importingClassMetadata);
        Stream.of(selectedClassNames)
                //转化为BeanDefinitionBuilder对象
                .map(BeanDefinitionBuilder::genericBeanDefinition)
                //转化为BeanDefinition对象
                .map(BeanDefinitionBuilder::getBeanDefinition)
                .forEach(beanDefinition -> BeanDefinitionReaderUtils.registerWithGeneratedName(beanDefinition, registry));
    }
}
