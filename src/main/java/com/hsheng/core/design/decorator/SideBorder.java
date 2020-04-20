/**
 * @Copyright (c) 2019, Denali System Co., Ltd. All Rights Reserved.
 * Website: www.denalisystem.com | Email: marketing@denalisystem.com
 */
package com.hsheng.core.design.decorator;

/**
 * @description 装饰器模式
 * @author hesheng
 * @date 2020/4/17 8:30
 * @since TODO
 */
public class SideBorder extends Border {

    private char ch;

    public SideBorder(Display display, char ch) {
        super(display);
        this.ch = ch;
    }

    @Override
    public int getColmuns() {
        return 1 + display.getColmuns() + 1;
    }

    @Override
    public int getRows() {
        return display.getRows();
    }

    @Override
    public String getRowText(int row) {
        return ch + display.getRowText(row) + ch;
    }
}
