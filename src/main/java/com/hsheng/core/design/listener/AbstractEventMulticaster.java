package com.hsheng.core.design.listener;

import java.util.ArrayList;
import java.util.List;

/**
 * @description 抽象事件广播器
 * @author hesheng
 * @date 2020/5/20 21:29
 * @since TODO
 */
public abstract class AbstractEventMulticaster implements EventMulticaster {

    private List<WeatherListener> listeners = new ArrayList<>();

    @Override
    public void multicastEvent(WeatherEvent event) {
        doStart();
        listeners.forEach(i -> i.onWeatherEvent(event));
        doEnd();
    }

    @Override
    public void addListener(WeatherListener listener) {
        listeners.add(listener);
    }

    @Override
    public void removeListener(WeatherListener listener) {
        listeners.remove(listener);
    }

    abstract void doStart();

    abstract void doEnd();
}
