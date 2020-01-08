package com.hsheng.core.design.factory;

/**
 * @description TODO
 * @author hesheng
 * @date 2020/1/8 8:35
 * @since TODO
 */
public abstract class Factory {

    protected abstract Product createProduct(String owner);

    protected abstract void registerProduct(Product product);

    public final Product create(String owner) {
        Product product = createProduct(owner);
        registerProduct(product);
        return product;
    }
}
