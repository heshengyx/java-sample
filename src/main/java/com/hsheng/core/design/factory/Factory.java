package com.hsheng.core.design.factory;

/**
 * @description 工厂模式-抽象工厂
 * @author hesheng
 * @date 2020/1/8 8:35
 * @since TODO
 */
public abstract class Factory {

    /**
     * 创建产品
      * @param owner
     * @return
     */
    protected abstract Product createProduct(String owner);

    /**
     * 注册产品
     * @param product
     */
    protected abstract void registerProduct(Product product);

    /**
     * 创建产品
     * @param owner
     * @return
     */
    public final Product create(String owner) {
        Product product = createProduct(owner);
        registerProduct(product);
        return product;
    }
}
