package com.hsheng.core.stream;

import java.util.*;

/**
 * @description TODO
 * @author hesheng
 * @date 2020/5/27 8:28
 * @since TODO
 */
public class Java7List {

    public static void main(String[] args) {
        List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH));

        //选出卡路里小于800的菜肴
        List<Dish> dishes = new ArrayList<>();
        for (Dish d: menu) {
            if (d.getCalories() < 800) {
                dishes.add(d);
            }
        }

        //按卡路里升序对菜肴进行排序
        Collections.sort(dishes, new Comparator<Dish>() {
            @Override
            public int compare(Dish d1, Dish d2) {
                return Integer.compare(d1.getCalories(), d2.getCalories());
            }
        });

        //输出菜肴名称
        List<String> names = new ArrayList<>();
        for (Dish d: dishes) {
            names.add(d.getName());
        }

        for (String name: names) {
            System.out.println(name);
        }
    }
}
