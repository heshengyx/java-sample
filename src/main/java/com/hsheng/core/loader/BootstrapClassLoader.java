package com.hsheng.core.loader;

/**
 * @description 根加载器，要负责虚拟机核心类库的加载
 * @author hesheng
 * @date 2020/4/24 13:17
 * @since TODO
 */
public class BootstrapClassLoader {

    public static void main(String[] args) {
        System.out.println("Bootstrap:" + String.class.getClassLoader()); //null
        System.out.println(System.getProperty("sun.boot.class.path"));
    }
}
