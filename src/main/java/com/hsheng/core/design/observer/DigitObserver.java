package com.hsheng.core.design.observer;

import java.util.concurrent.TimeUnit;

/**
 * @description 观察者模式-数字形式显示数值
 * @author hesheng
 * @date 2020/4/2 8:24
 * @since TODO
 */
public class DigitObserver implements Observer {

    @Override
    public void update(NumberGenerator generator) {
        System.out.println("*DigitObserver: " + generator.getNumber());
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
