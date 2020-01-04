package com.hsheng.core.spi;

import java.util.ServiceLoader;

/**
 * @description TODO
 * @author hesheng
 * @date 2020/1/4 14:26
 * @since TODO
 */
public class Client {

    public static void main(String[] args) {
        ServiceLoader<Animal> animals = ServiceLoader.load(Animal.class);
        for (Animal animal: animals) {
            animal.shout();
        }
    }
}
