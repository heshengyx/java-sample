package com.hsheng.core.disruptor.d2;

/**
 * @description TODO
 * @author hesheng
 * @date 2020/5/30 20:02
 * @since TODO
 */
public class Order {

    private String id;

    private String name;

    private double price;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
