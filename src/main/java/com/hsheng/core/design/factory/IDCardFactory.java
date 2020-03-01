package com.hsheng.core.design.factory;

import java.util.ArrayList;
import java.util.List;

/**
 * @description 工厂模式-具体工作
 * @author hesheng
 * @date 2020/1/8 8:38
 * @since TODO
 */
public class IDCardFactory extends Factory {

    private List<String> owners = new ArrayList<>();

    @Override
    protected Product createProduct(String owner) {
        return new IDCard(owner);
    }

    @Override
    protected void registerProduct(Product product) {
        owners.add(((IDCard)product).getOwner());
    }

    public List<String> getOwners() {
        return owners;
    }
}
