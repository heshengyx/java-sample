package com.hsheng.core.design.strategy;

/**
 * @description 策略模式
 * @author hesheng
 * @date 2020/4/14 8:52
 * @since TODO
 */
public interface Strategy {

    Hand nextHand();

    void study(boolean win);
}
