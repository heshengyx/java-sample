package com.hsheng.core.inner.p1;

import java.time.Duration;
import java.time.Instant;

/**
 * @description TODO
 * @author hesheng
 * @date 2020/7/9 10:38
 * @since TODO
 */
public abstract class Event {

    private Instant eventTime;
    protected final Duration delayTime;

    public Event(long millisecondDelay) {
        this.delayTime = Duration.ofMillis(millisecondDelay);
        start();
    }

    public void start() {
        eventTime = Instant.now().plus(delayTime);
    }

    public boolean ready() {
        return Instant.now().isAfter(eventTime);
    }

    public abstract void action();
}
