package com.hsheng.core.design.decorator;

/**
 * @description 装饰器模式
 * @author hesheng
 * @date 2020/4/17 8:26
 * @since TODO
 */
public class StringDisplay extends Display {

    private String text;

    public StringDisplay(String text) {
        this.text = text;
    }

    @Override
    public int getColmuns() {
        return text.getBytes().length;
    }

    @Override
    public int getRows() {
        return 1;
    }

    @Override
    public String getRowText(int row) {
        if (row == 0) {
            return text;
        }
        return null;
    }
}
