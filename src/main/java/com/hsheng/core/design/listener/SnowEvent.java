package com.hsheng.core.design.listener;

/**
 * @description 事件监听
 * @author hesheng
 * @date 2020/5/20 21:19
 * @since TODO
 */
public class SnowEvent extends WeatherEvent {

    @Override
    String getWeather() {
        return "snow";
    }
}
