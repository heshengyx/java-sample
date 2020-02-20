package com.hsheng.core.design.callback;

import java.util.concurrent.TimeUnit;

/**
 * @description TODO
 * @author hesheng
 * @date 2020/2/20 8:38
 * @since TODO
 */
public class Programmer {

    Notice notice;

    /**
     * 接受任务
     * @param task
     * @param notice
     */
    public void receiveTask(String task, Notice notice) {
        this.notice = notice;
        try {
            //程序员开始执行任务
            this.excuteTask(task);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 任务执行
     * @param task
     * @throws InterruptedException
     */
    private void excuteTask(String task) throws InterruptedException {
        System.out.println("执行项目经理：安排的任务-->" + task);
        //任务执行中
        TimeUnit.SECONDS.sleep(1);
        //任务完成
        this.finished(task);
    }

    /**
     * 任务完成
     * @param task
     */
    private void finished(String task) {
        notice.noticeMe("你好，你安排的任务" + task + "已经完成！");
    }
}
