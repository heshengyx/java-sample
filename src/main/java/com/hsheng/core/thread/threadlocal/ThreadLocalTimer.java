package com.hsheng.core.thread.threadlocal;

/**
 * @description 线程本地变量
 * @author hesheng
 * @date 2020/1/4 16:07
 * @since TODO
 */
public class ThreadLocalTimer {

    private final static ThreadLocal<Long> TIMES = new ThreadLocal<Long>() {
        @Override
        protected Long initialValue() {
            return System.currentTimeMillis();
        }
    };

    /**
     * 计时开始时间
     */
    public final static void begin() {
        TIMES.set(System.currentTimeMillis());
    }

    /**
     * 计算结束时长
     * @return
     */
    public final static long end() {
        return System.currentTimeMillis() - TIMES.get();
    }
}
