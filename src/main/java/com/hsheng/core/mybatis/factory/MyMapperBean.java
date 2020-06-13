package com.hsheng.core.mybatis.factory;

import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @description 通过factoryBean注入到spring ioc容器中
 * @author hesheng
 * @date 2020/6/9 8:27
 * @since TODO
 */
public class MyMapperBean implements FactoryBean {

    private Class<?> mapperInterface;

    public MyMapperBean(Class<?> mapperInterface) {
        this.mapperInterface = mapperInterface;
    }

    @Override
    public Object getObject() throws Exception {
        /**
         * JDK动态代理
         */
        Object obj = Proxy.newProxyInstance(MyMapperBean.class.getClassLoader(), new Class[] { mapperInterface }, new InvocationHandler() {

            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if (Object.class.equals(method.getDeclaringClass())) {
                    return method.invoke(this, args);
                }
                System.out.println(method.getName());
                return null;
            }
        });
        return obj;
    }

    @Override
    public Class<?> getObjectType() {
        return mapperInterface;
    }
}
