package com.hsheng.core.design.factory.f1;

/**
 * @description 工厂类-枚举
 * @author hesheng
 * @date 2020/8/20 9:27
 * @since TODO
 */
public enum CarEnum1Factory {

    FORD_CAR,
    BUCK_CAR;

    /**
     * 生产产品
     * @return
     */
    public Car create() {
        switch (this) {
            case BUCK_CAR:
                return new BuckCar();
            case FORD_CAR:
                return new FordCar();
            default:
                return null;
        }
    }

    public static void main(String[] args) {
        CarEnum1Factory.FORD_CAR.create();
        CarEnum1Factory.BUCK_CAR.create();
    }
}
