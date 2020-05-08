package com.hsheng.core.loader;

/**
 * 加载->连接（验证->准备->解析）->初始化
 * 加载：主要负责查找并且加载类的二进制数据文件，其实就是 class 文件
 * 验证：主要是确保类文件的正确性，比如 class 的版本， class 文件的魔术因子是 否正确。
 * 准备：为类的静态变量分配内存，并且为其初始化默认值。
 * 解析：把类中的符号引用转换为直接引用。
 * 初始化：为类的静态变量赋予正确的初始值（代码编写阶段给定的值） 执行＜clinit＞（）方法
 * @description TODO
 * @author hesheng
 * @date 2020/4/24 13:05
 * @since TODO
 */
public class StaticVar {

    /**
     * 使用这行，x=0 y=1
     */
    private static StaticVar loader = new StaticVar();
    private static int x = 0;
    private static int y;
    /**
     * 使用这行，x=1 y=1
     */
    //private static StaticVar loader = new StaticVar();

    private StaticVar() {
        x++;
        y++;
    }

    public static StaticVar getInstance() {
        return loader;
    }

    public static void main(String[] args) {
        StaticVar loader = StaticVar.getInstance();
        System.out.println(loader.x);
        System.out.println(loader.y);
    }
}
