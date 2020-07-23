package com.hsheng.core.inner.p1;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @description TODO
 * @author hesheng
 * @date 2020/7/9 10:41
 * @since TODO
 */
public class Controller {

    private List<Event> eventList = new CopyOnWriteArrayList<>();

    public void addEvent(Event event) {
        eventList.add(event);
    }

    public void run() {
        while (eventList.size() > 0) {
            for (Event e : eventList) {
                if (e.ready()) {
                    System.out.println(e);
                    e.action();
                    eventList.remove(e);
                }
            }
        }
    }
}
