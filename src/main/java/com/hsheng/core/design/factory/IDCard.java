package com.hsheng.core.design.factory;

/**
 * @description TODO
 * @author hesheng
 * @date 2020/1/8 8:38
 * @since TODO
 */
public class IDCard extends Product {

    private String owner;

    IDCard(String owner) {
        System.out.println("制作" + owner + "的ID卡");
        this.owner = owner;
    }

    @Override
    public void use() {
        System.out.println("使用" + owner + "的ID卡");
    }

    public String getOwner() {
        return owner;
    }
}
