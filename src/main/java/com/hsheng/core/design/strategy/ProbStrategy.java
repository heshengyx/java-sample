package com.hsheng.core.design.strategy;

import java.util.Random;

/**
 * @description 策略模式
 * @author hesheng
 * @date 2020/4/14 8:55
 * @since TODO
 */
public class ProbStrategy implements Strategy {

    private Random random;

    public ProbStrategy(int seed) {
        this.random = new Random(seed);
    }

    @Override
    public Hand nextHand() {
        return null;
    }

    @Override
    public void study(boolean win) {

    }
}
