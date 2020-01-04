package com.hsheng.core.design.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 只能代理实现了接口的类，而不能实现接口的类就不能实现JDK的动态代理
 * @description jdk动态代理
 * @author hesheng
 * @date 2020/1/4 9:17
 * @since TODO
 */
public class JdkProxy implements InvocationHandler {

    /**
     * 目标类(被代理类)
     */
    private Object target;

    public JdkProxy(Object target) {
        this.target = target;
    }

    /**
     * 获取被代理接口实例对象(生成代理类)
     * @param <T>
     * @return
     */
    public <T> T getProxy() {
        return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Do something before " + method.getName() + " by jdk proxy");
        Object result = method.invoke(target, args);
        System.out.println("Do something after " + method.getName() + " by jdk proxy");
        return result;
    }
}
