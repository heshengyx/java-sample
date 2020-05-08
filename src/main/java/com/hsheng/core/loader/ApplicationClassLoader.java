package com.hsheng.core.loader;

/**
 * @description 系统类加载器sun.misc.Launcher$AppClassLoader@18b4aac2
 * @author hesheng
 * @date 2020/4/24 13:53
 * @since TODO
 */
public class ApplicationClassLoader {

    public static void main(String[] args) {
        System.out.println(System.getProperty("java.class.path"));
        System.out.println(ApplicationClassLoader.class.getClassLoader());
    }
}
