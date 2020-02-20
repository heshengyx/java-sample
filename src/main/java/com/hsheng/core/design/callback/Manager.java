package com.hsheng.core.design.callback;

/**
 * @description 实现回调接口
 * @author hesheng
 * @date 2020/2/20 8:35
 * @since TODO
 */
public class Manager implements Notice {

    private String name;

    public Manager(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    /**
     * 安排任务
     * @param task
     */
    public void arrange(String task) {
        new Programmer().receiveTask(task, this);
    }

    public void doOtherWork() {
        System.out.println("项目经理干其他事情...");
    }

    @Override
    public void noticeMe(String msg) {
        System.out.println(msg);
    }
}
