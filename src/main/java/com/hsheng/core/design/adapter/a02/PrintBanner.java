package com.hsheng.core.design.adapter.a02;

/**
 * @description 委托的适配器
 * @author hesheng
 * @date 2020/1/7 17:10
 * @since TODO
 */
public class PrintBanner extends Print {

    private Banner banner;

    public PrintBanner(String name) {
        this.banner = new Banner(name);
    }

    @Override
    void printWeak() {
        banner.showWithParen();
    }

    @Override
    void printStrong() {
        banner.showWithAster();
    }
}
