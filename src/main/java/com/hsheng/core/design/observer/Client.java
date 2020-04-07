package com.hsheng.core.design.observer;

/**
 * @description 观察者模式-客户端
 * @author hesheng
 * @date 2020/4/2 8:31
 * @since TODO
 */
public class Client {

    public static void main(String[] args) {
        NumberGenerator generator = new RandomNumberGenerator();
        Observer observer1 = new DigitObserver();
        Observer observer2 = new GraphObserver();
        generator.addObserver(observer1);
        generator.addObserver(observer2);
        generator.execute();
    }
}
