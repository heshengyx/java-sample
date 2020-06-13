package com.hsheng.core.springboot.listener;

import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.annotation.Order;

/**
 * @description 第一个监听器
 * @author hesheng
 * @date 2020/6/13 22:13
 * @since TODO
 */
@Order(1)
public class FirstListener implements ApplicationListener<ApplicationStartedEvent> {

    @Override
    public void onApplicationEvent(ApplicationStartedEvent applicationStartedEvent) {
        System.out.println("Run FirstListener");
    }
}
