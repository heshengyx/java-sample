package com.hsheng.core.thread.sync;

/**
 * 每一个实例拥有各自独立的锁
 * 可以通过boolean flag = Thread.holdsLock(obj)方法来确认当前线程是否获取某一对象的锁
 * @description 线程同步
 * @author hesheng
 * @date 2020/4/20 8:26
 * @since TODO
 */
public class Bank {

    private int money;
    private String name;

    public Bank(String name, int money) {
        this.name = name;
        this.money = money;
    }

    /**
     * 存款 同步方法, 使用对象锁
     * @param money
     */
    public synchronized void deposit(int money) {
        this.money += money;
    }

    /**
     * 使用this的锁, 等效于deposit
     * @param money
     */
    public void deposit1(int money) {
        //使用this的锁
        synchronized (this) {
            this.money += money;
        }
    }

    /**
     * 静态方法使用类对象的锁, 与对象锁使用的不是同一个锁
     * @param money
     */
    public static synchronized void deposit2(int money) {
        System.out.println("deposit money");
    }

    /**
     * 静态代码块使用类对象的锁, 等效于deposit2
     * @param money
     */
    public static void deposit3(int money) {
        //Bank.class是Bank类对应的java.lang.class类的实例
        synchronized (Bank.class) {
            System.out.println("deposit money");
        }
    }

    /**
     * 取款 同步方法
     * @param money
     * @return
     */
    public synchronized boolean withdraw(int money) {
        if (this.money >= money) {
            this.money -= money;
            return true;
        }
        return false;
    }

    public String getName() {
        return this.name;
    }
}
