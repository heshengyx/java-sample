package com.hsheng.core.design.listener;

/**
 * @description 广播器实现
 * @author hesheng
 * @date 2020/5/20 21:33
 * @since TODO
 */
public class WeatherEventMulticaster extends AbstractEventMulticaster {

    @Override
    void doStart() {
        System.out.println("开始广播天气事件");
    }

    @Override
    void doEnd() {
        System.out.println("结束广播天气事件");
    }
}
