package com.hsheng.core.design.adapter.a01;

/**
 * @description 继承的适配器
 * @author hesheng
 * @date 2020/1/7 17:01
 * @since TODO
 */
public class PrintBanner extends Banner implements Print {

    public PrintBanner(String name) {
        super(name);
    }

    @Override
    public void printWeak() {
        showWithParen();
    }

    @Override
    public void printStrong() {
        showWithAster();
    }
}
