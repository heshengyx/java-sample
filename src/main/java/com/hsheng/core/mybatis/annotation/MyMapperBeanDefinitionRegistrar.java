package com.hsheng.core.mybatis.annotation;

import com.hsheng.core.mybatis.factory.MyFactoryBean;
import com.hsheng.core.mybatis.scanner.MyMapperScanner;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;

import java.util.List;

/**
 * class -> beanDefinition -> BeanFactoryPostProcessor -> bean -> BeanPostProcessor
 * @description 通过beanDefinition注册到spring ioc容器中
 * @author hesheng
 * @date 2020/6/9 10:25
 * @since TODO
 */
public class MyMapperBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry registry) {
        /**
         * 获取指定注解信息
         */
        AnnotationAttributes attributes = AnnotationAttributes.fromMap(annotationMetadata.getAnnotationAttributes(MyMapperScan.class.getName()));
        if (attributes != null) {
            this.registerBeanDefinitions(attributes, registry);
        }

        /*Map<String, Object> annotationAttributes = annotationMetadata.getAnnotationAttributes(MyMapperScan.class.getName());
        Object obj = annotationAttributes.get("value");
        System.out.println("obj=" + obj); //obj=com.hsheng.core.mybatis.mapper*/

        /*List<Class<?>> mappers = new ArrayList<>();
        mappers.add(UserMapper.class);
        mappers.add(OrderMapper.class);

        mappers.stream().forEach(mapper -> {

            //1、获取beanDefinition
            BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition();
            AbstractBeanDefinition beanDefinition = builder.getBeanDefinition();

            //2、设置beanClass
            //beanDefinition.setBeanClass(MyMapperBean.class);
            beanDefinition.setBeanClass(MyFactoryBean.class);
            //3、构造函数赋值
            beanDefinition.getConstructorArgumentValues().addGenericArgumentValue(mapper);

            //把bean注入到spring ioc容器中
            registry.registerBeanDefinition(mapper.getName(), beanDefinition);
        });*/

    }

    private void registerBeanDefinitions(AnnotationAttributes attributes, BeanDefinitionRegistry registry) {
        MyMapperScanner scanner = new MyMapperScanner(registry);
        String basePackage = attributes.getString("basePackage");
        List<Class<?>> classes = scanner.scan(basePackage);
        classes.stream().forEach(clazz -> {
            //1、获取beanDefinition
            BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(MyFactoryBean.class);
            AbstractBeanDefinition beanDefinition = builder.getBeanDefinition();

            //2、设置beanClass
            //beanDefinition.setBeanClass(MyMapperBean.class);
            //beanDefinition.setBeanClass(MyFactoryBean.class);
            //3、构造函数赋值
            beanDefinition.getConstructorArgumentValues().addGenericArgumentValue(clazz);

            //把bean注入到spring ioc容器中
            registry.registerBeanDefinition(clazz.getName(), beanDefinition);
        });
    }
}
