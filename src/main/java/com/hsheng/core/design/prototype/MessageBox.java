package com.hsheng.core.design.prototype;

/**
 * @description 原型模式
 * @author hesheng
 * @date 2020/4/8 8:16
 * @since TODO
 */
public class MessageBox implements Product {

    private char decochar;

    public MessageBox(char decochar) {
        this.decochar = decochar;
    }

    @Override
    public void use(String s) {
        int length = s.getBytes().length;
        for (int i = 0; i < length; i++) {
            System.out.print(decochar);
        }
        System.out.println("");
        System.out.println(decochar + " " + s + " " + decochar);
        for (int i = 0; i < length; i++) {
            System.out.print(decochar);
        }
        System.out.println("");
    }

    @Override
    public Product createClone() {
        Product product = null;
        try {
            product = (Product) clone(); //复制实例
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return product;
    }
}
