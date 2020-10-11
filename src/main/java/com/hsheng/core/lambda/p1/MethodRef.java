/**
 * @Copyright (c) 2019, Denali System Co., Ltd. All Rights Reserved.
 * Website: www.denalisystem.com | Email: marketing@denalisystem.com
 */
package com.hsheng.core.lambda.p1;

import java.util.function.*;

/**
 * @description 方法引用
 * @author hesheng
 * @date 2020/10/11 16:33
 * @since TODO
 */
class Dog {

    private String name = "狼狼";
    private int food = 10;

    public Dog() {}

    public Dog(String name) {
        this.name = name;
    }

    public static void bark(Dog dog) {
        System.out.println(dog + "叫了");
    }

    //public int eat(Dog this, int num) 相等于 eat(int num)
    public int eat(int num) {
        System.out.println("吃了" + num + "斤");
        this.food -= num;
        return this.food;
    }

    @Override
    public String toString() {
        return this.name;
    }
}

public class MethodRef {

    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.eat(1);

        //方法引用
        Consumer<String> consumer1 = System.out::println;
        consumer1.accept("Hello");

        //静态方法的方法引用
        Consumer<Dog> consumer2 = Dog::bark;
        consumer2.accept(dog);

        //非静态方法
        //Function<Integer, Integer> fun1 = dog::eat;
        //UnaryOperator<Integer> fun1 = dog::eat;
        //System.out.println("还剩下" + fun1.apply(2) + "斤");
        IntUnaryOperator fun1 = dog::eat;
        System.out.println("还剩下" + fun1.applyAsInt(2) + "斤");

        //使用类名的方法应用
        BiFunction<Dog, Integer, Integer> fun2 = Dog::eat;
        System.out.println("还剩下" + fun2.apply(dog, 2) + "斤");

        //无参构造函数的方法应用, Dog是构造类型
        Supplier<Dog> supplier1 = Dog::new;
        System.out.println("创建对象：" + supplier1.get());

        //有参构造函数的方法应用
        Function<String, Dog> supplier2 = Dog::new;
        System.out.println("创建对象：" + supplier2.apply("旺财"));
    }
}
