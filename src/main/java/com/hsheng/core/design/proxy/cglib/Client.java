package com.hsheng.core.design.proxy.cglib;

/**
 * @description cglib动态代理测试类
 * @author hesheng
 * @date 2020/1/4 10:35
 * @since TODO
 */
public class Client {

    public static void main(String[] args) {
        CglibProxy proxy = new CglibProxy();

        SubjectImpl subject = proxy.getProxy(SubjectImpl.class);
        subject.thinking();
    }
}
