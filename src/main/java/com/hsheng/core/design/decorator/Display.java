package com.hsheng.core.design.decorator;

/**
 * @description 装饰器模式
 * @author hesheng
 * @date 2020/4/17 8:21
 * @since TODO
 */
public abstract class Display {

    public abstract int getColmuns(); //获取横向字符数
    public abstract int getRows(); //获取纵向行数
    public abstract String getRowText(int row); //获取第row行字符串

    public final void show() {
        for (int i = 0; i < getRows(); i++) {
            System.out.println(getRowText(i));
        }
    }
}
