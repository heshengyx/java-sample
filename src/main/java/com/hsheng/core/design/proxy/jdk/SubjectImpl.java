package com.hsheng.core.design.proxy.jdk;

/**
 * @description 真实主题类
 * @author hesheng
 * @date 2020/1/4 9:15
 * @since TODO
 */
public class SubjectImpl implements Subject {

    @Override
    public void thinking() {
        System.out.println("SubjectImpl do thinking");
    }
}
