package com.hsheng.core.design.factory.f1;

/**
 * @description 工厂类-枚举
 * @author hesheng
 * @date 2020/8/20 9:35
 * @since TODO
 */
public enum CarEnum2Factory {

    FORD_CAR {

        @Override
        Car create() {
            return new FordCar();
        }
    },

    BUCK_CAR {

        @Override
        Car create() {
            return new BuckCar();
        }
    };

    /**
     * 抽象方法
     */
    abstract Car create();

    public static void main(String[] args) {
        CarEnum1Factory.FORD_CAR.create();
        CarEnum1Factory.BUCK_CAR.create();
    }
}
