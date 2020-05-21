package com.hsheng.core.design.listener;

/**
 * @description TODO
 * @author hesheng
 * @date 2020/5/20 21:22
 * @since TODO
 */
public class SnowListener implements WeatherListener {

    @Override
    public void onWeatherEvent(WeatherEvent event) {
        if (event instanceof SnowEvent) {
            System.out.println("hello " + event.getWeather());
        }
    }
}
