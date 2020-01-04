package com.hsheng.core.spi;

/**
 * @description TODO
 * @author hesheng
 * @date 2020/1/4 14:23
 * @since TODO
 */
public class Dog implements Animal {

    @Override
    public void shout() {
        System.out.println("wang wang");
    }
}
