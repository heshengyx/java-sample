package com.hsheng.core.design.callback;

/**
 * @description TODO
 * @author hesheng
 * @date 2020/2/20 8:38
 * @since TODO
 */
public class Programmer {

    /**
     * 声明回调对象
     */
    private Notice notice;

    /**
     * 定义回调接口
     */
    interface Notice {
        void noticeMe(String msg);
    }

    /**
     * 设置回调对象
     * @param notice
     */
    public void setNotice(Notice notice) {
        this.notice = notice;
    }

    /**
     * 接受任务
     * @param task
     */
    public void receiveTask(String task) {
        //程序员开始执行任务
        this.excuteTask(task);
    }

    /**
     * 任务执行
     * @param task
     * @throws InterruptedException
     */
    private void excuteTask(String task) {
        System.out.println("执行项目经理：安排的任务-->" + task);
        //任务执行中
        //TimeUnit.SECONDS.sleep(1);
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
