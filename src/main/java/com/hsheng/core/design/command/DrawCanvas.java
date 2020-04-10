package com.hsheng.core.design.command;

import java.awt.*;

/**
 * @description 命令模式
 * @author hesheng
 * @date 2020/4/10 8:15
 * @since TODO
 */
public class DrawCanvas extends Canvas implements Drawable {

    private Color color = Color.red;

    private int radius = 6;

    private MacroCommand history;

    public DrawCanvas(int width, int height, MacroCommand history) {
        setSize(width, height);
        setBackground(Color.white);
        this.history = history;
    }

    @Override
    public void draw(int x, int y) {
        Graphics g = getGraphics();
        g.setColor(color);
        g.fillOval(x - radius, y - radius, radius * 2, radius * 2);
    }

    /**
     * 重新全部绘制
     * @param g
     */
    @Override
    public void paint(Graphics g) {
        history.execute();
    }
}
