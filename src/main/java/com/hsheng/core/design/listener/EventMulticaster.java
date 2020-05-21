package com.hsheng.core.design.listener;

/**
 * @description 事件广播器
 * @author hesheng
 * @date 2020/5/20 21:26
 * @since TODO
 */
public interface EventMulticaster {

    /**
     * 广播事件
     * @param event
     */
    void multicastEvent(WeatherEvent event);

    /**
     * 添加监听器
     * @param listener
     */
    void addListener(WeatherListener listener);

    /**
     * 删除监听器
     * @param listener
     */
    void removeListener(WeatherListener listener);
}
