package com.hsheng.core.design.strategy;

/**
 * @description 策略模式
 * @author hesheng
 * @date 2020/4/15 8:36
 * @since TODO
 */
public class Client {

    public static void main(String[] args) {
        Player player1 = new Player("Taro", new WinningStrategy(100));
        Player player2 = new Player("Hana", new ProbStrategy(200));

        for (int i = 0; i < 10000; i++) {
            Hand nextHand1 = player1.nextHand();
            Hand nextHand2 = player2.nextHand();
        }
    }
}
