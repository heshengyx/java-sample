package com.hsheng.core.design.prototype;

/**
 * @description TODO
 * @author hesheng
 * @date 2020/3/1 19:03
 * @since TODO
 */
public class Client {

    public static void main(String[] args) throws Exception {
        Subject subject1 = new Subject("zhangsan");
        Subject subject2 = (Subject) subject1.clone();
        System.out.println(subject1 == subject2);
        System.out.println(subject1);
        System.out.println(subject2);
    }
}
