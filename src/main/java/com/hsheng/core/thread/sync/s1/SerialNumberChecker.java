package com.hsheng.core.thread.sync.s1;

import java.util.concurrent.CompletableFuture;

/**
 * @description TODO
 * @author hesheng
 * @date 2020/7/27 9:42
 * @since TODO
 */
public class SerialNumberChecker implements Runnable {

    private CircularSet serials = new CircularSet(1000);
    private SerialNumbers producer;
    public SerialNumberChecker(SerialNumbers producer) {
        this.producer = producer;
    }

    @Override
    public void run() {
        while(true) {
            int serial = producer.nextSerialNumber();
            if(serials.contains(serial)) {
                System.out.println("Duplicate: " + serial);
                System.exit(0);
            }
            serials.add(serial);
        }
    }

    static void test(SerialNumbers producer) {
        for(int i = 0; i < 10; i++)
            CompletableFuture.runAsync(
                    new SerialNumberChecker(producer));
        //new Nap(4, "No duplicates detected");
    }

    public static void main(String[] args) {
        //SerialNumberChecker.test(new SerialNumbers());
        //SerialNumberChecker.test(new SynchronizedSerialNumbers());
        SerialNumberChecker.test(new AtomicSerialNumbers());
    }
}
