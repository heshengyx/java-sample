package com.hsheng.core.design.callback;

/**
 * @description TODO
 * @author hesheng
 * @date 2020/2/20 9:42
 * @since TODO
 */
public class Client {

    public static void main(String[] args) {
        Manager manager = new Manager("张三");
        manager.arrange("完成数据库设计...");
        manager.doOtherWork();
    }
}
