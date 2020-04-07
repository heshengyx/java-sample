package com.hsheng.core.design.observer;

import java.util.Random;

/**
 * @description 观察者模式-生成随机数
 * @author hesheng
 * @date 2020/4/2 8:14
 * @since TODO
 */
public class RandomNumberGenerator extends NumberGenerator {

    /**
     * 随机数生成器
     */
    private Random random = new Random();

    /**
     * 当前数值
     */
    private int number;

    @Override
    public int getNumber() {
        return number;
    }

    @Override
    public void execute() {
        for (int i = 0; i < 20; i++) {
            number = random.nextInt(50);
            notifyObservers();
        }
    }
}
