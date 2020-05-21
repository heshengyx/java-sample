package com.hsheng.core.design.listener;

/**
 * @description 事件监听
 * @author hesheng
 * @date 2020/5/20 21:24
 * @since TODO
 */
public class RainListener implements WeatherListener {

    @Override
    public void onWeatherEvent(WeatherEvent event) {
        if (event instanceof RainEvent) {
            System.out.println("hello " + event.getWeather());
        }
    }
}
