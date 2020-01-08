package com.hsheng.core.spring;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @description TODO
 * @author hesheng
 * @date 2020/1/8 11:00
 * @since TODO
 */
@Component
public class MyFactoryBean implements FactoryBean {

    @Override
    public Object getObject() throws Exception {
        /**
         * JDK动态代理
         */
        Object obj = Proxy.newProxyInstance(MyMapper.class.getClassLoader(), new Class[] { MyMapper.class }, new MyInvocationHandler());
        return obj;
    }

    @Override
    public Class<?> getObjectType() {
        return MyMapper.class;
    }
}

class MyInvocationHandler implements InvocationHandler {

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String name = method.getName();
        System.out.println("method name: " + name);
        return "invoke " + name;
    }
}