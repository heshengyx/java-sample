package com.hsheng.core.design.composite;

/**
 * @description composite模式
 * @author hesheng
 * @date 2020/4/16 8:32
 * @since TODO
 */
public class Client {

    public static void main(String[] args) {
        System.out.println("Making root entries...");
        MyDirectory rootdir = new MyDirectory("root");
        MyDirectory bindir = new MyDirectory("bin");
        MyDirectory tmpdir = new MyDirectory("tmp");
        MyDirectory usrdir = new MyDirectory("usr");

        rootdir.add(bindir);
        rootdir.add(tmpdir);
        rootdir.add(usrdir);

        bindir.add(new MyFile("vi", 10000));
        bindir.add(new MyFile("lates", 20000));
        rootdir.printList();
    }
}
