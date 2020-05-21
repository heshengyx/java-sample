package com.hsheng.core.design.listener;

/**
 * @description 事件监听
 * @author hesheng
 * @date 2020/5/20 21:20
 * @since TODO
 */
public class RainEvent extends WeatherEvent {

    @Override
    String getWeather() {
        return "rain";
    }
}
