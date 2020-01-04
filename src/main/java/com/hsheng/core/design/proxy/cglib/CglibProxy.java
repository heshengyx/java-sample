package com.hsheng.core.design.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 针对类来实现代理的，他的原理是对指定的目标类生成一个子类，并覆盖其中方法实现增强，
 * 但因为采用的是继承，所以不能对final修饰的类进行代理
 * @description cglib动态代理
 * @author hesheng
 * @date 2020/1/4 9:45
 * @since TODO
 */
public class CglibProxy implements MethodInterceptor {

    /**
     * 创建代理对象
     * @param clazz
     * @return
     */
    public <T> T getProxy(Class clazz) {
        //字节码增强
        Enhancer enhancer = new Enhancer();
        //设置父类
        enhancer.setSuperclass(clazz);
        //设置回调类
        enhancer.setCallback(this);
        //创建代理对象
        return (T) enhancer.create();
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("Do something before " + method.getName() + " by cglib proxy");
        Object result =  proxy.invokeSuper(obj, args);
        System.out.println("Do something after " + method.getName() + " by cglib proxy");
        return result;
    }
}
