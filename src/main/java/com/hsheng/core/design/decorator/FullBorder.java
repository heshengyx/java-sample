package com.hsheng.core.design.decorator;

/**
 * @description 装饰器模式
 * @author hesheng
 * @date 2020/4/17 8:35
 * @since TODO
 */
public class FullBorder extends Border {

    public FullBorder(Display display) {
        super(display);
    }

    @Override
    public int getColmuns() {
        return 1 + display.getColmuns() + 1;
    }

    @Override
    public int getRows() {
        return 1 + display.getRows() + 1;
    }

    @Override
    public String getRowText(int row) {
        if (row == 0) {
            return "+" + makeLine('-', display.getColmuns()) + "+";
        } else if (row == display.getRows() + 1) {
            return "+" + makeLine('-', display.getColmuns()) + "+";
        } else {
            return "|" + display.getRowText(row - 1) + "|";
        }
    }

    private String makeLine(char ch, int colmuns) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < colmuns; i++) {
            builder.append(ch);
        }
        return builder.toString();
    }
}
