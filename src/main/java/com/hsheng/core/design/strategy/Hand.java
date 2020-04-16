package com.hsheng.core.design.strategy;

/**
 * @description 策略模式
 * @author hesheng
 * @date 2020/4/14 8:53
 * @since TODO
 */
public class Hand {

    public static final int HAND_GUU = 0;
    public static final int HAND_CHO = 1;
    public static final int HAND_PAA = 2;

    public static final Hand[] hands = {new Hand(HAND_GUU), new Hand(HAND_CHO), new Hand(HAND_PAA)};
    private static final String[] names = {"石头", "剪刀", "布"};
    private int handVal;

    private Hand(int handVal) {
        this.handVal = handVal;
    }

    public static Hand getHand(int handVal) {
        return hands[handVal];
    }

    public boolean isStrongerThan(Hand hand) {
        return fight(hand) == 1;
    }

    public boolean isWrakerThan(Hand hand) {
        return fight(hand) == -1;
    }

    private int fight(Hand hand) {
        if (this == hand) {
            return 0;
        } else if ((this.handVal + 1) % 3 == hand.handVal) {
            return 1;
        } else {
            return -1;
        }
    }
}
