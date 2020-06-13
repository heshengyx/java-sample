package com.hsheng.core.mybatis.scanner;

import org.springframework.beans.factory.BeanDefinitionStoreException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.context.annotation.ScannedGenericBeanDefinition;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.core.type.classreading.MetadataReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * @description 扫描指定包下的类
 * @author hesheng
 * @date 2020/6/9 14:13
 * @since TODO
 */
public class MyMapperScanner extends ClassPathBeanDefinitionScanner {

    public static final String DEFAULT_RESOURCE_PATTERN = "**/*.class";

    public MyMapperScanner(BeanDefinitionRegistry registry) {
        super(registry);
    }

    /**
     * 扫描指定包下的类，获得class类列表
     * @param basePackages
     * @return
     */
    public List<Class<?>> scan(String basePackages) {
        List<Class<?>> classes = new ArrayList<>();
        ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
        String packageSearchPath = "classpath*:" + this.resolveBasePackage(basePackages) + "/" + DEFAULT_RESOURCE_PATTERN;
        try {
            Resource[] resources = resourcePatternResolver.getResources(packageSearchPath);

            int length = resources.length;
            for (int i = 0; i < length; i++) {
                Resource resource = resources[i];

                if (resource.isReadable()) {
                    MetadataReader metadataReader = this.getMetadataReaderFactory().getMetadataReader(resource);
                    BeanDefinition beanDefinition = new ScannedGenericBeanDefinition(metadataReader);
                    classes.add(Class.forName(beanDefinition.getBeanClassName()));
                }
            }
        } catch (Exception e) {
            throw new BeanDefinitionStoreException("I/O failure during classpath scanning", e);
        }
        return classes;
    }

    public Set<BeanDefinitionHolder> doScan(String... basePackages) {
        Set<BeanDefinitionHolder> beanDefinitions = super.doScan(basePackages);
        if (beanDefinitions.isEmpty()) {
            /*LOGGER.warn(() -> {
                return "No MyBatis mapper was found in '" + Arrays.toString(basePackages) + "' package. Please check your configuration.";
            });*/
        } else {
            this.processBeanDefinitions(beanDefinitions);
        }

        ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
        String packageSearchPath = "classpath*:" + this.resolveBasePackage(basePackages[0]) + "/" + DEFAULT_RESOURCE_PATTERN;
        try {
            Resource[] resources = resourcePatternResolver.getResources(packageSearchPath);

            int length = resources.length;
            for (int i = 0; i < length; i++) {
                Resource resource = resources[i];

                if (resource.isReadable()) {
                    MetadataReader metadataReader = this.getMetadataReaderFactory().getMetadataReader(resource);
                    BeanDefinition beanDefinition = new ScannedGenericBeanDefinition(metadataReader);
                    System.out.println("beanDefinition.getBeanClassName()=" + beanDefinition.getBeanClassName());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return beanDefinitions;
    }

    private void processBeanDefinitions(Set<BeanDefinitionHolder> beanDefinitions) {
        Iterator<BeanDefinitionHolder> holderIterator = beanDefinitions.iterator();
        while(holderIterator.hasNext()) {
            BeanDefinitionHolder holder = holderIterator.next();
            System.out.println(holder.getBeanDefinition().getBeanClassName());
        }
    }
}
