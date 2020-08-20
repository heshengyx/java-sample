package com.hsheng.core.design.factory.f1;

/**
 * @description 工厂类
 * @author hesheng
 * @date 2020/8/20 9:21
 * @since TODO
 */
public final class CarFactory {

    /**
     * 生产产品
     * @param car
     * @return
     */
    public static Car create(Class<? extends Car> car) {
        try {
            return (Car) car.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

/**
 * 抽象产品
 */
interface Car {}

/**
 * 具体产品
 */
class FordCar implements Car {}

/**
 * 具体产品
 */
class BuckCar implements Car {}
