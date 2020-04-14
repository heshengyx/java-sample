package com.hsheng.core.design.bridge;

/**
 * @description 桥接模式
 * @author hesheng
 * @date 2020/4/14 8:19
 * @since TODO
 */
public class StringDisplayImpl extends AbstDisplay {

    private String value;
    private int width;

    public StringDisplayImpl(String value) {
        this.value = value;
        this.width = value.getBytes().length;
    }

    @Override
    void rawOpen() {
        printLine();
    }

    @Override
    void rawPrint() {
        System.out.println("|" + value + "|");
    }

    @Override
    void rawClose() {
        printLine();
    }

    private void printLine() {
        System.out.print("+");
        for (int i = 0; i < width; i++) {
            System.out.print("-");
        }
        System.out.println("+");
    }
}
