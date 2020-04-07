package com.hsheng.core.design.builder;

/**
 * @description 建造者模式
 * @author hesheng
 * @date 2020/4/7 8:17
 * @since TODO
 */
public class Director {

    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    /**
     * 编写文档
     */
    public void construct() {
        builder.makeTitle("Greeting"); //标题
        builder.makeString("从早上到下午"); //字符串
        builder.makeItems(new String[] {"早上好", "下午好"}); //条目
        builder.close(); //完成文档
    }
}
