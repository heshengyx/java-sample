package com.hsheng.core.stream;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

/**
 * @description TODO
 * @author hesheng
 * @date 2020/5/27 8:41
 * @since TODO
 */
public class Java8List {

    public static void main(String[] args) {
        List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH));
        List<String> names = menu.parallelStream() //menu.stream()
                .filter(d -> d.getCalories() < 800) //选出800卡路里以下的菜肴
                .sorted(comparing(Dish::getCalories)) //按照卡路里排序
                .map(Dish::getName) //提取菜肴名称
                .collect(toList()); //将名称保存到list中
        for (String name: names) {
            System.out.println(name);
        }

        //按类型分组
        Map<Dish.Type, List<Dish>> dishes = menu.stream().collect(groupingBy(Dish::getType));
        System.out.println(JSON.toJSONString(dishes));
    }
}
