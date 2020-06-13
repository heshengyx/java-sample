package com.hsheng.core.springboot.listener;

import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.annotation.Order;

/**
 * @description 第二个监听器
 * @author hesheng
 * @date 2020/6/13 22:13
 * @since TODO
 */
@Order(2)
public class SecondListener implements ApplicationListener<ApplicationStartedEvent> {

    @Override
    public void onApplicationEvent(ApplicationStartedEvent applicationStartedEvent) {
        System.out.println("Run SecondListener");
    }
}
