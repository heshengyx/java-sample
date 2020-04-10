package com.hsheng.core.design.command;

import java.awt.*;

/**
 * @description 命令模式-绘制一个点命令
 * @author hesheng
 * @date 2020/4/10 8:09
 * @since TODO
 */
public class DrawCommand implements Command {

    protected Drawable drawable;

    private Point position;

    public DrawCommand(Drawable drawable, Point position) {
        this.drawable = drawable;
        this.position = position;
    }

    @Override
    public void execute() {
        drawable.draw(position.x, position.y);
    }
}
