package com.hsheng.core.mybatis.annotation;

import com.hsheng.core.mybatis.factory.MyFactoryBean;
import com.hsheng.core.mybatis.scanner.MyClassPathBeanDefinationScanner;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;
import java.util.Set;

/**
 * @description TODO
 * @author hesheng
 * @date 2020/6/25 12:37
 * @since TODO
 */
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry registry) {
        /**
         * 获取指定注解信息
         */
        AnnotationAttributes attributes = AnnotationAttributes.fromMap(annotationMetadata.getAnnotationAttributes(MyMapperScan.class.getName()));
        if (attributes != null) {
            String basePackage = attributes.getString("basePackage");

            //创建自定义扫描器
            MyClassPathBeanDefinationScanner scanner = new MyClassPathBeanDefinationScanner(registry);
            //添加过滤条件
            scanner.addIncludeFilter(new TypeFilter() {
                @Override
                public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
                    //
                    return true;
                }
            });

            //扫描指定包下的接口类
            Set<BeanDefinitionHolder> beanDefinitionHolders = scanner.doScan(basePackage);
            for (BeanDefinitionHolder beanDefinitionHolder : beanDefinitionHolders) {
                GenericBeanDefinition beanDefinition = (GenericBeanDefinition) beanDefinitionHolder.getBeanDefinition();
                //获取mapper接口类名com.hsheng.core.mybatis.mapper.OrderMapper
                String className = beanDefinition.getBeanClassName();

                //所有mapper接口类都实例化为targetClass代理类
                beanDefinition.setBeanClass(MyFactoryBean.class);

                //设置MyFactoryBean的属性mapperInterface为mapper接口类
                beanDefinition.getConstructorArgumentValues().addGenericArgumentValue(className);
            }
        }
    }
}
