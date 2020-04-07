package com.hsheng.core.design.observer;

import java.util.concurrent.TimeUnit;

/**
 * @description 观察者模式-字符形式显示数值
 * @author hesheng
 * @date 2020/4/3 8:05
 * @since TODO
 */
public class GraphObserver implements Observer {

    @Override
    public void update(NumberGenerator generator) {
        System.out.print("GraphObserver: ");
        int count = generator.getNumber();
        for (int i = 0; i < count; i++) {
            System.out.print("*");
        }
        System.out.println("");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
