package com.hsheng.core.design.proxy.jdk;

/**
 * @description 代理模式-客户端
 * @author hesheng
 * @date 2020/1/4 9:22
 * @since TODO
 */
public class Client {

    public static void main(String[] args) {
        // 保存生成的代理类的字节码文件
        //System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        //新版本JDK
        System.getProperties().put("jdk.proxy.ProxyGenerator.saveGeneratedFiles", "true");

        // jdk动态代理测试[$Proxy0@751]
        Subject subject = new JdkProxy(new SubjectImpl()).getProxy();
        subject.thinking();
    }
}
