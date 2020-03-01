package com.hsheng.core.design.proxy.cglib;

import net.sf.cglib.core.DebuggingClassWriter;

/**
 * @description 代理模式-客户端
 * @author hesheng
 * @date 2020/1/4 10:35
 * @since TODO
 */
public class Client {

    public static void main(String[] args) {
        // 保存生成的代理类的字节码文件
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "D:/code");

        CglibProxy proxy = new CglibProxy();
        SubjectImpl subject = proxy.getProxy(SubjectImpl.class);
        subject.thinking();
    }
}
