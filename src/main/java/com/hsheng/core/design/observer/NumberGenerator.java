package com.hsheng.core.design.observer;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @description 观察者模式-生成数值的抽象类
 * @author hesheng
 * @date 2020/4/2 8:03
 * @since TODO
 */
public abstract class NumberGenerator {

    /**
     * 观察者列表
     */
    private ArrayList<Observer> observers = new ArrayList<>();

    /**
     * 注册观察者
     * @param observer
     */
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    /**
     * 删除观察者
     * @param observer
     */
    public void deleteObserver(Observer observer) {
        observers.remove(observer);
    }

    /**
     * 通知观察者
     */
    public void notifyObservers() {
        Iterator<Observer> it = observers.iterator();
        while (it.hasNext()) {
            Observer observer = it.next();
            observer.update(this);
        }
    }

    /**
     * 获取数值
     * @return
     */
    public abstract int getNumber();

    /**
     * 生成数值
     */
    public abstract void execute();
}
