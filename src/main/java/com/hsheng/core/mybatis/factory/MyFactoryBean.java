package com.hsheng.core.mybatis.factory;

import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @description 通过factoryBean注入到spring ioc容器中
 * @author hesheng
 * @date 2020/6/9 15:27
 * @since TODO
 */
public class MyFactoryBean<T> implements FactoryBean<T> {

    private Class<T> mapperInterface;

    public MyFactoryBean(Class<T> mapperInterface) {
        this.mapperInterface = mapperInterface;
    }

    @Override
    public T getObject() throws Exception {
        /**
         * JDK动态代理
         */
        T obj = (T) Proxy.newProxyInstance(MyMapperBean.class.getClassLoader(), new Class[] { mapperInterface }, new InvocationHandler() {

            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //toString方法直接放行
                if (Object.class.equals(method.getDeclaringClass())) {
                    return method.invoke(this, args);
                } else if (method.isDefault()) { //如果是接口中默认方法

                }
                System.out.println(method.getName());
                return null;
            }
        });
        return obj;

    }

    @Override
    public Class<?> getObjectType() {
        return this.mapperInterface;
    }
}
