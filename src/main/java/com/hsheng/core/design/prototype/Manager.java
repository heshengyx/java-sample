package com.hsheng.core.design.prototype;

import java.util.HashMap;
import java.util.Map;

/**
 * @description 原型模式
 * @author hesheng
 * @date 2020/4/8 8:12
 * @since TODO
 */
public class Manager {

    private Map<String, Product> showcase = new HashMap<>();

    public void register(String name, Product proto) {
        showcase.put(name, proto);
    }

    public Product create(String protoname) {
        Product product = showcase.get(protoname);
        return product.createClone();
    }
}
