package com.hsheng.core.design.command;

import java.util.Iterator;
import java.util.Stack;

/**
 * @description 命令模式-由多条命令整合成的命令
 * @author hesheng
 * @date 2020/4/10 8:04
 * @since TODO
 */
public class MacroCommand implements Command {

    private Stack<Command> commands = new Stack<>();

    @Override
    public void execute() {
        Iterator<Command> it = commands.iterator();
        while (it.hasNext()) {
            it.next().execute();
        }
    }

    /**
     * 添加命令
     * @param command
     */
    public void append(Command command) {
        if (command != this) {
            commands.push(command);
        }
    }

    /**
     * 删除最后一条命令
     */
    public void undo() {
        if (!commands.empty()) {
            commands.pop();
        }
    }

    /**
     * 删除所有命令
     */
    public void clear() {
        commands.clear();
    }
}
